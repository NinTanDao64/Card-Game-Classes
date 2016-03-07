import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

public class Deck {
   private List<Card> deck;
   private List<Hand> hands;
   private int numCards; 
   
   public Deck() {
      this.deck = new ArrayList<Card>();
      this.hands = new ArrayList<Hand>();
      for(Suit suit: Suit.values()) {
         for(Rank rank: Rank.values()) {
            deck.add(new Card(suit, rank));
            numCards+=1;
         }
      }    
   }
   
   public Hand makeHand(int size) {
      Hand hand = new Hand();
      for(int i = 0; i < size; i++) {
         hand.addCard(deck.get(i));
      }
      hands.add(hand);
      for(int j = 0; j < size; j++) {
         deck.remove(0);
         numCards-=1;
      }
      return hand;    
   }
   
   public List<Hand> getHands() {
      return hands;
   }
   
   public List<Card> getDeck() {
      return deck;
   }
   
   public void removeCard() {
      deck.remove(0);
   }
   
   public void shuffle() {
      for(Hand h: hands) {
         List<Card> cards = h.getCards();
         for(Card c: cards) {
            deck.add(c);
            numCards+=1;
         }
      }
      hands.clear();
      Collections.shuffle(deck);
   }
   
   public String toString() {
      StringBuilder out = new StringBuilder();
         for(Hand h: hands) {
            List<Card> cards = h.getCards();
            out.append("[");
            for(Card c: cards) {
               out.append(c.toString());
               out.append(" ");
            }
            out.append("]");
            out.append("\n");
         }
      return out.toString();
   }
   
   //Deck Class Unit Test
   //Creates 9 hands of size 5 then prints them, then prints the remaining cards in the
   //deck one by one. Shuffles the deck afterwards and creates 3 new hands of size 3
   //and prints those.
   public static void main(String[] args) {
      Deck test = new Deck();
      for(int i = 0; i < 9; i++) {
         test.makeHand(5);
      }
      System.out.println(test);
      
      List<Card> remainingCards = test.getDeck();
      for(Card c: remainingCards) {
         System.out.println(c);
      }
      System.out.println();
      
      test.shuffle();
      for(int j = 0; j < 3; j++) {
         test.makeHand(3);
      }
      List<Hand> test2 = new ArrayList<Hand>();
      test2 = test.getHands();
      for(Hand h: test2) {
         System.out.println(h);
      }
   }
}
