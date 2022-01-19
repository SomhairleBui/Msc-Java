// Player class
public class Player implements UserAccounts {
	String name ="";
	int creditLimit = 20;
	
	public Player() {
		
	}
	// Arg constructor that sets the name and creditlimit
	public Player(String name) {
		this.name += name;
		this.creditLimit=20;
	}
	// add name method
	public void addName(String name) {
		this.name+= name;
	}
	// get name method
	public String getName() {
		return name;
	}
	
	// getcredit limit method (used for the games)
	public int getCreditLimit() {
		return creditLimit;
	}

}
