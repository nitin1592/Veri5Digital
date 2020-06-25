public class Card {
	private int value;
	private Suit suit;
	private boolean isPresentInDeck;
	public Card (int value, Suit suit, boolean isPresentInDeck) {
		this.value = value;
		this.suit = suit;
		this.isPresentInDeck = isPresentInDeck;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public boolean isPresentInDeck() {
		return isPresentInDeck;
	}
	public void setPresentInDeck(boolean isPresentInDeck) {
		this.isPresentInDeck = isPresentInDeck;
	}
	
	
}
