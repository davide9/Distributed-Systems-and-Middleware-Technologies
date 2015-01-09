package server;

public class Player {
	
	private String name;
	private int number;
	
	//Constructor
	public Player(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
