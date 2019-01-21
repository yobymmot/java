
package blackjackobjects;
import java.util.*;

public class BlackjackObjects {
    
    private static String[] cardList = {"Diamonds","Clubs","Hearts","Spades"};
    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        
        while(score<21){
        cards card = new cards(cardList[rnd.nextInt(3)],rnd.nextInt(10)+1);
        System.out.println("Stick or Twist?");
        String dec = sc.next().toLowerCase();
        switch(dec){
            case "twist":
                twist(card);
                break;
            case "stick":
                System.out.println("Your score was "+score);
                System.exit(0);
                break;
        }
        }
        if(score>21){
            System.out.println("You got busted...");
            System.out.println("Your final score was "+score);
        }else if(score==21){
            System.out.println("You got 21! You win!");
        }
    }
    
    public static void twist(cards card){
        System.out.println("You got the "+card.getBoth());
        score+=card.getNumber();
        System.out.println("Your score is currently "+score);
        
    }
    
    
    
}
