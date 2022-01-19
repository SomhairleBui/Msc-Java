import java.io.*;
import java.util.*;

// scoreboard class
public class scoreboard {
	// Scoreboard file
	File scoreboard= new File("scoreboard.txt");
	// String decorator
	String decorator = "------------------------";
	
	
	// addScore method
	public void addScore(String game, int score, String name) {
		try {
			// adds the game name, score and username to the File
			FileWriter scoreAdder = new FileWriter("scoreboard.txt",true);
			// adds a comma in between each argument
			scoreAdder.write(game+","+score+","+name+"\n");
			scoreAdder.close();
			System.out.println("Score added sucessfully to the leaderboard");
			// catch if error
		}catch (IOException e) {
			System.out.println("Error adding score to the leaderboard");
		}
	}
	
	// Showscore method
	public void showScore() {
		// array list to hold each line of the file
		ArrayList<String> scoreHolder = new ArrayList<String>();
		
		// three hashmaps to store the score and username for each game
		HashMap<Integer,String> coinGameScores = new HashMap<Integer,String>();
		HashMap<Integer,String> rpsGameScores = new HashMap<Integer,String>();
		HashMap<Integer,String> diceGameScores = new HashMap<Integer,String>();
	
		
		try {
			Scanner scoreReader = new Scanner(scoreboard);
			// add each line in the file to the ArrayList
			while(scoreReader.hasNextLine()) {
				String score = scoreReader.nextLine();
				scoreHolder.add(score);
			}// close the scanner
			scoreReader.close();
			// catch file exception
		}catch (FileNotFoundException e) {
			System.out.println("An error has occured, unable to retrieve leaderboard");
		}
		// for each item in the scoreholder array list
		for(String strang : scoreHolder) {
			
			// Split the string by the commas
			String[] strangchunks = strang.split(",",3);
			
			// Using the first argument (The game name)
			// add the score and the username to the corresponding hashmap
			if(strangchunks[0].equals("CoinFlip!")) {
				coinGameScores.put(Integer.parseInt(strangchunks[1]),strangchunks[2]);
			}else if(strangchunks[0].equals("Rock Paper Scissors!")) {
				rpsGameScores.put(Integer.parseInt(strangchunks[1]),strangchunks[2]);
			}else if(strangchunks[0].equals("DiceRoll!")) {
				diceGameScores.put(Integer.parseInt(strangchunks[1]),strangchunks[2]);
			}
		}
		
		// Create new tree map with a reversed order and add the hashmaps to that Treemap (for each game)
		
		Map<Integer,String> sortedCoins = new TreeMap<>(Collections.reverseOrder());
		sortedCoins.putAll(coinGameScores);
		
		Map<Integer,String> sortedrps= new TreeMap<>(Collections.reverseOrder());
		sortedrps.putAll(rpsGameScores);
		
		Map<Integer,String> sortedDice= new TreeMap<>(Collections.reverseOrder());
		sortedDice.putAll(diceGameScores);
		
		// Print the decorators and gameName
		System.out.println(decorator + "\nCoinFlip!\n" +decorator);
		// for each key and value in the Map, print the key and value
		sortedCoins.entrySet().forEach( entry -> {System.out.println(entry.getKey() + " : " +entry.getValue()); });
		// Repeat for each
		System.out.println(decorator + "\nRock, Paper, Scissors!\n" +decorator);
		sortedrps.entrySet().forEach( entry -> {System.out.println(entry.getKey() + " : " +entry.getValue()); });
		System.out.println(decorator + "\nDiceRoll!\n" +decorator);
		sortedDice.entrySet().forEach( entry -> {System.out.println(entry.getKey() + " : " +entry.getValue()); });
		System.out.println(decorator);
	
		
	}

}
