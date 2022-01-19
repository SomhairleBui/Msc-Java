// VIP class
public class VIP extends Player implements UserAccounts {
	
	public VIP() {
	};
	
	// arg constructor
	public VIP(String name) {
		// calls super constructor
		super(name);
		// adds VIp to the end of the name and sets credit to 50
		this.name +=" *VIP*";
		this.creditLimit=50;
	};
	
	public String getName() {
		return name;
	}
	
	public int getCreditLimit() {
		return creditLimit;
	}

}
