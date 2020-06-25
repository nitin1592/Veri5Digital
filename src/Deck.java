import java.util.Random;

enum Suit {
	Spade, Heart, Club, Diamond
}

public class Deck {
	private Card[] cards;
	
	public Deck () {
		cards = new Card[52];
		int index = 0;
		for (Suit suit : Suit.values()) {
			for (int i=1; i<=13; i++) {
				cards[index++] = new Card(i, suit, true);
			}
		}
	}
	
	public void swap (CardWrapper cw1, CardWrapper cw2) {
		Card temp = cw1.getCard();
		cw1.setCard(cw2.getCard());
		cw2.setCard(temp);
	}
	
	public void shuffleCards() {
		Random rand = new Random();
		for (int i = 0; i < 52; i++) 
        {
            int r = i + rand.nextInt(52 - i);
            CardWrapper cw1 = new CardWrapper(cards[i]);
            CardWrapper cw2 = new CardWrapper(cards[r]);
            swap (cw1, cw2);
        } 
	}
	
	public void printCards() {
		for (int i=0; i<52; i++) {
			if (cards[i].isPresentInDeck())
				System.out.println(cards[i].getValue() + " " + cards[i].getSuit());
		}
	}
	
	public Card startGame() {
		return null;
	}

}
