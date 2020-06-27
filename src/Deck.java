import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
enum Suit {
	Spade, Heart, Club, Diamond
}

public class Deck {
	private ArrayList<Card> cards;
	
	/** Function to initialize deck of cards */
	public Deck () {
		cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (int i=1; i<=13; i++) {
				cards.add(new Card(i, suit, true));
			}
		}
	}
	
	/** Function to shuffle cards */
	public void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	/** function to print the cards present in the deck */
	public void printCards() {
		for (int i=0; i<52; i++) {
			if (cards.get(i).isPresentInDeck())
				System.out.println(cards.get(i).getValue() + " " + cards.get(i).getSuit());
		}
	}
	
	/** Function to play the game between 2 players */
	public ArrayList<Card> startGame(int players) {
		ArrayList<Card> playerCards = new ArrayList<Card>();
		for (int i=0; i<players; i++) {
			Card card = cards.get(i);
			cards.get(i).setPresentInDeck(false);
			playerCards.add(card);
		}
		
		return playerCards;
	}
	
	/** Function to print the cards each player is holding */ 
	public void printPlayerList(ArrayList<Card> list) {
		for (int i=0; i<list.size(); i++)
			System.out.println("Player " + (i+1) + " card : " + list.get(i).getValue() + " of " + list.get(i).getSuit());
	}
	
	/** Function to print the winner and return all the cards to deck */
	public void printWinner(ArrayList<Card> playerList) {
		EnumMap<Suit, Integer> em = new EnumMap<Suit, Integer>(Suit.class);
		em.put(Suit.Spade, 1);
		em.put(Suit.Heart, 2);
		em.put(Suit.Club, 3);
		em.put(Suit.Diamond, 4);
		
		int winner = 0;
		for (int i=1; i<playerList.size(); i++) {
			if (playerList.get(i).getValue() > playerList.get(winner).getValue())
				winner = i;
			else if (playerList.get(i).getValue() == playerList.get(winner).getValue()
						&& em.get(playerList.get(i).getSuit()) < em.get(playerList.get(winner).getSuit()))
				winner = i;
		}
		System.out.println("Winner is : " + "Player:" + (winner+1));
		
		for (int i=0; i<52; i++) {
			if (cards.get(i).isPresentInDeck() == false)
				cards.get(i).setPresentInDeck(true);
		}
		playerList.clear();
	}

}
