import DeckOfCards.Card;
import DeckOfCards.Deck;
import DeckOfCards.Symbol;
import Player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome in my Card game called WAR \nWhat's your name ? :");
        Scanner scanner =new Scanner(System.in);

        Deck playersDeck = new Deck();
        playersDeck.generateDeckOfCards();
        playersDeck.shuffleDeck();

        Deck botsDeck = new Deck();
        botsDeck.generateDeckOfCards();
        botsDeck.shuffleDeck();

        String name =scanner.next();
        Player player1 =new Player(name,playersDeck);
        Player bot = new Player("BoB",botsDeck);
        System.out.println("I have generated your deck of card do you want to see it ?1-Yes");
        System.out.println(player1.getPlayersDeck());
        System.out.println(player1.getPlayersDeck().getDeck());
    }
}
