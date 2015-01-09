package worldcup.testclient;

import java.util.List;

import worldcup.ArrayOftTeamInfo;
import worldcup.Info;
import worldcup.InfoSoapType;
import worldcup.TTeamInfo;

public class TestClient {

	public static void main(String[] args) {
		
		Info service = new Info();
		InfoSoapType port = service.getInfoSoap();
		
		/*
		ArrayOftTeamInfo teams = port.teams();
		List<TTeamInfo> teamInfos = teams.getTTeamInfo();
		for (TTeamInfo info : teamInfos) {
			System.out.println("Country name -> " + info.getSName());
			System.out.println("Country flag URL -> " + info.getSCountryFlagLarge());
			System.out.println("Country wiki -> " + info.getSWikipediaURL());
		}
		*/
		
		List<String> players = port.fullTeamInfo("Italy").getSForwards().getString();
		for (String s : players) {
			System.out.println(s);
		}
		
		
		

	}

}
