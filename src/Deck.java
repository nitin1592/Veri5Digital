import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
enum Suit {
	Spade, Heart, Club, Diamond
}

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck () {
		cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (int i=1; i<=13; i++) {
				cards.add(new Card(i, suit, true));
			}
		}
	}
	
	public void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	public void printCards() {
		for (int i=0; i<52; i++) {
			if (cards.get(i).isPresentInDeck())
				System.out.println(cards.get(i).getValue() + " " + cards.get(i).getSuit());
		}
	}
	
	public ArrayList<Card> startGame(int players) {
		ArrayList<Card> playerCards = new ArrayList<Card>();
		for (int i=0; i<players; i++) {
			Card card = cards.get(i);
			cards.get(i).setPresentInDeck(false);
			playerCards.add(card);
		}
		
		return playerCards;
	}
	
	public void printPlayerList(ArrayList<Card> list) {
		for (int i=0; i<list.size(); i++)
			System.out.println("Player " + i + " card : " + list.get(i).getValue() + " of " + list.get(i).getSuit());
	}
	
	public void printWinner(ArrayList<Card> playerList) {
		EnumMap<Suit, Integer> em = new EnumMap<Suit, Integer>(Suit.class);
		em.put(Suit.Spade, 1);
		em.put(Suit.Heart, 2);
		em.put(Suit.Club, 3);
		em.put(Suit.Diamond, 4);
		
//		Collections.sort(playerList, (card1, card2) -> {
//			if (card1.getValue() == card2.getValue())
//				return em.get(card1.getSuit()) - em.get(card2.getSuit());
//			return card2.getValue()-card1.getValue();
//		});
		int winner = 0;
		for (int i=1; i<playerList.size(); i++) {
			if (playerList.get(i).getValue() > playerList.get(winner).getValue())
				winner = i;
			else if (playerList.get(i).getValue() == playerList.get(winner).getValue()
						&& em.get(playerList.get(i).getSuit()) < em.get(playerList.get(winner).getSuit()))
				winner = i;
		}
		System.out.println("Winner is : " + "Player:" + winner);
	}

}
