package DeckOfCards;

import java.util.*;
import java.lang.Math;
import java.util.stream.Stream;

public class Deck {
    LinkedList<Card> deck = new LinkedList<>();

    public LinkedList<Card> getDeck() {
        return deck;
    }
    public LinkedList<Card> generateDeckOfCards(){
        for (Symbol symbol :Symbol.values())
            for (Value value : Value.values()) {
                this.deck.add(new Card(value,symbol));
            }
        return deck;
    }

    public void displayDeckOfCard(){
        deck.stream()
                .forEach(card1 -> System.out.println(card1.getValue()+" of "+card1.getSymbol()));
    }

    public LinkedList<Card> shuffleDeck(){
        Collections.shuffle(deck);
        return deck;
    }
}
