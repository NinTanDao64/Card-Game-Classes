/*
   Programming HW 7
   CSC 20, Fall 2014, 10/19/2014
   Class ID: 1913
   Included are the classes necessary to make this TwentyOneGame.java run. This is an
   interactive game of Blackjack that utilizes the previously created Card/Hand/Deck
   classes. Revisions have been made to the Rank.java enum class to attribute numerical
   values to each of the card ranks for calculating hand totals. I elected to use my 
   own Card/Hand/Deck classes over the ones provided for us. I also decided to add
   the promptYN method used in last semester's guessing game project to prevent bad 
   input from the user.
*/

import java.util.*;

public class TwentyOneGame {
   public static void main(String[] args) {
      int dealerVal;
      int playerVal;
      Scanner console = new Scanner(System.in);
      
      TwentyOneDeck deck = new TwentyOneDeck();
      deck.shuffle();
      
      TwentyOneHand player = new TwentyOneHand();
      TwentyOneHand dealer = new TwentyOneHand();
      deck.addCard(player);
      deck.addCard(player);
      deck.addCard(dealer);
      deck.addCard(dealer);
      
      List<Card> dealerCards = dealer.getCards();
      Card dealerFirst = dealerCards.get(0);
      playerVal = player.value(player);
      System.out.println("Dealer shows " + dealerFirst);
      System.out.println("Player hand " + player + " (" + playerVal + ")");
      char gameResponse = promptYN(console, "Would you like another card? (y/n) ");
      
      boolean gameDone = false;
      
      while(gameDone == false) {
         if(gameResponse == 'y') {
            deck.addCard(player);
            playerVal = player.value(player);
            System.out.println("Player hand " + player + " (" + playerVal + ")");
            if(playerVal > 21) {
               dealerVal = dealer.value(dealer);
               System.out.println("Dealer hand " + dealer + " (" + dealerVal + ")");
               while(dealerVal < 17) {
                  deck.addCard(dealer);
                  dealerVal = dealer.value(dealer);
                  System.out.println("Dealer hand " + dealer + " (" + dealerVal + ")");
               }
               gameDone = true;
            } else if (playerVal <= 21) {
               gameResponse = promptYN(console, "Would you like another card? (y/n) ");
            }
         } else if (gameResponse == 'n') {
            dealerVal = dealer.value(dealer);
            System.out.println("Player hand " + player + " (" + playerVal + ")");
            System.out.println("Dealer hand " + dealer + " (" + dealerVal + ")");
            while(dealerVal < 17) {
               deck.addCard(dealer);
               dealerVal = dealer.value(dealer);
               System.out.println("Dealer hand " + dealer + " (" + dealerVal + ")");
            }
            gameDone = true;
         }
      }
      
      dealerVal = dealer.value(dealer);            
      if (playerVal > 21) {
         System.out.print("You went over 21. Dealer wins.");
      } else if ((playerVal < dealerVal) && (playerVal < 21) && (dealerVal <= 21)) {
         System.out.print("Dealer wins.");
      } else if (((playerVal <= 21) && (dealerVal > 21)) || ((playerVal <=21) && (dealerVal < playerVal))) {
         System.out.print("Player wins.");
      } else {
         System.out.print("Tie game.");
      }     
   }
   
   public static char promptYN (Scanner console, String prompt) {
      System.out.print(prompt);
      while ((!console.hasNextLine()) || (console.hasNextInt()) || (console.hasNextDouble())) {
         System.out.println("Sorry y and n are the only acceptable answers.");
         System.out.print(prompt);
         console.nextLine();
      }
      String response = console.nextLine();
      char charResponse = response.charAt(0);
      while ((Character.isLetter(charResponse)==false) || (response.length()>1) || ((charResponse!='y') && (charResponse!='n'))) {
          System.out.println("Sorry y and n are the only acceptable answers.");
          System.out.print(prompt);
          response = console.nextLine();
          charResponse = response.charAt(0);
      }
      return charResponse;
   }
}