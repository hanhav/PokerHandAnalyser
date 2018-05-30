package pokerhandanalyser;

import java.util.Random;

/**
*
* @author HanHav
*/

public class Deck {
    final static int CARDLIMIT = 52;
    private Card deckOfCards[] = new Card[CARDLIMIT + 1];
    int nextToDeal = 0;
    
    public Deck() {
        int i = 1;

    	for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                deckOfCards[i] = new Card(suit, rank);
                i++;
            }
    	}
    }
    
    void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
          int firstCard = random.nextInt(CARDLIMIT) + 1;
          int secondCard = random.nextInt(CARDLIMIT) + 1;
          Card CardOne = deckOfCards[firstCard];
          Card CardTwo = deckOfCards[secondCard];

          deckOfCards[firstCard] = CardTwo;
          deckOfCards[secondCard] = CardOne;
        }
    }

    public Card dealCard() {
    	nextToDeal++;
    	return deckOfCards[nextToDeal];
    }
}

