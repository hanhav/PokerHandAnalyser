package pokerhandanalyser;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author HanHav
 */
public class DeckTest {
    
    private static final ArrayList<Card> compareListUnShuffled = new ArrayList();
    private static final ArrayList<Card> compareListShuffled = new ArrayList();
    
    @BeforeClass
    public static void createDeck() {
        Deck instance = new Deck();
        Card card;
        
        for (int suit = Card.HEART; suit <= Card.SPADE; suit++) {
            for (int rank = 0; rank <= 12; rank++) {
                card = instance.dealCard();
                compareListUnShuffled.add(card);
            }
        }      
    }
    
    @Test
    public void testDeckDealCard() {
        Deck instance = new Deck();
        Card card;
        String expected;

        System.out.println("--- DeckTest: dealCard() ---");
        System.out.println("Cards in order by suit, without shuffling: ");
        for (int suit = Card.HEART; suit <= Card.SPADE; suit++) {
            for (int rank = 0; rank <= 12; rank++) {
                card = instance.dealCard();
                System.out.println(card);
                expected = Card.RANKS[rank] + " of " + Card.SUITS[suit];
                assertEquals(expected, card.toString());
            }
        }
    }

    @Test
    public void testDeckShuffleDeck() {
        int counter = 0;
        int errorMargin = 5;
        
        System.out.println("\n--- Decktest: shuffleDeck() ---");
        Deck instance = new Deck();
        instance.shuffleDeck();
        System.out.println("Shuffled cards:");
        for (int i = 1; i <= Deck.CARDLIMIT; i++) {
            Card dealtCard = instance.dealCard();
            compareListShuffled.add(dealtCard);
            System.out.println(i + ": " + dealtCard);
        }
        for (int i = 0; i <= compareListUnShuffled.size() - 1; i++) {
            if (compareListUnShuffled.get(i) == compareListShuffled.get(i)) {
                counter++;
            }
        }
        assertTrue(counter <= errorMargin);
        System.out.println("\n--- DeckTest: testDeckShuffleDeck() -- OK -- Error Margin is 5 and error counter is " + counter +" ---");
        System.out.println("--- Shuffled deck and Unsuffled deck printed out for manual inspection ---");
        System.out.println(compareListShuffled + "\n" + compareListUnShuffled);
        
    }
}

