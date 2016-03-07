/*
   Programming HW 6
   CSC 20, Fall 2014, 10/12/2014
   Class ID: 1913
   Included are the classes necessary for the given CardTest.java (also included)
   program to run. The Card, Hand, and Deck classes each have their own unit
   test, and their output is included on the last page along with the output
   given when CardTest.java is run.
*/

import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

public class Card {
   private Suit suit;
   private Rank rank;
   
   public Card(Suit suit, Rank rank) {
      this.suit = suit;
      this.rank = rank;
   }
   
   public Rank getRank() {
      return rank;
   }
   
   public Suit getSuit() {
      return suit;
   }
   
   public String toString() {
      return "(" + rank + " " + suit + ")";
   }
   
   //Card Class Unit Test
   //Creates 3 cards and prints them.
   public static void main(String[] args) {
      Card test = new Card(Suit.SPADES, Rank.KING);
      System.out.println(test);
      
      Card test2 = new Card(Suit.HEARTS, Rank.NINE);
      System.out.println(test2);
      
      Card test3 = new Card(test.getSuit(), test2.getRank());
      System.out.print(test3);
   }
}