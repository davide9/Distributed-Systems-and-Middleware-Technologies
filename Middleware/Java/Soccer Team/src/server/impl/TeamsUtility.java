package server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import server.Player;
import server.Team;

public class TeamsUtility {
	
	private Map<String, Team> team_map;

    public TeamsUtility() {
		team_map = new HashMap<String, Team>();
		make_test_teams();
    }

    public Team getTeam(String name) {
    	return team_map.get(name);
    }

    public String[] getTeams() {
    	String[] ss = new String[team_map.keySet().size()];
    	int i=0;
    	for (String k : team_map.keySet()) {
    		ss[i] = k;
    		i++;
    	}
		return ss;
    }

    public void make_test_teams() {
    
    		List<Player> playersItaly = new ArrayList<Player>();
    		String teamName = "Italy";
    		Player player = new Player("Buffon", 1);
    		Player player2 = new Player("Pirlo", 22);
    		playersItaly.add(player);
    		playersItaly.add(player2);
    		Team teamItaly = new Team(playersItaly, teamName);
    		
    		team_map.put(teamName, teamItaly);
    		
    		List<Player> playersBrazil = new ArrayList<Player>();
    		String teamNameBrazil = "Brazil";
    		Player player3 = new Player("Neymar", 10);
    		Player player4 = new Player("Silva", 3);
    		playersBrazil.add(player3);
    		playersBrazil.add(player4);
    		Team teamBrazil = new Team(playersBrazil, teamNameBrazil);
    		
    		team_map.put(teamNameBrazil, teamBrazil);
    		
  
    }
	
	
	
	
	

}
