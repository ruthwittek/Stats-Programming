// Test 10,000 hands, testing each of the above separately
// Record and output the probability of each of these events occurring

public class HandTester {

    public static void main (String args[]) {
        Deck deck = new Deck(10000);
        deck.ConstructDeck();
        deck.PokerProbs();
    }

} // End class
