import DeckOfCards.Card;
import DeckOfCards.Deck;
import DeckOfCards.Symbol;
import DeckOfCards.Value;
import Player.Player;
import Player.Arena;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Value value = Value.ACE;
        Value value1 = Value.ACE;
        System.out.println(value.compareTo(value1));



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
        System.out.println("I have generated your deck of card");
        playersDeck.displayDeckOfCard();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        botsDeck.displayDeckOfCard();
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
        Arena arena = new Arena();
        arena.fightOfPlayers(player1,bot);


    }
}
