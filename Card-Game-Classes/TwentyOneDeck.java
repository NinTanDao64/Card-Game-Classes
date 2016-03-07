import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

public class TwentyOneDeck extends Deck {
      
   //A removeCard() method has been added to my parent Deck class
   //that removes the current Card object on top of the deck
   //(in the ArrayList index 0) 
   public void addCard(Hand hand) {
      List<Card> deckCards = super.getDeck();
      Card card = deckCards.get(0);
      hand.addCard(card);
      super.removeCard();
   }
   
   //TwentyOneDeck Unit Test
   //Creates a deck for a game of Blackjack, then shuffles it.
   //Then, creates a player hand and adds a card from the shuffled deck
   //and prints it out.
   public static void main(String[] args) {
      TwentyOneDeck deck = new TwentyOneDeck();
      deck.shuffle();

      TwentyOneHand player = new TwentyOneHand();
      deck.addCard(player);
      List<Card> cards = player.getCards();
      Card card = cards.get(0);
      System.out.println(card);

   } 
}     