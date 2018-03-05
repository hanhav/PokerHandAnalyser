package pokerhandanalyser;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hannu Havila
 */
public class CardTest {
    
    @Test
    public void testGetSuit() {
        System.out.println("--- CardTest: getSuit()");
        Card instance = new Card(Card.HEART, 11);
        int suit = instance.getSuit();
        assertEquals("getSuit() returned wrong suit - ", Card.HEART, suit);
        System.out.println("--- CardTest: getSuit() -- OK");
    }   

    @Test
    public void testGetRank() {
        System.out.println("--- CardTest: getRank()");
        Card instance = new Card(Card.HEART, 11);
        int rank = instance.getRank();
        assertEquals("getRank() returned wrong rank - ",11, rank);
        System.out.println("--- CardTest: getRank() -- OK");
    }

    @Test
    public void testToString() {
        System.out.println("--- CardTest: toString()");
        Card instance = new Card(Card.HEART, 11);
        String result = instance.toString();
        assertEquals("toString() returned wrong card - ", "Queen of Hearts", result);
        System.out.println("--- CardTest: toString() -- OK");
    }
}
