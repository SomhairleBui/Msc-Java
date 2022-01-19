import java.util.*;

public class DiceRoll extends Game {
	// Default credit value
	private int credits = 20;
	// Instructions and game name
	private String guide = "DiceRoll!\nPlace a bet and try to roll higher then the dealer!\nWinning returns double the bet";
	private String name = "DiceRoll!";
	
	// arg constructor that sets the credits
	public DiceRoll(int creditLimit) {
		this.credits= creditLimit;
	}
	// Return game name method
	public String getName() {
		return name;
	}
	
	// Roll method that returns a method between one and six
	public int Roll() {
		Random randy = new Random();
		return randy.nextInt(6)+1;
	}
	
	// Winner method that compares two ints obtained from the roll
	// 1 is if the user is larger, 2 is for a draw, 3 is for the user is smaller
	public int Winner(int userGuess, int dealerGuess) {
		if(userGuess > dealerGuess) {
			return 1;
		}else if (userGuess == dealerGuess) {
			return 2;
		}else {
			return 3;
		}
	}
	
	// Main game method that returns the final credits score
	public int DiceGame(){
		// Boolean value to indicate when the user want to quit
		boolean keepPlaying=true;
		int bet = 0;
		
		// Super begin method which allows the user to show instructions
		super.begin(guide);
		
		System.out.println("Current credits:"+credits);
		// while the user wants to keep playing and isnt broke
		while(keepPlaying && credits > 0) {
			System.out.println("How much would you like to bet?");
			// input checker
			if(scanny.hasNextInt()) {
			 bet = scanny.nextInt();
			}else {
				System.out.println("Input must be an integer, please try again");
				System.out.println("How much would you like to bet?");
				scanny.next();
				// This only allows for one messup before the whole thing crashes but if you cant figure out what an int is by then you dont deserve to play
				bet = scanny.nextInt();
			}
			// checks that the bet is more than 0 and within that the credit limit
			while (bet < 0 || bet > credits) {
				System.out.println("You dont have enough credits for this bet, please try again with a lower amount");
				System.out.println("Current credits:"+credits);
				System.out.println("How much would you like to bet?");
				if(scanny.hasNextInt()) {
					bet = scanny.nextInt();
				};
			}
			
			
			
			System.out.println("Rolling!");
			// Call roll method for the user and print results
			int userRoll = this.Roll();
			System.out.println("You roll a "+ userRoll);
			// call roll method for the dealer
			int dealerRoll= this.Roll();
			
			// switch statement for the result of Calling winner method with both rolls
			switch(Winner(userRoll,dealerRoll)) {
			case 1:
				// if 1 (user wins)
				System.out.println("Dealer rolls a "+dealerRoll+" You Win!");
				// add double the bet to the credits
				credits += bet *2;
				break;
			case 2:
				// if 2 (draw) no change
				System.out.println("Dealer rolls a "+dealerRoll+" Draw!, no credits lost");
				break;
			case 3:
				// if 3 minus the bet from the credits
				System.out.println("Dealer rolls a "+dealerRoll+" You lose!");
				credits -= bet;
				break;
				
			}
			
			System.out.println("New Credit value:"+credits);
			// ask the user if they want to keep playing (using superclass exit method)
			keepPlaying = super.Exit();
		}
		// print final credits and exit
		System.out.println("Exiting, your final credits are: "+credits);
		return credits;
		
	}

}
