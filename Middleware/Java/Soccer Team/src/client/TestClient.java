package client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import support.Team;
import support.TeamWS;
import support.TeamWSImplService;

public class TestClient {

	public static void main(String[] args) {
		
		TeamWSImplService service = new TeamWSImplService();
		service.setHandlerResolver(new HandlerResolver() {
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				// TODO Auto-generated method stub
				List<Handler> handlers = new ArrayList<Handler>();
				handlers.add(new ClientLogHandler());
				return handlers;
			}
		});
		
		TeamWS port = service.getTeamWSImplPort();
		Team italy = port.getTeam("Italy");
		
		System.out.println("Team received -> " + italy.getName());
		
	}

}
