import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

public class Hand {
   private List<Card> hand;
   
   public Hand() {
      this.hand = new ArrayList<Card>();
   }
   
   public void addCard(Card card) {
      this.hand.add(card);
   }
   
   public List<Card> getCards() {
      return hand;
   }
   
   public String toString() {
      StringBuilder out = new StringBuilder();
      out.append("[");
      for(Card c: hand) {
         out.append(c.toString());
         out.append(" ");
      }
      out.append("]");
      return out.toString();
   }
   
   //Hand Class Unit Test
   //Creates a hand object, adds 3 cards to it and prints the hand, then
   //creates a second hand object and uses the addCard method to
   //copy the cards from the first object, and prints them.
   public static void main(String[] args) {
      Hand test = new Hand();
      test.addCard(new Card(Suit.CLUBS, Rank.ACE));
      test.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
      test.addCard(new Card(Suit.SPADES, Rank.QUEEN));
      System.out.println(test);
      
      List<Card> cards = test.getCards();
      Hand test2 = new Hand();
      for(Card c: cards) {
         test2.addCard(c);
      }
      System.out.print(test2);
   }    
}