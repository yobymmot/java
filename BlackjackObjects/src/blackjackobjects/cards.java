
package blackjackobjects;

public class cards {
    private String card;
    private int number;
    
    public cards(String card, int number){
        this.card = card;
        this.number = number;
    }

    public String getCard() {
        return card;
    }

    public int getNumber() {
        return number;
    }
    public String getBoth(){
        return number+" of "+card;
    }
}
