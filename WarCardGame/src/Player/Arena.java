package Player;

import DeckOfCards.Card;
import DeckOfCards.Deck;
import DeckOfCards.Value;

import java.util.List;
import java.util.Scanner;

public class Arena {
    Value[] tableOfValues = Value.values();
    public void fightOfPlayers(Player player1,Player player2) throws InterruptedException {
        int i = 0;
        while (!player1.getPlayersDeck().getDeck().isEmpty()||!player2.getPlayersDeck().getDeck().isEmpty()){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Karta : "+player1.getName());
           player1.getPlayersDeck().getDeck().get(i).displayCardInfo();
           System.out.println("\n");
           System.out.println("Karta : "+player2.getName());
           player2.getPlayersDeck().getDeck().get(i).displayCardInfo();
           if (player1.getPlayersDeck().getDeck().get(i).getValue().compareTo(player2.getPlayersDeck().getDeck().get(i).getValue())>0){
               System.out.println("Wygrała karta gracza "+player1.getName());
               player1.getPlayersDeck().getDeck().add(player2.getPlayersDeck().getDeck().get(i));
               player2.getPlayersDeck().getDeck().remove(i);
               player1.getPlayersDeck().getDeck().addLast(player1.getPlayersDeck().getDeck().get(i));
               player1.getPlayersDeck().getDeck().remove(i);
               System.out.println(player1.getName()+" "+"Deck curently has :"+player1.getPlayersDeck().getDeck().size());
               System.out.println(player2.getName()+" "+"Deck curently has :"+player2.getPlayersDeck().getDeck().size());
               System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       //        Thread.sleep(1200);


           }else if (player1.getPlayersDeck().getDeck().get(i).getValue().compareTo(player2.getPlayersDeck().getDeck().get(i).getValue())<0){
               System.out.println("Wygrała karta gracza "+player2.getName());
               player2.getPlayersDeck().getDeck().add(player1.getPlayersDeck().getDeck().get(i));
               player1.getPlayersDeck().getDeck().remove(i);
               player2.getPlayersDeck().getDeck().addLast(player2.getPlayersDeck().getDeck().get(i));
               player2.getPlayersDeck().getDeck().remove(i);
               System.out.println(player1.getName()+" "+"Deck curently has :"+player1.getPlayersDeck().getDeck().size());
               System.out.println(player2.getName()+" "+"Deck curently has :"+player2.getPlayersDeck().getDeck().size());
               System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
     //          Thread.sleep(1200);

           }
           if (player1.getPlayersDeck().getDeck().get(i).getValue().compareTo(player2.getPlayersDeck().getDeck().get(i).getValue())==0){
               System.out.println("Card has the same value WAR is about to start :");
               break;


           }

       }
    }
}
