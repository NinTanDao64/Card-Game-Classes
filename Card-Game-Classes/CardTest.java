import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

public class CardTest {
    
    public static void main(String[] args) {
        Deck deck = new Deck();             // new deck, unshuffled
        
        // Managing hands myself
        List<Hand> hands = new ArrayList<Hand>();
        for (int i=0; i< 3; i++) {
            hands.add( deck.makeHand(5) );  // Ask deck to make 3 hands, size 5
        }
        for (Hand h : hands) {
            System.out.println(h);          // Print hands, not shuffled yet
        }
        System.out.println();
        
        deck.shuffle();                     // Cancel current hands, shuffle

        // Letting deck manage hands
        for (int i=0; i< 3; i++) {
            deck.makeHand(5);               // Ask deck to make 3 hands, size 5
        }
        hands = deck.getHands();
        System.out.println(deck);           // Have deck print all hands
        for (Hand h : hands) {
            System.out.println(h);          // Use List of hands to do the same
        }
        System.out.println();
        for (Hand h : hands) {              // Print the hands card by card
            List<Card> cards = h.getCards();
            System.out.print("[");
            for (Card c : cards) {
                System.out.print(c + " ");
            }
            System.out.println("]");
        }
    }
}