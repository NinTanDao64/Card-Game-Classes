import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

public class TwentyOneHand extends Hand {

   public int value(Hand hand) {
      int value = 0;
      boolean ace = false;
      
      List<Card> cards = hand.getCards();
      for(Card c: cards) {
         Rank rank = c.getRank();
         int cardVal = rank.getValue();
         if(cardVal == 1) {
            ace = true;
         }
         value = value + cardVal;
      }
      
      if((ace == true) && (value + 10) <= 21) {
         value = value + 10;
      }
      
      return value;
   }
   
   //TwentyOneHand Class Unit Test
   //Creates a player hand, adds a face card and an Ace, then prints the
   //numerical total of the hand. Then, adds another Ace to the hand and
   //prints the new total. Does this 2 more times for consistency.
   public static void main(String[] args) {
      TwentyOneHand hand = new TwentyOneHand();
      hand.addCard(new Card(Suit.HEARTS, Rank.KING));
      hand.addCard(new Card(Suit.SPADES, Rank.ACE));
      int value = hand.value(hand);
      System.out.println(value);
      
      hand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
      value = hand.value(hand);
      System.out.println(value);
      
      hand.addCard(new Card(Suit.CLUBS, Rank.ACE));
      value = hand.value(hand);
      System.out.println(value);
      
      hand.addCard(new Card(Suit.HEARTS, Rank.ACE));
      value = hand.value(hand);
      System.out.print(value);
   }
}

