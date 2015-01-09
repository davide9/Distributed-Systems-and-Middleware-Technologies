package server;

import java.util.List;

public class Team {
	
	private List<Player> players;
	private String name;
	private String flagURL;
	//private int rosterCount;
	
	//Constructor
	
	public Team(List<Player> players, String name) {
		super();
		this.players = players;
		this.name = name;
	}	
	
	
	//Getters and Setters
	
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlagURL() {
		return flagURL;
	}
	public void setFlagURL(String flagURL) {
		this.flagURL = flagURL;
	}
	public int getRosterCount() {
		return (players == null) ? 0 : players.size();
	}
	public void setRosterCount(int rosterCount) {
	}
	
	
	
	
	

}
