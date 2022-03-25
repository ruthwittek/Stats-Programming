// Has a String suite, and a number

public class Card {

	int number;
	String suite;
	    
	public Card(String suite, int number) {
		this.number = number;
		this.suite = suite;
	}

	public String getSuite() {
		return suite;    
	}

	public int getNumber() {
		return number;
	}
	
} // End class
