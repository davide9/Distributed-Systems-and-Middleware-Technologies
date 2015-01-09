
package worldcup;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InfoSoapType", targetNamespace = "http://footballpool.dataaccess.eu")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InfoSoapType {


    /**
     * Returns an array with the id, name, country and flag reference of all players
     * 
     * @param bSelected
     * @return
     *     returns worldcup.ArrayOftPlayerNames
     */
    @WebMethod(operationName = "AllPlayerNames")
    @WebResult(name = "AllPlayerNamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayerNames", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayerNames")
    @ResponseWrapper(localName = "AllPlayerNamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayerNamesResponse")
    public ArrayOftPlayerNames allPlayerNames(
        @WebParam(name = "bSelected", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSelected);

    /**
     * Returns an array with the names of all defenders. If you pass a country name the result will be filtered on that country, so you only get the defenders listed for the specified country
     * 
     * @param sCountryName
     * @return
     *     returns worldcup.ArrayOfString
     */
    @WebMethod(operationName = "AllDefenders")
    @WebResult(name = "AllDefendersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllDefenders", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllDefenders")
    @ResponseWrapper(localName = "AllDefendersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllDefendersResponse")
    public ArrayOfString allDefenders(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sCountryName);

    /**
     * Returns an array with the names of all goalkeepers. If you pass a country name the result will be filtered on that country, so you only get the goalkeepers listed for the specified country
     * 
     * @param sCountryName
     * @return
     *     returns worldcup.ArrayOfString
     */
    @WebMethod(operationName = "AllGoalKeepers")
    @WebResult(name = "AllGoalKeepersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllGoalKeepers", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllGoalKeepers")
    @ResponseWrapper(localName = "AllGoalKeepersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllGoalKeepersResponse")
    public ArrayOfString allGoalKeepers(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sCountryName);

    /**
     * Returns an array with the names of all forwards. If you pass a country name the result will be filtered on that country, so you only get the forwards listed for the specified country
     * 
     * @param sCountryName
     * @return
     *     returns worldcup.ArrayOfString
     */
    @WebMethod(operationName = "AllForwards")
    @WebResult(name = "AllForwardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllForwards", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllForwards")
    @ResponseWrapper(localName = "AllForwardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllForwardsResponse")
    public ArrayOfString allForwards(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sCountryName);

    /**
     * Returns an array with the names of all midfields. If you pass a country name the result will be filtered on that country, so you only get the midfields listed for the specified country
     * 
     * @param sCountryName
     * @return
     *     returns worldcup.ArrayOfString
     */
    @WebMethod(operationName = "AllMidFields")
    @WebResult(name = "AllMidFieldsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllMidFields", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllMidFields")
    @ResponseWrapper(localName = "AllMidFieldsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllMidFieldsResponse")
    public ArrayOfString allMidFields(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sCountryName);

    /**
     * Returns an array with the top N goal scorers and their current score. Pass 0 as TopN and you get them all.
     * 
     * @param iTopN
     * @return
     *     returns worldcup.ArrayOftTopGoalScorer
     */
    @WebMethod(operationName = "TopGoalScorers")
    @WebResult(name = "TopGoalScorersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TopGoalScorers", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TopGoalScorers")
    @ResponseWrapper(localName = "TopGoalScorersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TopGoalScorersResponse")
    public ArrayOftTopGoalScorer topGoalScorers(
        @WebParam(name = "iTopN", targetNamespace = "http://footballpool.dataaccess.eu")
        int iTopN);

    /**
     * Returns an array with the top N selected goal scorers and how often they are selected. Pass 0 as TopN and you get them all.
     * 
     * @param iTopN
     * @return
     *     returns worldcup.ArrayOftTopSelectedGoalScorer
     */
    @WebMethod(operationName = "TopSelectedGoalScorers")
    @WebResult(name = "TopSelectedGoalScorersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TopSelectedGoalScorers", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TopSelectedGoalScorers")
    @ResponseWrapper(localName = "TopSelectedGoalScorersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TopSelectedGoalScorersResponse")
    public ArrayOftTopSelectedGoalScorer topSelectedGoalScorers(
        @WebParam(name = "iTopN", targetNamespace = "http://footballpool.dataaccess.eu")
        int iTopN);

    /**
     * Returns an array with players that have a red or a yellow card. Note: You can only sort on Name, Yellow or Red cards, not on a combination.
     * 
     * @param bSortedByYellowCards
     * @param bSortedByName
     * @param bSortedByRedCards
     * @return
     *     returns worldcup.ArrayOftPlayersWithCards
     */
    @WebMethod(operationName = "AllPlayersWithYellowOrRedCards")
    @WebResult(name = "AllPlayersWithYellowOrRedCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayersWithYellowOrRedCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayersWithYellowOrRedCards")
    @ResponseWrapper(localName = "AllPlayersWithYellowOrRedCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayersWithYellowOrRedCardsResponse")
    public ArrayOftPlayersWithCards allPlayersWithYellowOrRedCards(
        @WebParam(name = "bSortedByName", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByName,
        @WebParam(name = "bSortedByYellowCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByYellowCards,
        @WebParam(name = "bSortedByRedCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByRedCards);

    /**
     * Returns an array with players that have a yellow card. Note: You can only sort on Name or Yellow cards, not on a combination.
     * 
     * @param bSortedByYellowCards
     * @param bSortedByName
     * @return
     *     returns worldcup.ArrayOftPlayersWithCards
     */
    @WebMethod(operationName = "AllPlayersWithYellowCards")
    @WebResult(name = "AllPlayersWithYellowCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayersWithYellowCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayersWithYellowCards")
    @ResponseWrapper(localName = "AllPlayersWithYellowCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayersWithYellowCardsResponse")
    public ArrayOftPlayersWithCards allPlayersWithYellowCards(
        @WebParam(name = "bSortedByName", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByName,
        @WebParam(name = "bSortedByYellowCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByYellowCards);

    /**
     * Returns an array with players that have a red card. Note: You can only sort on Name or Red cards, not on a combination.
     * 
     * @param bSortedByName
     * @param bSortedByRedCards
     * @return
     *     returns worldcup.ArrayOftPlayersWithCards
     */
    @WebMethod(operationName = "AllPlayersWithRedCards")
    @WebResult(name = "AllPlayersWithRedCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayersWithRedCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayersWithRedCards")
    @ResponseWrapper(localName = "AllPlayersWithRedCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllPlayersWithRedCardsResponse")
    public ArrayOftPlayersWithCards allPlayersWithRedCards(
        @WebParam(name = "bSortedByName", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByName,
        @WebParam(name = "bSortedByRedCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByRedCards);

    /**
     * Returns an array with all given cards during the tournament
     * 
     * @return
     *     returns worldcup.ArrayOftCardInfo
     */
    @WebMethod(operationName = "AllCards")
    @WebResult(name = "AllCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllCards")
    @ResponseWrapper(localName = "AllCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllCardsResponse")
    public ArrayOftCardInfo allCards();

    /**
     * Returns an array with all the city names where games are played
     * 
     * @return
     *     returns worldcup.ArrayOfString
     */
    @WebMethod(operationName = "Cities")
    @WebResult(name = "CitiesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Cities", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.Cities")
    @ResponseWrapper(localName = "CitiesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.CitiesResponse")
    public ArrayOfString cities();

    /**
     * Returns an array of stadium names where the games are played
     * 
     * @return
     *     returns worldcup.ArrayOfString
     */
    @WebMethod(operationName = "StadiumNames")
    @WebResult(name = "StadiumNamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "StadiumNames", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.StadiumNames")
    @ResponseWrapper(localName = "StadiumNamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.StadiumNamesResponse")
    public ArrayOfString stadiumNames();

    /**
     * Returns a URL that can be used to show a small map of the stadium
     * 
     * @param sStadiumName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "StadiumURL")
    @WebResult(name = "StadiumURLResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "StadiumURL", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.StadiumURL")
    @ResponseWrapper(localName = "StadiumURLResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.StadiumURLResponse")
    public String stadiumURL(
        @WebParam(name = "sStadiumName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sStadiumName);

    /**
     * Returns the information we keep about a particular stadium, Pass the name of the stadium
     * 
     * @param sStadiumName
     * @return
     *     returns worldcup.TStadiumInfo
     */
    @WebMethod(operationName = "StadiumInfo")
    @WebResult(name = "StadiumInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "StadiumInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.StadiumInfo")
    @ResponseWrapper(localName = "StadiumInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.StadiumInfoResponse")
    public TStadiumInfo stadiumInfo(
        @WebParam(name = "sStadiumName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sStadiumName);

    /**
     * Returns an array with all stadiums. The array contains the names, the city where the stadium can be found and the seat capacity
     * 
     * @return
     *     returns worldcup.ArrayOftStadiumInfo
     */
    @WebMethod(operationName = "AllStadiumInfo")
    @WebResult(name = "AllStadiumInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllStadiumInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllStadiumInfo")
    @ResponseWrapper(localName = "AllStadiumInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllStadiumInfoResponse")
    public ArrayOftStadiumInfo allStadiumInfo();

    /**
     * Returns all team info from a passed team; name, flag, playernames (by role), trainer
     * 
     * @param sTeamName
     * @return
     *     returns worldcup.TFullTeamInfo
     */
    @WebMethod(operationName = "FullTeamInfo")
    @WebResult(name = "FullTeamInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "FullTeamInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.FullTeamInfo")
    @ResponseWrapper(localName = "FullTeamInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.FullTeamInfoResponse")
    public TFullTeamInfo fullTeamInfo(
        @WebParam(name = "sTeamName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sTeamName);

    /**
     * Returns an array of all teams that compete with a link to the picture of their flag
     * 
     * @return
     *     returns worldcup.ArrayOftTeamInfo
     */
    @WebMethod(operationName = "Teams")
    @WebResult(name = "TeamsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Teams", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.Teams")
    @ResponseWrapper(localName = "TeamsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TeamsResponse")
    public ArrayOftTeamInfo teams();

    /**
     * Returns the number of groups in the tournament
     * 
     * @return
     *     returns int
     */
    @WebMethod(operationName = "GroupCount")
    @WebResult(name = "GroupCountResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GroupCount", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GroupCount")
    @ResponseWrapper(localName = "GroupCountResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GroupCountResponse")
    public int groupCount();

    /**
     * Returns an array of group id's and descriptions. Group is a poule collection of a knock out level
     * 
     * @return
     *     returns worldcup.ArrayOftGroupInfo
     */
    @WebMethod(operationName = "Groups")
    @WebResult(name = "GroupsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Groups", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.Groups")
    @ResponseWrapper(localName = "GroupsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GroupsResponse")
    public ArrayOftGroupInfo groups();

    /**
     * List all the members of a group/poule
     * 
     * @param sPoule
     * @return
     *     returns worldcup.ArrayOftTeamInfo
     */
    @WebMethod(operationName = "GroupCompetitors")
    @WebResult(name = "GroupCompetitorsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GroupCompetitors", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GroupCompetitors")
    @ResponseWrapper(localName = "GroupCompetitorsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GroupCompetitorsResponse")
    public ArrayOftTeamInfo groupCompetitors(
        @WebParam(name = "sPoule", targetNamespace = "http://footballpool.dataaccess.eu")
        String sPoule);

    /**
     * List all the members of all groups/poules
     * 
     * @return
     *     returns worldcup.ArrayOftGroupsCompetitors
     */
    @WebMethod(operationName = "AllGroupCompetitors")
    @WebResult(name = "AllGroupCompetitorsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllGroupCompetitors", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllGroupCompetitors")
    @ResponseWrapper(localName = "AllGroupCompetitorsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllGroupCompetitorsResponse")
    public ArrayOftGroupsCompetitors allGroupCompetitors();

    /**
     * Returns an array of scored goals. If the game id is passed only for that game. You can get the game ID's via the method AllGames
     * 
     * @param iGameId
     * @return
     *     returns worldcup.ArrayOftGoal
     */
    @WebMethod(operationName = "GoalsScored")
    @WebResult(name = "GoalsScoredResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GoalsScored", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GoalsScored")
    @ResponseWrapper(localName = "GoalsScoredResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GoalsScoredResponse")
    public ArrayOftGoal goalsScored(
        @WebParam(name = "iGameId", targetNamespace = "http://footballpool.dataaccess.eu")
        int iGameId);

    /**
     * Returns the information about a particular game
     * 
     * @param iGameId
     * @return
     *     returns worldcup.TGameInfo
     */
    @WebMethod(operationName = "GameInfo")
    @WebResult(name = "GameInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GameInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GameInfo")
    @ResponseWrapper(localName = "GameInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GameInfoResponse")
    public TGameInfo gameInfo(
        @WebParam(name = "iGameId", targetNamespace = "http://footballpool.dataaccess.eu")
        int iGameId);

    /**
     * Returns an array of games information
     * 
     * @return
     *     returns worldcup.ArrayOftGameInfo
     */
    @WebMethod(operationName = "AllGames")
    @WebResult(name = "AllGamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllGames", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllGames")
    @ResponseWrapper(localName = "AllGamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.AllGamesResponse")
    public ArrayOftGameInfo allGames();

    /**
     * Returns an array of country names. The country is a property of a participant. You need the country ID to call PersonsPerCountry.
     * 
     * @param bWithCompetitors
     * @return
     *     returns worldcup.ArrayOftCountryInfo
     */
    @WebMethod(operationName = "CountryNames")
    @WebResult(name = "CountryNamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "CountryNames", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.CountryNames")
    @ResponseWrapper(localName = "CountryNamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.CountryNamesResponse")
    public ArrayOftCountryInfo countryNames(
        @WebParam(name = "bWithCompetitors", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bWithCompetitors);

    /**
     * Number of games played so far
     * 
     * @return
     *     returns int
     */
    @WebMethod(operationName = "GamesPlayed")
    @WebResult(name = "GamesPlayedResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GamesPlayed", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GamesPlayed")
    @ResponseWrapper(localName = "GamesPlayedResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GamesPlayedResponse")
    public int gamesPlayed();

    /**
     * Returns an array of Games that are played in the passed city name
     * 
     * @param sCityName
     * @return
     *     returns worldcup.ArrayOftGameInfo
     */
    @WebMethod(operationName = "GamesPerCity")
    @WebResult(name = "GamesPerCityResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GamesPerCity", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GamesPerCity")
    @ResponseWrapper(localName = "GamesPerCityResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GamesPerCityResponse")
    public ArrayOftGameInfo gamesPerCity(
        @WebParam(name = "sCityName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sCityName);

    /**
     * Returns the total number of yellow cards given during this tournament (so far)
     * 
     * @return
     *     returns int
     */
    @WebMethod(operationName = "YellowCardsTotal")
    @WebResult(name = "YellowCardsTotalResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "YellowCardsTotal", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.YellowCardsTotal")
    @ResponseWrapper(localName = "YellowCardsTotalResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.YellowCardsTotalResponse")
    public int yellowCardsTotal();

    /**
     * Returns the total number of red cards given during this tournament (so far)
     * 
     * @return
     *     returns int
     */
    @WebMethod(operationName = "RedCardsTotal")
    @WebResult(name = "RedCardsTotalResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "RedCardsTotal", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.RedCardsTotal")
    @ResponseWrapper(localName = "RedCardsTotalResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.RedCardsTotalResponse")
    public int redCardsTotal();

    /**
     * Returns a combination of the total number of yellow and red cards given during this tournament (so far)
     * 
     * @return
     *     returns worldcup.TCards
     */
    @WebMethod(operationName = "YellowAndRedCardsTotal")
    @WebResult(name = "YellowAndRedCardsTotalResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "YellowAndRedCardsTotal", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.YellowAndRedCardsTotal")
    @ResponseWrapper(localName = "YellowAndRedCardsTotalResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.YellowAndRedCardsTotalResponse")
    public TCards yellowAndRedCardsTotal();

    /**
     * Returns an array with the status codes for the games
     * 
     * @return
     *     returns worldcup.ArrayOftGameResultCode
     */
    @WebMethod(operationName = "GameResultCodes")
    @WebResult(name = "GameResultCodesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GameResultCodes", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GameResultCodes")
    @ResponseWrapper(localName = "GameResultCodesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.GameResultCodesResponse")
    public ArrayOftGameResultCode gameResultCodes();

    /**
     * Returns an array with the names of all the coaches and the team information he/she is coaching
     * 
     * @return
     *     returns worldcup.ArrayOftCoaches
     */
    @WebMethod(operationName = "Coaches")
    @WebResult(name = "CoachesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Coaches", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.Coaches")
    @ResponseWrapper(localName = "CoachesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.CoachesResponse")
    public ArrayOftCoaches coaches();

    /**
     * Returns a number on how many times the given team competed at a worldcup football
     * 
     * @param sTeamName
     * @return
     *     returns int
     */
    @WebMethod(operationName = "PlayedAtWorldCup")
    @WebResult(name = "PlayedAtWorldCupResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "PlayedAtWorldCup", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.PlayedAtWorldCup")
    @ResponseWrapper(localName = "PlayedAtWorldCupResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.PlayedAtWorldCupResponse")
    public int playedAtWorldCup(
        @WebParam(name = "sTeamName", targetNamespace = "http://footballpool.dataaccess.eu")
        String sTeamName);

    /**
     * Returns an array with the team of this competition with the number of times competed and the number of times won
     * 
     * @return
     *     returns worldcup.ArrayOftTeamCompete
     */
    @WebMethod(operationName = "TeamsCompeteList")
    @WebResult(name = "TeamsCompeteListResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TeamsCompeteList", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TeamsCompeteList")
    @ResponseWrapper(localName = "TeamsCompeteListResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TeamsCompeteListResponse")
    public ArrayOftTeamCompete teamsCompeteList();

    /**
     * Returns information of the next game
     * 
     * @return
     *     returns worldcup.TGameInfo
     */
    @WebMethod(operationName = "NextGame")
    @WebResult(name = "NextGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "NextGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.NextGame")
    @ResponseWrapper(localName = "NextGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.NextGameResponse")
    public TGameInfo nextGame();

    /**
     * Returns the date of the first game
     * 
     * @return
     *     returns javax.xml.datatype.XMLGregorianCalendar
     */
    @WebMethod(operationName = "DateOfFirstGame")
    @WebResult(name = "DateOfFirstGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "DateOfFirstGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.DateOfFirstGame")
    @ResponseWrapper(localName = "DateOfFirstGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.DateOfFirstGameResponse")
    public XMLGregorianCalendar dateOfFirstGame();

    /**
     * Returns the date of the last game (usually the finals...)
     * 
     * @return
     *     returns javax.xml.datatype.XMLGregorianCalendar
     */
    @WebMethod(operationName = "DateOfLastGame")
    @WebResult(name = "DateOfLastGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "DateOfLastGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.DateOfLastGame")
    @ResponseWrapper(localName = "DateOfLastGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.DateOfLastGameResponse")
    public XMLGregorianCalendar dateOfLastGame();

    /**
     * Returns the date of the last group game will be played. After this date the quarter finals are played.
     * 
     * @return
     *     returns javax.xml.datatype.XMLGregorianCalendar
     */
    @WebMethod(operationName = "DateLastGroupGame")
    @WebResult(name = "DateLastGroupGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "DateLastGroupGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.DateLastGroupGame")
    @ResponseWrapper(localName = "DateLastGroupGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.DateLastGroupGameResponse")
    public XMLGregorianCalendar dateLastGroupGame();

    /**
     * Returns information (dates and number of games) about the tournament
     * 
     * @return
     *     returns worldcup.TTournamentInfo
     */
    @WebMethod(operationName = "TournamentInfo")
    @WebResult(name = "TournamentInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TournamentInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TournamentInfo")
    @ResponseWrapper(localName = "TournamentInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.TournamentInfoResponse")
    public TTournamentInfo tournamentInfo();

    /**
     * Returns the number of games in the tournament
     * 
     * @return
     *     returns int
     */
    @WebMethod(operationName = "NumberOfGames")
    @WebResult(name = "NumberOfGamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "NumberOfGames", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.NumberOfGames")
    @ResponseWrapper(localName = "NumberOfGamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.NumberOfGamesResponse")
    public int numberOfGames();

    /**
     * Returns an array with the number of people signed up at that day
     * 
     * @return
     *     returns worldcup.ArrayOftSignupCount
     */
    @WebMethod(operationName = "SignupsPerDate")
    @WebResult(name = "SignupsPerDateResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "SignupsPerDate", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.SignupsPerDate")
    @ResponseWrapper(localName = "SignupsPerDateResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "worldcup.SignupsPerDateResponse")
    public ArrayOftSignupCount signupsPerDate();

}
