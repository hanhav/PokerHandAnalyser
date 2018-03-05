package pokerhandanalyser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Hannu Havila
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    pokerhandanalyser.HandTest.class, 
    pokerhandanalyser.DeckTest.class, 
    pokerhandanalyser.CardTest.class})
public class PokerhandanalyserSuite { 
}
