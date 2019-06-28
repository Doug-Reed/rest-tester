package my.apps.resttester.games.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import my.apps.resttester.games.cards.*;
public class Shoe {
     private ArrayList<Card> cards = new ArrayList<Card>();
     private int cardIndex = 0;

     public Shoe(int numberOfDecks) {
         for(int i = 0; i < numberOfDecks; i++) {
            Deck d = new Deck();
            cards.addAll(d.getCards());
         }
         
         Collections.shuffle(cards);
     }

    public Card draw(){
        try {
            Card retVal = cards.get(cardIndex);
            cardIndex++;
            return retVal;
        } catch (Exception e) {
            return null;
        }
    }

    public void reset(){
        cardIndex = 0;
    }
}