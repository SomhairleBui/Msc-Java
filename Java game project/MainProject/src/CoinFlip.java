import java.util.*;
// Coinflip game that extends the game superclass;
public class CoinFlip extends Game {
	
	// Default credit value
	private int credits = 20;
	// instructions
	private String guide = "CoinFlip!\nPlace a bet on whether the coin lands heads or tails\nCorrect guess returns double the bet!";
	// Game name
	private String name = "CoinFlip!";
	
	
	// Arg constructor which sets the credits
	public CoinFlip(int creditLimit) {
			this.credits = creditLimit;
	}
	
	// Returns the game name
	public String getName() {
			return name;
	}
	
	// Flip method that uses a random number to determine if heads or tails
	public String flip() {
		// new random
		Random randy = new Random();
		
		float floaty = randy.nextFloat();
		// if the random float is less than .5
		if (floaty <.5) {
			return "heads";
		}else {
			return "tails";
		}
		
	}
	
	
	// Guess method
	public boolean Guess(String guessy) {
		// if the guess is equal to the return value of flip
		if(guessy.equals(this.flip())) {
			// return true
			return true;
			
		}else {
			return false;
		}
	}
	
	// Betting method
	public int Betting(int bet, String guess) {
		// If guess method with guess argument returns true
		if (this.Guess(guess)) {
			// print correct and return double the bet
			System.out.println("Correct!");
			return bet*2;
		}else {
			// print incorrect and return the minus value of the bet
			System.out.println("Incorrect!");
			return -bet;
		}
		
	}
	
	// Actual Coin game that uses all the previous methods
	// Returns the users final score
	
	public int CoinGame() {
		// boolean that keeps track if the user wants to keep playing
		boolean keepPlaying = true;
		// default bet and string values;
		int bet=0;
		String guess="";
		// Call the game superclass begin method (asks the user if they want to view the instructions)
		super.begin(guide);
		// Print the users credits
		System.out.println("Current credits:"+credits);
		// While the user wants to keep playing and isnt broke
		while(keepPlaying && credits > 0) {
			
			// Prompt user for their bet amount
			System.out.println("How much would you like to bet?");
			if(scanny.hasNextInt()) {
			 bet = scanny.nextInt();
			};
			// Check that the bet isnt more then the current credits and more then 0
			while  ( bet < 0 || bet > credits) {
				System.out.println("You dont have enough credits for this bet, please try again with a lower amount");
				System.out.println("Current credits:"+credits);
				System.out.println("How much would you like to bet?");
				if(scanny.hasNextInt()) {
					bet = scanny.nextInt();
				};
			}
			
			// Prompt user for heads or tails input
			System.out.println("Heads or Tails?");
			if(scanny.hasNextLine()) {
				scanny.nextLine(); //This prevents the scanner from firing straight away and enter the while loop
				guess = scanny.nextLine();
				//change it to lower case for checking
				guess = guess.toLowerCase();
			}
			
			// valid input checker
				while (!guess.equals("heads") && !guess.equals("tails")) {
				System.out.println("Invalid guess, please try again");
				System.out.println("Heads or Tails?");
				if(scanny.hasNextLine()) {
					guess = scanny.nextLine();
					guess = guess.toLowerCase();
				}
			}
			
			// add the results of the betting method to the credits
			credits +=(Betting(bet, guess));
			// Print the new credit value
			System.out.println("New Credit value:"+credits);
			// call the super.Exit() method which returns a boolean to see if the user wants to keep playing
			keepPlaying = super.Exit();
		}
		// Print final credits and return them
		System.out.println("Exiting, Your final credits are: "+credits);
		return credits;
		
		
		
		
		
	}
	

}
