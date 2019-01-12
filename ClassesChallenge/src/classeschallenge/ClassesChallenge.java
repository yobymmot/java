
package classeschallenge;
import java.util.*;
public class ClassesChallenge {
    
    private static Scanner sc = new Scanner(System.in);
    private static int newBalance;
    private static String password = "coolvip";

    public static void main(String[] args) {
        System.out.println("Do you own Bank Account 1, 2 or 3?");
        int bankNo = sc.nextInt();
        System.out.println("Are you a VIP?");
        String dec = sc.next();
        if(dec.equals("yes")){
            isVip(bankNo);
        }else{
           choice(bankNo) ;
        }
        
        
    }
    
    public static void choice(int bankNo){
        System.out.println("Withdraw or Deposit funds?");
        String dec = sc.next().toLowerCase();
        switch(dec){
            case"withdraw":
                withdraw(bankNo);
                break;
            case"deposit":
                deposit(bankNo);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void withdraw(int bankNo){
        int amount;
        switch(bankNo){
            case 1:
                BankAccount a = new BankAccount(1,500,"Bob","07867475827","BobTheBuilder@gmail.com");
                System.out.println("You currently have £"+a.getBalance()+". On your account. How much do you want to withdraw?");
                amount = sc.nextInt();
                while(amount>a.getBalance()){
                    System.out.println("You amount is too Large to withdraw");
                    amount = sc.nextInt();
                }if(amount<a.getBalance()){
                    newBalance = a.getBalance()-amount;
                    System.out.println("Your new balance is £"+newBalance);
                }
                
                break;
            case 2:
                BankAccount b = new BankAccount(2,10000,"Max","0785756436","richboi@outlook.com");
                System.out.println("You currently have £"+b.getBalance()+". On your account. How much do you want to withdraw?");
                amount = sc.nextInt();
                while(amount>b.getBalance()){
                    System.out.println("You amount is too Large to withdraw");
                    amount = sc.nextInt();
                }if(amount<b.getBalance()){
                    newBalance = (b.getBalance()-amount);
                    System.out.println("Your new balance is £"+newBalance);
                }
                break;
            case 3:
                BankAccount c = new BankAccount(3,50,"James","06849683752","Jamesiscool@aol.com");
                System.out.println("You currently have £"+c.getBalance()+". On your account. How much do you want to withdraw?");
                amount = sc.nextInt();
                while(amount>c.getBalance()){
                    System.out.println("You amount is too Large to withdraw");
                    amount = sc.nextInt();
                }if(amount<c.getBalance()){
                    newBalance = c.getBalance()-amount;
                    System.out.println("Your new balance is £"+newBalance);
                }
                break;
            default:
                System.out.println("We dont have bank account 4");
                break;
        }
    }
    public static void deposit(int bankNo){
        int amount;
        switch(bankNo){
            case 1:
                BankAccount a = new BankAccount(1,500,"Bob","07867475827","BobTheBuilder@gmail.com");
                System.out.println("You currently have £"+a.getBalance()+". On your account. How much do you want to deposit?");
                amount = sc.nextInt();
                    newBalance = a.getBalance()+amount;
                    System.out.println("Your new balance is £"+newBalance);      
                break;
            case 2:
                BankAccount b = new BankAccount(2,10000,"Max","0785756436","richboi@outlook.com");
                System.out.println("You currently have £"+b.getBalance()+". On your account. How much do you want to deposit?");
                amount = sc.nextInt();
                    newBalance = (b.getBalance()+amount);
                    System.out.println("Your new balance is £"+newBalance);

            case 3:
                BankAccount c = new BankAccount(3,50,"James","06849683752","Jamesiscool@aol.com");
                System.out.println("You currently have £"+c.getBalance()+". On your account. How much do you want to deposit?");
                amount = sc.nextInt();
                    newBalance = c.getBalance()+amount;
                    System.out.println("Your new balance is £"+newBalance);
                break;
            default:
                System.out.println("We dont have bank account 4");
                break;
        }
    }
    public static void isVip(int bankNo){
        System.out.println("Enter VIP password");
        String attempt = sc.next();
        if(attempt.equals(password)){
            System.out.println("Password Entered");
            vip();
        }else{
            System.out.println("Incorrect");
            choice(bankNo);
        }
    }
    public static void vip(){
        System.out.println("Please enter your details:");
        System.out.println("If you don't have the detail, simply press '-1'");
        System.out.println("What is your name");
        String name = sc.next();
        System.out.println("Whats your credit limit?");
        int creditLimit = sc.nextInt();
        System.out.println("Whats your email address?");
        String email = sc.next();
        if(name == "-1" && creditLimit == -1 && email == "-1"){
            VipCustomer vip = new VipCustomer();
            System.out.println(vip.getAll());
            System.out.println(vip);
        System.out.println("How much credit do you want to withdraw?");
        int credit = sc.nextInt();
        while(credit>creditLimit){
            System.out.println("Youre taling out too much. You only have £"+vip.getCreditLimit());
            credit = sc.nextInt();
        }if(credit<creditLimit){
            System.out.println("You have taken "+credit+" from your account");
        }
        
        }else if(email == "-1"){
            VipCustomer vip = new VipCustomer(name,creditLimit);
            System.out.println(vip.getAll());
            System.out.println(vip);
        System.out.println("How much credit do you want to withdraw?");
        int credit = sc.nextInt();
        while(credit>creditLimit){
            System.out.println("Youre taling out too much. You only have £"+vip.getCreditLimit());
            credit = sc.nextInt();
        }if(credit<creditLimit){
            System.out.println("You have taken "+credit+" from your account");
        }
        
        }else if(name != "-1" && creditLimit>=0 && email != "-1"){
            VipCustomer vip = new VipCustomer(name,creditLimit,email);
            System.out.println(vip.getAll());
        System.out.println("How much credit do you want to withdraw?");
        int credit = sc.nextInt();
        while(credit>creditLimit){
            System.out.println("Youre taling out too much. You only have £"+vip.getCreditLimit());
            credit = sc.nextInt();
        }if(credit<creditLimit){
            System.out.println("You have taken "+credit+" from your account");
        }
        
        }
       
    }
    
}
