package server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TeamWS {
	
	@WebMethod public String[] getTeams();
	@WebMethod public Team getTeam(String name);

}
