
package isbn;
import java.util.Scanner;
public class ISBN {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a series of numbers and I'll create a check digit");
        int number = input.nextInt();
        System.out.println(checkDigit(number));
    }
    public static int checkDigit(int number){
        check = 0;
        
        while(check >= number.length())
    }
    
}
