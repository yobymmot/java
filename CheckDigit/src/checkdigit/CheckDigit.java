
package checkdigit;
import java.util.Scanner;
public class CheckDigit {
    
    private static int sum = 0;
    private static int newSum = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a series of numbers");
        int numbers = input.nextInt();
        sumOfDigits(numbers);
    }
    public static void sumOfDigits(int numbers){
        if(numbers<0){
            System.out.println("Error");
        }while(numbers!=0){
            int lsb = numbers%10;
            sum+=lsb;
            numbers/=10;
            
        }
        System.out.println(sumOfCheckDigits(sum,newSum));

        
    }
    public static int sumOfCheckDigits(int sum, int newSum){
        while(sum!=0){
         int lsb = sum%10;
         newSum+=lsb;
         sum/=10;
            
        }
        System.out.print("Your check digit is ");
                 return newSum;
                 }
    
}
