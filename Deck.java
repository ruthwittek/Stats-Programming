// Ruth Wittek - worked on with Evan Tyler and John Hughes

import java.util.ArrayList;
import java.util.Random;

// Stores a list of Card
// - Will Construct with 52 cards
// - Will "shuffle" by randomly drawing all 52 cards and putting them in a new ArrayList
// - Give it drawCard

public class Deck {

	public ArrayList<Card> list, fiveCards, shuffle;
	
	// Initialize variables
	public int pair, twoPairs, threeOfAKind, fullHouse, fourOfAKind, straight, flush;
	double trials;
	
	// Constructor
	public Deck(double trials) {
		this.trials = trials;
		list = new ArrayList<Card>();
		fiveCards = new ArrayList<Card>();
		shuffle = new ArrayList<Card>();
	}

	// Main method: shuffle, draw, and output
	public void PokerProbs( ){
	    for(int i = 0; i < trials; i++){
	     Shuffle();
	     FiveRandomCards();
	    }
	    Stats();
	}
	
	// Construct deck of 52 cards
	public void ConstructDeck() {
		ArrayList<String> suite = new ArrayList<String>();
		String Spades = "Spades", Diamonds = "Diamonds", Hearts = "Hearts", Clubs = "Clubs";
		suite.add(Spades);
		suite.add(Diamonds);
		suite.add(Hearts);
		suite.add(Clubs);
		int x = 13;
		int suitex = 0;
			for(int i = 0; i < 55; i ++) {
				if(x > 0) {
				list.add(new Card(suite.get(suitex),x));
				x--;	
				}
				else {
				suitex++;
				x = 13;
				}
			}
	}

    // Random shuffle
    public void Shuffle(){
        shuffle.clear();
        Random pick = new Random();
        int number;
        String suite;
        int randnom;
        for(int i= 0; i < list.size(); i++) {
            randnom = pick.nextInt(list.size());
            number = list.get(randnom).getNumber();
            suite =  list.get(randnom).getSuite();
           shuffle.add(new Card(suite,number));
        }
    }

	public void FiveRandomCards(){
        Random rand = new Random();
        int randomNum;
        String randomSuite;
        System.out.println("\nFive Random Cards:");
        for(int i = 0; i < 5; i ++){
            int randx = rand.nextInt(shuffle.size());
            randomSuite = shuffle.get(randx).getSuite();
            randomNum = shuffle.get(randx).getNumber();
            System.out.println(randomSuite + randomNum);
            shuffle.remove(list.get(randx));
            fiveCards.add(new Card(randomSuite,randomNum));
        }
        isPair();
        isStraight();
        isFlush();
        int randomNumx;
        String ranSuitex;
        for(int i = 0; i < fiveCards.size(); i ++){
            randomNumx = fiveCards.get(i).getNumber();
            ranSuitex = fiveCards.get(i).getSuite();
            shuffle.add(new Card(ranSuitex, randomNumx));
        }
        fiveCards.clear();
    }

	public void getDeck(){  
        for(int i= 0; i < list.size(); i++) {
            System.out.println("Card" + " " + list.get(i).getNumber()+ " of " +list.get(i).getSuite()+" ");
        }
	}
	    
	// Method for duplicates
    public void isPair(){
        ArrayList<Card> test = new ArrayList<Card>();
        test.add(new Card("Spades",11));
        test.add(new Card("Spades",11));
        test.add(new Card("Spades",11));
        test.add(new Card("Spades",11));
        test.add(new Card("Spades",1));
        int pair = 0;
        for (int i = 0; i < fiveCards.size()-1; i++) {
            for (int j = i+1; j < fiveCards.size(); j++) {
            if(fiveCards.get(i).getNumber() == fiveCards.get(j).getNumber()){
               
                pair++;
                System.out.println(pair);
            } // End if
            if(i == fiveCards.size() - 2){
                if(pair == 1){
                    pair++;
                }
                if(pair == 2){
                    twoPairs++;
                }
                if(pair == 3){
                    threeOfAKind++;
                }
                if(pair == 4){
                    fullHouse++;
                }
                if(pair == 6){
                    fourOfAKind++;
                }
             
            } // End if
            } // End inner for
        } // End outer for
      }

	public void isStraight(){
		int Straight = 0;
		for(int i = 0; i < fiveCards.size(); i++){
			if(i >= fiveCards.size() + 1 - fiveCards.size()){
				if(fiveCards.get(i - 1).getNumber() > fiveCards.get(i).getNumber()){
				Straight++;
				}
				if(i == fiveCards.size() - 1){
					if(Straight == 4){
					//Five cards in descending order
					System.out.println("\nStraight");
					straight++;
					} // End if
				} // End inner if
			} // End outer if
		} // End for
	}

	public void isFlush() {
		int Flush = 0;
		for(int i = 0; i < fiveCards.size(); i++){
			if(i >= fiveCards.size() + 1 - fiveCards.size()){
				if(fiveCards.get(i - 1).getSuite() == fiveCards.get(i).getSuite()){
				Flush++;
				}
			if(i == fiveCards.size() - 1){
				if(Flush == 4){
				//Five cards in descending order
				System.out.println("\nFlush");
				flush++;
				} // End if
			} // End inner if
			} // End outer if
		} // End for
	}
    
    public void Stats() {          
    	System.out.println("\nOne Pair: "+ pair * 100/ trials+"%" +
    						"\nTwo Pairs: " + twoPairs * 100 /trials+"%"+
    						"\nThree of a Kind: "+ threeOfAKind * 100 /trials +"%"+
    						"\nFull House: "+ fullHouse * 100 /trials +"%"+
    						"\nFour of a Kind: " + fourOfAKind * 100 /trials + "%"+
    						"\nStraight: " +straight * 100 /trials + "%"+
    						"\nFlush: "+ flush * 100 /trials+"%");
	}

} // End class