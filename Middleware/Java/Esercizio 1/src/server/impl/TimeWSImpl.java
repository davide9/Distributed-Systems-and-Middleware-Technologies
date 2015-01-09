package server.impl;

import java.util.Date;

import javax.jws.WebService;

import server.TimeWS;

@WebService(endpointInterface="server.TimeWS")
public class TimeWSImpl implements TimeWS {

	@Override
	public String getTimeAsString() {
		return new Date().toString();
	}

	@Override
	public long getTimeAsElapsed() {
		return new Date().getTime();
	}

}
