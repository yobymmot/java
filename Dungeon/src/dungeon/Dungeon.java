
package dungeon;
import java.util.*;

//Make health go down


public class Dungeon {
    private static String dec;
    private static String[] commands = {"fight","heal","run"};
    private static String[] itemDrop = {"gold","health potion","upgrade"};
    private static boolean playing = true;
    private static Scanner sc = new Scanner(System.in);
    private static Random rnd = new Random();
    private static int x = 0;
    private static int y = 0;
    private static int total = 0;
    private static boolean boss;
    private static boolean mega; //comming soon
    private static int[][] grid = new int[][]{
  { 0, 1, 0, 0, 1, 0, 0, 0, 0, 2 }, //1 - Chests //2 - Monsters //3 - The Key //4 - The way out //5 - The Boss?
  { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 1, 0, 1, 0, 0, 2 },
  { 0, 0, 0, 2, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 3, 0, 0, 1, 0, 0, 2, 0 },
  { 5, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
  { 0, 2, 0, 1, 0, 3, 0, 0, 0, 0 },
  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
  { 0, 0, 0, 1, 0, 0, 0, 0, 4, 1 },
  { 0, 0, 1, 0, 0, 2, 0, 1, 0, 0 }
};
    
    public static void map(){
        String[][] map = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j]="0 ";
                map[x][y]="@ ";
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        try{
            double health = 80;
            double damageBonus = 1;
            int lootBonus = 1;
            System.out.println("Welcome to Dungeon Escape");
            System.out.println("The objective of the game is to get enough gold to\npurchase the key to... you guessed it... Escape the Dungeon!");
            System.out.println("@ Represents where you are on the map");
            System.out.println("If it says to not move a certain direction, dont challenge the console, it will take you out of bounds...");
            System.out.println("First things first? Whats your username?");
            String name = sc.next();
            System.out.println("Hello "+name+". Who would you like to be:\n1) Warrior\n2) Goblin or\n3) Giant");
            try{
            int dec = sc.nextInt();
            switch(dec){
                case 1:
                    damageBonus = 1.2;
                    break;
                case 2:
                    lootBonus = 2;
                    break;
                case 3:
                    health = 140;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            }catch(InputMismatchException e){
                System.out.println("You didn't pick a number");
            }
            Inventory inv = new Inventory(name,commands,7,2,health,1,10,false,itemDrop,damageBonus,lootBonus);
            
        while(playing){
            move(inv);
        }
    }catch(ArrayIndexOutOfBoundsException e){
    }
    }
    
    public static void move(Inventory inv){
        System.out.println("Where do you want to move? Up, Down, Left or Right?");
        if((y-1)<0){
            System.out.println("Don't move left");
        }if((y+1)>10){
            System.out.println("Don't move right");
        }if((x-1)<0){
            System.out.println("Don't move up");
        }if((x+1)>10){
            System.out.println("Don't move down");
        }
        try{
        String move = sc.next().toLowerCase();
        switch(move){
            case "up":
                x--;
                break;
            case "down":
                x++;
                break;
            case "right":
                y++;
                break;
            case "left":
                y--;
                break;
            default:
                System.out.println("Invalid Direction");
                break;
                
        }
        System.out.println(grid[x][y]);
        map();
                
    }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You walked out of the map...");
            System.out.println("Game over");
            playing = false;
    }
    switch(grid[x][y]){
        case 1:
            found1(inv);
            break;
        case 2:
            boss = false;
            found2(inv);
            break;
        case 3:
            found3(inv);
            break;
        case 4:
            found4(inv);
            break;
        case 5:
            boss = true;
            found2(inv);
            break;
    }
    
}
    public static void found0(){
        System.out.println("Nothing here... keep moving");
    }
    public static void found1(Inventory inv){
        int temp;
        System.out.println("You found a chest!");
        String item = itemDrop[rnd.nextInt(3)];
        switch(item){
            case "gold":
                temp = inv.getGold();
                inv.setGold ((int) ((inv.getGold()+rnd.nextInt(12)+1)*inv.getLootBonus()));
                System.out.println("You found "+(inv.getGold()-temp)+ " Gold");
                break;
            case "health potion":
                temp = inv.getHealthPot();
                inv.setHealthPot((int)(((inv.getHealthPot()+rnd.nextInt(3)+1))*inv.getLootBonus()));
                System.out.println("You found "+ (inv.getHealthPot()-temp)+ " Health potion");
                break;
            case "upgrade":
                System.out.println("What do you want to upgrade? Your weapon or Armour?");
                dec = sc.next();
                switch(dec){
                    case "weapon":
                        System.out.println("You upgraded your weapon\nIt now has a chance to do up to 4 more damage!");
                        inv.setWeapon(inv.getWeapon()+4);
                        break;
                    case "armour":
                        if(inv.getArmour()<0.6){
                            System.out.println("Sorry, you've already maxed out your armour");
                        }else{
                        System.out.println("You upgraded your amour. You will now take 10% less damage");
                        inv.setArmour(inv.getArmour()-0.1);
                        break;
                }
                }
                break;
        }
    }
    public static void found2(Inventory inv){
        Monster monster;
        if(boss){
            monster = new Monster("Boss",150,30);
            fight(monster,inv);
        }else if(!boss){
        if(rnd.nextInt(2)+1==1){
            monster = new Monster ("Skeleton",30,10);
            fight(monster,inv);
        }else if(rnd.nextInt(2)+1==2){
            monster = new Monster ("Zombie",40,5);
            fight(monster,inv);
        }    
        }
    }
    
