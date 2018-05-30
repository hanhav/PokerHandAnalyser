package pokerhandanalyser;

/**
*
* @author HanHav
*/

public class Card implements Comparable <Card> {
    final static String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    final static int HEART = 0, DIAMOND = 1, CLUB = 2, SPADE = 3;
    final static String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    final static int ACE = 0, TWO = 1, THREE = 2, FOUR = 3, FIVE = 4, SIX = 5, SEVEN = 6, EIGHT = 7, NINE = 8, TEN = 9, JACK = 10, QUEEN = 11, KING = 12;
 
    int suit, rank;
    
    protected Card (int suit, int rank) {
	this.suit = suit;
	this.rank = rank;
    }

    protected int getSuit() {
    	return suit;
    }

    protected int getRank(){
    	return rank;
    }

    @Override
    public String toString(){
    	return RANKS[rank] + " of " + SUITS[suit];
    }    
    
    @Override
    public int compareTo(Card card) {
        return this.rank - card.rank;
    }
}
