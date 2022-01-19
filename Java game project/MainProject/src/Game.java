import java.util.*;

// Game class thats used to give the games some common functionality
public class Game {
	
	// Scanner thats used for the user input for all games
	 static Scanner scanny = new Scanner(System.in);
	 // Credit limit, will be set in each game by the users credit limit
	 int credits;
	 // Instructions and strings, will be updated in each game type.
	 String instructions = "This is a testing instruction";
	 String name="Testing aon do";
	 
	 // No arg and Arg constructor
	 public Game() {
		 this.credits=20;
	 }
	 
	 public Game (int creditLimit) {
		 this.credits = creditLimit;
	 }
	 
	 

	// Begin method to give the user the choice to view instructions or start
	public void begin(String instructions) {
		System.out.println("Press 1 to show instructions or 2 to Start");
		int choice = scanny.nextInt();
		// Input checking
		while(choice != 1 && choice != 2) {
			System.out.println("Invalid input, please try again");
			choice = scanny.nextInt();
		}
		if (choice == 1) {
			System.out.println(instructions);
		}
		
	}
	
	// Exit method the Boolean value returned is used to indicate whether or not to exit the game
	public boolean Exit() {
		// Ask user if they want to try again
		System.out.println("Do you want to try again? type Y for yes or N for no");
		// get the user input and set it to lowercase to make comparison easier
		String choice = (scanny.next()).toLowerCase();
		// input checking
		while(! choice.equals("y") && ! choice.equals("n")) {
			System.out.println("Invalid input, please try again");
			choice = (scanny.next()).toLowerCase();
		}
		if(choice.equals("y")) {
			return true;
		}else {
			//scanny.close();
			return false;
		}
		
	}

}