    public static void fight(Monster monster, Inventory inv){
        System.out.println(inv.getWeapon());
        double damage;
        System.out.println("Oh no, You've encountered a "+monster.getName());
        while(monster.getHealth()>0){
            if(inv.getHealth()<=0){
                System.out.println("The "+monster.getName()+" was too powerful... You died.");
                System.exit(0);
            }
        System.out.println("What do you want to do?");
            for (int i = 0; i < 3; i++) {
                System.out.println(commands[i]);
            }
        dec = sc.next().toLowerCase();
        if(dec.equals(commands[0])){
            damage = ((rnd.nextInt(7)+inv.getWeapon()))*inv.getDamageBonus();
            System.out.println("You hit the "+monster.getName()+" and dealt "+damage+ " damage");
            monster.setHealth(monster.getHealth()-damage);
            System.out.println("The "+monster.getName()+"'s health is currently "+monster.getHealth());
            damage = rnd.nextInt((int)monster.getDamage());
            System.out.println("The "+monster.getName()+ " attacked and dealt "+damage+" damage to you");
            inv.setHealth(inv.getHealth()-damage);
            System.out.println("Your current health is currently "+inv.getHealth());
        }else if(dec.equals(commands[1])){
            if(inv.getHealthPot()<=0){
                System.out.println("You dont have any heal pots left...");
            }else{
            System.out.println("You healed 10 health");
            if(inv.getHealth()+10>=100){
                inv.setHealth(100);
            }else{
                inv.setHealth(inv.getHealth()+10);
            }System.out.println("Your health is currently "+inv.getHealth());
            inv.setHealthPot(inv.getHealthPot()-1);
            }
            
        }else if(dec.equals(commands[2])){
            if((rnd.nextInt(3)+1)==2 || boss){
                System.out.println("The "+monster.getName()+" caught up with you");
                damage = rnd.nextInt((int)monster.getDamage());
                System.out.println(damage);
                System.out.println("The "+monster.getName()+ " attacked and dealt "+damage+" damage to you");
                inv.setHealth(inv.getHealth()-damage);
                System.out.println("Your current health is currently "+inv.getHealth());
                System.out.println("You continue fighting");
            }else{
                System.out.println("You successfully ran away from the "+monster.getName());
                monster.setHealth(0);
                move(inv);
            }
        }
    }
                if(monster.getHealth()<=0 && !dec.equals(commands[2])){
                System.out.println("You beat the "+monster.getName()+"!");
                boss = false;
                found1(inv);
            }
    }
    
        
    
    public static void found3(Inventory inv){
        System.out.println("You found the Merchant");
        System.out.println("Merchant: Im assuming you want to buy the key...\nIt costs 50 gold");
        if(inv.getGold()>=50){
            System.out.println("Do you want to buy the key off the merchant\n(Its your ticket out of here!");
            dec = sc.next();
            while(!dec.equals("yes")|| !dec.equals("no")){
                System.out.println("Invalid choice");
                dec = sc.next();
            switch(dec){
                case "yes":
                    inv.setGold(inv.getGold()-50);
                    inv.setKey(true);
                    System.out.println("You bought the key! Now go find the door to escape!");
                    break;
                case "no":
                    System.out.println("Fine, you'll regret it though...");
                    move(inv);
                    break;
            }
        }
    }else{
            System.out.println("Oh... It seems to me like you dont have enough gold for that... Find me again when you have 50 gold.");
        }
    }
    public static void found4(Inventory inv){
        System.out.println("You've found the way out");
        if(inv.getKey()){
            System.out.println("You put the key you found in the lock and you managed to escape!");
            System.out.println("You win!");
        }else{
            System.out.println("You dont currently have the key yet... Find the merchant to buy it from him");
        }
    }
        
}
