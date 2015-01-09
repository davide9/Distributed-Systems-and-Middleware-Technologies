
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tGameInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tGameInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dPlayDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="tPlayTime" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="iUTCOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StadiumInfo" type="{http://footballpool.dataaccess.eu}tStadiumInfo"/>
 *         &lt;element name="Team1" type="{http://footballpool.dataaccess.eu}tTeamInfo"/>
 *         &lt;element name="Team2" type="{http://footballpool.dataaccess.eu}tTeamInfo"/>
 *         &lt;element name="sResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sScore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iYellowCards" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iRedCards" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Cards" type="{http://footballpool.dataaccess.eu}ArrayOftGameCard"/>
 *         &lt;element name="Goals" type="{http://footballpool.dataaccess.eu}ArrayOftGoal"/>
 *         &lt;element name="bChampion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGameInfo", propOrder = {
    "iId",
    "sDescription",
    "dPlayDate",
    "tPlayTime",
    "iutcOffset",
    "stadiumInfo",
    "team1",
    "team2",
    "sResult",
    "sScore",
    "iYellowCards",
    "iRedCards",
    "cards",
    "goals",
    "bChampion"
})
public class TGameInfo {

    protected int iId;
    @XmlElement(required = true)
    protected String sDescription;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dPlayDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar tPlayTime;
    @XmlElement(name = "iUTCOffset")
    protected int iutcOffset;
    @XmlElement(name = "StadiumInfo", required = true)
    protected TStadiumInfo stadiumInfo;
    @XmlElement(name = "Team1", required = true)
    protected TTeamInfo team1;
    @XmlElement(name = "Team2", required = true)
    protected TTeamInfo team2;
    @XmlElement(required = true)
    protected String sResult;
    @XmlElement(required = true)
    protected String sScore;
    protected int iYellowCards;
    protected int iRedCards;
    @XmlElement(name = "Cards", required = true)
    protected ArrayOftGameCard cards;
    @XmlElement(name = "Goals", required = true)
    protected ArrayOftGoal goals;
    protected boolean bChampion;

    /**
     * Gets the value of the iId property.
     * 
     */
    public int getIId() {
        return iId;
    }

    /**
     * Sets the value of the iId property.
     * 
     */
    public void setIId(int value) {
        this.iId = value;
    }

    /**
     * Gets the value of the sDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescription() {
        return sDescription;
    }

    /**
     * Sets the value of the sDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescription(String value) {
        this.sDescription = value;
    }

    /**
     * Gets the value of the dPlayDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDPlayDate() {
        return dPlayDate;
    }

    /**
     * Sets the value of the dPlayDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDPlayDate(XMLGregorianCalendar value) {
        this.dPlayDate = value;
    }

    /**
     * Gets the value of the tPlayTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTPlayTime() {
        return tPlayTime;
    }

    /**
     * Sets the value of the tPlayTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTPlayTime(XMLGregorianCalendar value) {
        this.tPlayTime = value;
    }

    /**
     * Gets the value of the iutcOffset property.
     * 
     */
    public int getIUTCOffset() {
        return iutcOffset;
    }

    /**
     * Sets the value of the iutcOffset property.
     * 
     */
    public void setIUTCOffset(int value) {
        this.iutcOffset = value;
    }

    /**
     * Gets the value of the stadiumInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TStadiumInfo }
     *     
     */
    public TStadiumInfo getStadiumInfo() {
        return stadiumInfo;
    }

    /**
     * Sets the value of the stadiumInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TStadiumInfo }
     *     
     */
    public void setStadiumInfo(TStadiumInfo value) {
        this.stadiumInfo = value;
    }

    /**
     * Gets the value of the team1 property.
     * 
     * @return
     *     possible object is
     *     {@link TTeamInfo }
     *     
     */
    public TTeamInfo getTeam1() {
        return team1;
    }

    /**
     * Sets the value of the team1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTeamInfo }
     *     
     */
    public void setTeam1(TTeamInfo value) {
        this.team1 = value;
    }

    /**
     * Gets the value of the team2 property.
     * 
     * @return
     *     possible object is
     *     {@link TTeamInfo }
     *     
     */
    public TTeamInfo getTeam2() {
        return team2;
    }

    /**
     * Sets the value of the team2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTeamInfo }
     *     
     */
    public void setTeam2(TTeamInfo value) {
        this.team2 = value;
    }

    /**
     * Gets the value of the sResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSResult() {
        return sResult;
    }

    /**
     * Sets the value of the sResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSResult(String value) {
        this.sResult = value;
    }

    /**
     * Gets the value of the sScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSScore() {
        return sScore;
    }

    /**
     * Sets the value of the sScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSScore(String value) {
        this.sScore = value;
    }

    /**
     * Gets the value of the iYellowCards property.
     * 
     */
    public int getIYellowCards() {
        return iYellowCards;
    }

    /**
     * Sets the value of the iYellowCards property.
     * 
     */
    public void setIYellowCards(int value) {
        this.iYellowCards = value;
    }

    /**
     * Gets the value of the iRedCards property.
     * 
     */
    public int getIRedCards() {
        return iRedCards;
    }

    /**
     * Sets the value of the iRedCards property.
     * 
     */
    public void setIRedCards(int value) {
        this.iRedCards = value;
    }

    /**
     * Gets the value of the cards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftGameCard }
     *     
     */
    public ArrayOftGameCard getCards() {
        return cards;
    }

    /**
     * Sets the value of the cards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftGameCard }
     *     
     */
    public void setCards(ArrayOftGameCard value) {
        this.cards = value;
    }

    /**
     * Gets the value of the goals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftGoal }
     *     
     */
    public ArrayOftGoal getGoals() {
        return goals;
    }

    /**
     * Sets the value of the goals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftGoal }
     *     
     */
    public void setGoals(ArrayOftGoal value) {
        this.goals = value;
    }

    /**
     * Gets the value of the bChampion property.
     * 
     */
    public boolean isBChampion() {
        return bChampion;
    }

    /**
     * Sets the value of the bChampion property.
     * 
     */
    public void setBChampion(boolean value) {
        this.bChampion = value;
    }

}
