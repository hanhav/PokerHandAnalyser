package pokerhandanalyser;

import java.util.Arrays;

/**
*
* @author Hannu Havila
*/

public class Hand {
    final static int NOTHING = 0, STRAIGHTFLUSH = 1, FLUSH = 2, STRAIGHT = 3, TWOPAIR = 4;
    Card[] hand = new Card[5];

    public Hand (Deck deck) {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = deck.dealCard();
        }
    }

    public Hand (Card[] cardHand) {
        for (int i = 0; i < cardHand.length; i++) {
            hand[i] = cardHand[i];
        }
    }

    @Override
    public String toString() {
        String print = "";
            for (int i = 0; i < hand.length; i++) {
		if (i == hand.length - 1) {
                    print += hand[i];
		} else {
                    print += hand[i] + ", ";
		}
            }
        return print;
    }	

    public int analyzeCardHand() {
        
        if (checkIfFlush() && checkIfStraight() == true) {
            return 1;
        }
        if (checkIfFlush() == true) {
            return 2;
        }  
        if (checkIfStraight() == true) {
            return 3;
        }
        if (checkIfTwoPair() == true) {
            return 4;
        } else {
            return 0;
        }
    }
    
    public boolean checkIfStraight() {
        Arrays.sort(hand);
        boolean isStraight = true;
        
        if (hand[0].rank == 0 && hand[4].rank == 12) {
            hand[0] = new Card(hand[0].rank, 13);
            Arrays.sort(hand);
	}
        
        Card comparableCard = hand[0];
        
        for (int i = 0; i < hand.length; i++) {
           if (i == 0 || comparableCard.rank + 1 == hand[i].rank) {
               comparableCard = hand[i];
            } else {
               return false;
           }
        }
        if (isStraight) {
            return true;
        }
        return false;
    }
     
    public boolean checkIfFlush() {
        int comparableCard = hand[0].getSuit();
        
        for (int i = 0; i < 5; i++) {
            int nextCardInHand = hand[i].getSuit();
            if (nextCardInHand != comparableCard) {
		 return false;
            }
        }
        return true;
    }

    public boolean checkIfTwoPair() {
        int sum = 0;
        int counter = 0;
        for (Card hand1 : hand) {
            for (Card hand2 : hand) {
                if (hand1.getRank() == hand2.getRank()) {
                    counter++;
                }
            }
            if (counter > 1)
                sum++;
                counter = 0;
        }
        return sum == 4;
    }
}
