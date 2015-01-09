package server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TimeWS {
	@WebMethod 
	public String getTimeAsString();
	@WebMethod 
	public long getTimeAsElapsed();
}
