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
			System.out.println("1. Enter number of players to add." );
			System.out.println("2. Remove number of players to remove.");
			System.out.println("3. Shuffle the cards in the deck.");
			System.out.println("4. Print all the cards in deck.");
			System.out.println("5. Start game.");
			System.out.println("6. Exit game.");
			System.out.println("Choose desired option : ");
			int input = myInput.nextInt();
			
			switch(input)
			{
				case 1:
					n = myInput.nextInt();
					if (players+n > 52) {
						System.out.println("Can't add more than 52 players.");
						break;
					}
					players += n;
				case 2:
					n = myInput.nextInt();
					if (players < n) {
						System.out.println("Can't remove more that existing players.");
						break;
					}
					players -= n;
				case 3:
					deck.shuffleCards();
					break;
				case 4:
					deck.printCards();
					break;
				case 5:
					winner = deck.startGame();
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
