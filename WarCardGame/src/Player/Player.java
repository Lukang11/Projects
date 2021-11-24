package Player;

import DeckOfCards.Deck;

public class Player {
    String name;
    Deck playersDeck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.playersDeck = deck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getPlayersDeck() {
        return playersDeck;
    }

    public void setPlayersDeck(Deck deck) {
        this.playersDeck = deck;
    }
    public void displayDeck(){
        playersDeck.displayDeckOfCard();
    }
}
