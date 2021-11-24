package DeckOfCards;

public class Card {
    private Value value;
    private Symbol symbol;

    public Card(Value value,Symbol symbol){
        this.value = value;
        this.symbol = symbol;
    }
    public Value getValue(){
        return value;
    }
    public Symbol getSymbol(){
        return symbol;
    }
    public void displayCardInfo(){
        System.out.println("Your first card :"+ value + " of "+ symbol);
    }
}
