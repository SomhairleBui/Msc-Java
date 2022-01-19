// junior account if the user is under 18
public class junior extends Player implements UserAccounts{
	
	public junior() {
		
	}
	// arg constructor
	public junior(String name) {
		super(name);
		// adds Jr. to the end of the name and sets credit to 10
		this.name += " Jr.";
		this.creditLimit=10;
	}
	
	public void addName(String name) {
		this.name += name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCreditLimit() {
		return creditLimit;
	}

}
