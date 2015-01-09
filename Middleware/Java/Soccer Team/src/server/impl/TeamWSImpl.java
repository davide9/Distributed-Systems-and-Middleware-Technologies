package server.impl;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import server.Team;
import server.TeamWS;

@WebService(endpointInterface="server.TeamWS")
@HandlerChain(file="handler-chain-service.xml")
public class TeamWSImpl implements TeamWS{
	
	private TeamsUtility utils;
	
	public TeamWSImpl() {
		utils = new TeamsUtility();
	}

	@Override
	public String[] getTeams() {
		// TODO Auto-generated method stub
		return utils.getTeams();
	}

	@Override
	public Team getTeam(String name) {
		// TODO Auto-generated method stub
		return utils.getTeam(name);
	}

}
