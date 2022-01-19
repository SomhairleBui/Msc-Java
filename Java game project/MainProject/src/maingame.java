import java.util.*;

public class maingame {
	public static void main(String[] args) {
		
		// Open up a scanner for user input
		Scanner userscanner = new Scanner(System.in);
		
		// Print welcome message and get users input
		System.out.println("Welcome!\nPlease choose an option\n1. New Player\n2. Quit");
		scoreboard leader = new scoreboard();
		int playerChoice = userscanner.nextInt();
		
		// Check if the input is valid, if not give error message and re-ask
		while(playerChoice != 1 && playerChoice != 2 ) {
			System.out.println("Invalid Input, please try again");
			System.out.println("Welcome!\nPlease choose an option\n1. New Player\n2. Quit");
		}
		
		// If the user wants to play
		if(playerChoice ==1) {
			// Prompt user to input a name
			System.out.println("Please enter a Name: ");
			userscanner.nextLine();// This stops the scanner from firing before the user input
			String username = userscanner.nextLine();
			
			// Create Player class 
			Player user = new Player();
			
			// Ask user if they are over 18 (To see if they will get a junior account = less credit limit + name)
			System.out.println("Are you over 18? y/n");
			String ageCheck = (userscanner.next()).toLowerCase();
			
			// Another Input check
			while(! ageCheck.equals("y") && !ageCheck.equals("n")){
				System.out.println("Invalid input, please try again");
				ageCheck = (userscanner.next()).toLowerCase();
			}
			
			// if the user is over 18
			if(ageCheck.equals("y")) {
				// Ask if they want a VIP account (more credits + name flair)
				System.out.println("Do you want a VIP account? (Increased credit limit) y/n?");
				// Save input to a variable
				String accountChoice = (userscanner.next()).toLowerCase();
				
				// Another input check, same logic as always
				while(! accountChoice.equals("y") && !accountChoice.equals("n")){
					System.out.println("Invalid input, please try again");
					accountChoice = (userscanner.next()).toLowerCase();
				}
				if(accountChoice.equals("y")) {
					// if they do want a VIP account change user to a VIP player class with the arg constructor using the username
					user = new VIP(username);
				}else {
					// Else add the username to the Player class
					user.addName(username);
				}
				// if the user is under 18
			}else {
				// Change user to a Junior player class with username as an Arg constructor
				user= new junior(username);
			}
			
			// Print Welcome message and the menu choices
			System.out.println("Welcome "+user.getName() + " Please choose an option");
			System.out.println("1. CoinFlip");
			System.out.println("2. Rock, Paper, Scissors");
			System.out.println("3. DiceRoll!");
			System.out.println("4. Show Leaderboard!");
			System.out.println("5. Exit");
			// Save the user choice to the variable below
			int gamechoice = userscanner.nextInt();
			
			// This will be used to save the users scores later on
			int userScore;
			
			//Another input checker, same logic as before
			while(gamechoice != 1 && gamechoice != 2 && gamechoice !=3 && gamechoice !=4 && gamechoice !=5) {
				System.out.println("Invalid Input, please try again");
				System.out.println("Welcome!\nPlease choose an option\n1. New Player\n2. Quit");
				System.out.println("1. CoinFlip");
				System.out.println("2. Rock, Paper, Scissors");
				System.out.println("3. DiceRoll!");
				System.out.println("4. Show Leaderboard!");
				System.out.println("5. Exit");
				userscanner.nextLine();
				gamechoice = userscanner.nextInt();
			}
			// while the choice isnt 5 (which means exit)
			 while (gamechoice != 5) {
				 // enter into a switch statement
				switch(gamechoice) {
				// if the user picks 1
				case 1:
					// Create a new Coinflip game with the users Credit Limit as the constructor argument
					CoinFlip userFlip = new CoinFlip(user.getCreditLimit());
					// Save the results of the coingame to the userscore
					userScore = userFlip.CoinGame();
					// Print the result
					System.out.println(user.getName() + " Coinflip Score: "+ userScore);
					// Add the Game name, score and username to the leaderboard file
					leader.addScore(userFlip.getName(),userScore,user.getName());
					// exit switch statement
					break;
				case 2:
					//Same logic as 1
					RockPaperScissors userRPS = new RockPaperScissors(user.getCreditLimit());
					userScore = userRPS.rpsPlay();
					System.out.println(user.getName() + " RPS Score: "+ userScore);
					leader.addScore(userRPS.getName(),userScore,user.getName());
					break;
				case 3:
					// Same logic as 1
					DiceRoll userDice = new DiceRoll(user.getCreditLimit());
					userScore = userDice.DiceGame();
					System.out.println(user.getName() + " DiceRoll Score: "+ userScore);
					leader.addScore(userDice.getName(),userScore,user.getName());
					break;
				case 4:
					// Show the leaderboard score
					leader.showScore();
					break;
				}
				// After the switch statement bring up the menu again
				System.out.println("Please choose an option");
				System.out.println("1. CoinFlip");
				System.out.println("2. Rock, Paper, Scissors");
				System.out.println("3. DiceRoll!");
				System.out.println("4. Show Leaderboard!");
				System.out.println("5. Exit");
				userscanner.nextLine();
				if(userscanner.hasNextInt()) { // Prevents noSuchElementException
					gamechoice = userscanner.nextInt();
				};
				
				// Yet more input checking
				while(gamechoice != 1 && gamechoice != 2 && gamechoice !=3 && gamechoice !=4 && gamechoice !=5) {
					System.out.println("Invalid Input, please try again");
					System.out.println("Welcome!\nPlease choose an option\n1. New Player\n2. Quit");
					System.out.println("1. CoinFlip");
					System.out.println("2. Rock, Paper, Scissors");
					System.out.println("3. DiceRoll!");
					System.out.println("4. Show Leaderboard!");
					System.out.println("5. Exit");
					userscanner.nextLine();
					gamechoice = userscanner.nextInt();
				}
			}
			 // if choice is 5, print quitting, show the score and close the scanner.
			 System.out.println("Quitting");
			 leader.showScore();
			 userscanner.close();
		
		
		// if user picks 2 for the first choice, print quitting, show the scores and close the userscanner.
		}else {
			 System.out.println("Quitting");
			 leader.showScore();
			 userscanner.close();
		}
			
	}

}
