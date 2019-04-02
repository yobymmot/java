
package dungeon;

public class Inventory {
    
    private String name;
    private String[] commands;
    private int weapon;
    private int healthPot;
    private double health;
    private double armour;
    private int gold;
    private boolean key;
    private String[] itemDrop;
    private double damageBonus;
    private double lootBonus;
        
    public Inventory(String name, String[] commands, int weapon, int healthPot, double health, double armour, int gold, boolean key, String[] itemDrop, double damageBonus, double lootBonus){
        this.name = name;
        this.commands = new String[3];
        this.weapon=weapon;
        this.healthPot = healthPot;
        this.health = health;
        this.armour = armour;
        this.gold=gold;
        this.key = key;
        this.itemDrop = new String[3];
        this.damageBonus = damageBonus;
        this.lootBonus = lootBonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = 1.1;
    }

    public double getLootBonus() {
        return lootBonus;
    }

    public void setLootBonus(int lootBonus) {
        this.lootBonus = 1.5;
    }
    

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    public void setHealthPot(int healthPot) {
        this.healthPot = healthPot;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setArmour(double armour) {
        this.armour = armour;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public void setItemDrop(String[] itemDrop) {
        this.itemDrop = itemDrop;
    }

    public int getHealthPot() {
        return healthPot;
    }
    

    public String[] getCommands() {
        return commands;
    }

    public String[] getItemDrop() {
        return itemDrop;
    }

    public double getHealth() {
        return health;
    }

    public double getArmour() {
        return armour;
    }

    public int getGold() {
        return gold;
    }

    public boolean getKey() {
        return key;
    }

}
