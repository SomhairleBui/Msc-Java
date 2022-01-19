import java.util.*;

public class RockPaperScissors extends Game{
	// Default credit value
	private int credits = 20;
	// choices the dealer can make
	String[] choice = {"Rock","Paper","Scissors"};
	// Instructions and game name
	private String guide = "Rock, Paper, Scissors!\nPlace your bet and try to beat the dealer\nWins pay double the bet\nDraws lose nothing";
	private String name="Rock Paper Scissors!";
	
	// Return game name method
	public String getName() {
		return name;
	}
	
	
	// arg constructor that sets the credits
	public RockPaperScissors(int creditLimit) {
		this.credits = creditLimit;
	}

	// Method which picks the dealers choice
	public String dealerThrow() {
		// calls a random int between 0 and 2
		Random randy = new Random();
		int pick = randy.nextInt(3);
		
		// uses that random int as the index and returns corresponding choice
		return choice[pick];
	}
	
	// Method to get the users choice
	public String userThrow() {
		// Prompts the user for a choice
		System.out.print("Rock (r) Paper (p) or Scissors(s) ?");
		// sets the userchoice variabscorele to the input (to lower case to make comparison easier)
		String userchoice = (scanny.next()).toLowerCase();
		
		// Valid input checker
		while(! userchoice.equals("r") && !userchoice.equals("s") && !userchoice.equals("p"))  {
			System.out.println("Invalid input, please try again");
			userchoice = (scanny.next()).toLowerCase();
		}
		// Returns the proper String of the user input (for comparison in the main game)
		if(userchoice.equals("r")) {
			return "Rock";
		}
		else if(userchoice.equals("p")) {
			return "Paper";
		}
		else {
			return "Scissors";
		}
	}
	
	// Outcome method Takes two string and a bet amount
	public int outcome(String dealerpick, String userpick , int bet) {
		// if the string are equal return 0
		if(dealerpick.equals(userpick)) {
			System.out.println("Draw!");
			return 0;
		}
		// Results for the RPS game, wins return double the bet, losses return minus the bet
		if(userpick.equals("Rock")) {
			if (dealerpick.equals("Paper")) {
				System.out.println("Dealer chose paper, you lose");
				return -bet;
			}else {
				System.out.println("Dealer chose Scissors, you win!");
				return bet*2;
			}
		}
		if(userpick.equals("Paper")) {
			if (dealerpick.equals("Scissors")) {
				System.out.println("Dealer chose Scissors, you lose");
				return -bet;
			}else {
				System.out.println("Dealer chose Rock, you win!");
				return bet*2;
			}
		}
		if(userpick.equals("Scissors")) {
			if (dealerpick.equals("Rock")) {
				System.out.println("Dealer chose Rock, you lose");
				return -bet;
			}else {
				System.out.println("Dealer chose Paper, you win!");
				return bet*2;
			}
		}
		return 0;
	}
	
	// Main game method
	public int rpsPlay() {
		// Boolean value to indicate when the user want to quit
		boolean keepPlaying = true;
		
		// Super begin method which allows the user to show instructions
		super.begin(guide);
		
		// while the user wants to keep playing and isnt broke
		while(keepPlaying && credits > 0) {
			System.out.print("Current credits:"+credits);
			System.out.print("How much would you like to bet?");
			// default bet value;
			int bet = 0;
			
			// input checker
			if (scanny.hasNextInt()) {
				bet = scanny.nextInt();
			}else {
				System.out.println("Input must be an integer, please try again");
				System.out.println("How much would you like to bet?");
				scanny.next();
				// This only allows for one messup before the whole thing crashes but if you cant figure out what an int is by then you dont deserve to play
				bet = scanny.nextInt();
			}
			// checks that the bet is more than 0 and within that the credit limit
			while(bet < 0 || bet > credits) {
				System.out.println("Bet must be a positive integer less than your current credits, please try again");
				System.out.println("Current credits:"+credits);
				System.out.println("How much would you like to bet?");
				bet = scanny.nextInt();
			}
			
			
			// Use the methods above to get the dealer and the users choice
			String dealerHand = this.dealerThrow();
			String userHand = this.userThrow();
			
			// add the retults of the outcome to the credits
			credits += outcome(dealerHand,userHand,bet);
			
			// ask the user if they want to keep playing (using superclass exit method)
			keepPlaying = super.Exit();
			
			}
		// print final credits and exit
		System.out.println("Exiting, Your final credits are: "+credits);
		return credits;
	}
}
	


