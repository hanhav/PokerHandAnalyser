package pokerhandanalyser;
    
/**
*
* @author Hannu Havila
*/

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck();
        
        Hand hand = new Hand(deck);
        Hand hand2 = new Hand(deck);
        Hand hand3 = new Hand(deck);
        
        int result = hand.analyzeCardHand();
        int result2 = hand2.analyzeCardHand();
        int result3 = hand3.analyzeCardHand();
        
        System.out.println("--- DEALT HANDS ---\nFirst Hand\n" + hand + "\nSecond Hand\n" + hand2 + "\nThird Hand\n" + hand3 + "\n");
        
        if(result == 1 || result2 == 1 || result3 == 1){
            System.out.println("Straightflush !!!");
            
        }
        if(result == 2 || result2 == 2 || result3 == 2){
            System.out.println("Flush !!!");
            
        }
        if(result == 3 || result2 == 3 || result3 == 3){
            System.out.println("Straight !!!");
            
        }
        if(result == 4 || result2 == 4 || result3 == 4){
            System.out.println("Two pairs !!!");
        }
    }
}
