import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner myInput = new Scanner( System.in );
		
		Deck deck = new Deck();
		Card card = null;
		int players = 0;
		ArrayList<Card> drawnCards = new ArrayList<Card>();
		Card winner = null;
		int n = 0;
		
		while (true) {
			System.out.println("\n");
			System.out.println("total number of players present : " + players);
			System.out.println("1. Add players.");
			System.out.println("2. Remove players.");
			System.out.println("3. Shuffle the cards in the deck.");
			System.out.println("4. Print all the cards in deck.");
			System.out.println("5. Start game.");
			System.out.println("6. Exit game.");
			System.out.println("Choose desired option : ");
			int input = myInput.nextInt();
			
			switch(input)
			{
				case 1:
					System.out.println("Enter number of players to add : ");
					n = myInput.nextInt();
					if (n < 0) {
						System.out.println("Can't add more than 52 players.");
						break;
					}
					else if (players+n > 52) {
						System.out.println("Can't add more than 52 players.");
						break;
					}
					
					players += n;
					break;
				case 2:
					System.out.println("Enter number of players to remove : ");
					n = myInput.nextInt();
					if (n < 0) {
						System.out.println("Can't add more than 52 players.");
						break;
					}
					else if (players < n) {
						System.out.println("Can't remove more that existing players.");
						break;
					}
					players -= n;
					break;
				case 3:
					deck.shuffleCards();
					break;
				case 4:
					deck.printCards();
					break;
				case 5:
					if (players == 0) {
						System.out.println("Please add players in the game.");
						break;
					}
					ArrayList<Card> playerList = deck.startGame(players);
					deck.printPlayerList(playerList);
					deck.printWinner(playerList);
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("Enter valid option");
					continue;
			}
		}

	}

}
