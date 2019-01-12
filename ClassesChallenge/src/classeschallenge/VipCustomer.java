
package classeschallenge;

public class VipCustomer {
    private String name;
    private int creditLimit;
    private String email;
    
    public VipCustomer(){
        this("Default name",100,"err@err.com");
    }
    public VipCustomer(String name, int creditLimit){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = "err@err.com";
    }
    public VipCustomer(String name, int creditLimit, String email){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
    public String getAll(){
        return name+", "+creditLimit+", "+email;
    }
    
}
