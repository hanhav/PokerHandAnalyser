package pokerhandanalyser;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hannu Havila
 */
public class HandTest {

    private final Card[] cards = new Card[5];
    private Hand instance;
    
    @After
    public void printOutHand() {
        System.out.println(instance);
    }

    @Test
    public void testIfHandHasFlush() {
        System.out.println("--- HandTest: analyzeCardHand() -> FLUSH");
        cards[0] = new Card(Card.CLUB, 9);
        cards[1] = new Card(Card.CLUB, 2);
        cards[2] = new Card(Card.CLUB, 4);
        cards[3] = new Card(Card.CLUB, 1);
        cards[4] = new Card(Card.CLUB, 6);
        instance = new Hand(cards);
        assertEquals("Expected FLUSH", Hand.FLUSH, instance.analyzeCardHand());
    }
    
    @Test
    public void testIfHandHasStraightLOW() {
        System.out.println("--- HandTest: analyzeCardHand() -> LOW STRAIGHT");
        cards[0] = new Card(Card.HEART, 0);
        cards[1] = new Card(Card.SPADE, 1);
        cards[2] = new Card(Card.DIAMOND, 2);
        cards[3] = new Card(Card.SPADE, 4);
        cards[4] = new Card(Card.HEART, 3);
        instance = new Hand(cards);
        assertEquals("Expected STRAIGHT (Ace as Low)", Hand.STRAIGHT, instance.analyzeCardHand());
    }
    
    @Test
    public void testIfHandHasStraightHIGH() {
        System.out.println("--- HandTest: analyzeCardHand() -> HIGH STRAIGHT");
        cards[0] = new Card(Card.HEART, 9);
        cards[1] = new Card(Card.SPADE, 10);
        cards[2] = new Card(Card.DIAMOND, 11);
        cards[3] = new Card(Card.SPADE, 12);
        cards[4] = new Card(Card.HEART, 0);
        instance = new Hand(cards);
        assertEquals("Expected STRAIGHT (Ace as Low)", Hand.STRAIGHT, instance.analyzeCardHand());
    }
    
    @Test
    public void testIfHandHasTwoPair() {
        System.out.println("--- HandTest: analyzeCardHand() -> Two Pair");
        cards[0] = new Card(Card.SPADE, 9);
        cards[1] = new Card(Card.SPADE, 9);
        cards[2] = new Card(Card.DIAMOND, 0);
        cards[3] = new Card(Card.HEART, 10);
        cards[4] = new Card(Card.CLUB, 10);
        instance = new Hand(cards);
        assertEquals("Expected TwoPair", Hand.TWOPAIR, instance.analyzeCardHand());
    }
    
    @Test
    public void testIfHandHasStraightFlushWithLowAce() {
        System.out.println("--- HandTest: analyzeCardHand() -> StraightFlush (Low Ace)");
        cards[0] = new Card(Card.SPADE, 1);
        cards[1] = new Card(Card.SPADE, 2);
        cards[2] = new Card(Card.SPADE, 4);
        cards[3] = new Card(Card.SPADE, 3);
        cards[4] = new Card(Card.SPADE, 0);
        instance = new Hand(cards);
        assertEquals("Expected Straightflush (Low Ace)", Hand.STRAIGHTFLUSH, instance.analyzeCardHand());
    }
    
    @Test
    public void testIfHandHasStraightFlushWithHighAce() {
        System.out.println("--- HandTest: analyzeCardHand() -> StraightFlush (High Ace)");
        cards[0] = new Card(Card.CLUB, 9);
        cards[1] = new Card(Card.CLUB, 10);
        cards[2] = new Card(Card.CLUB, 11);
        cards[3] = new Card(Card.CLUB, 12);
        cards[4] = new Card(Card.CLUB, 0);
        instance = new Hand(cards);
        assertEquals("Expected Straightflush (High Ace)", Hand.STRAIGHTFLUSH, instance.analyzeCardHand());
    }
}
