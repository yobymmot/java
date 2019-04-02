
package dungeon;

public class Stats {
    private int health;
    private String sword;
    private String armour;
    
    public Stats(int health, String sword){
        this.health = health;
        this.sword = sword;
        this.armour = armour;
    }

    public String getArmour() {
        return armour;
    }

    public int getHealth() {
        return health;
    }

    public String getSword() {
        return sword;
    }
    
}
