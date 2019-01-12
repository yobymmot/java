
package classeschallenge;

public class BankAccount {
    private int accNo;
    private int balance;
    private String name;
    private String phone;
    private String email;
    
    public BankAccount(int accNo, int balance, String name, String phone, String email){
        this.accNo = accNo;
        this.balance = balance;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccNo() {
        return accNo;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
}
