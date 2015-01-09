
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tCardInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCardInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iMinute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sGameTeam1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sPlayerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bYellowCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bRedCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sGameTeam1Flag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam1FlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam2Flag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam2FlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sPlayerFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sPlayerFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCardInfo", propOrder = {
    "dGame",
    "iMinute",
    "sGameTeam1",
    "sGameTeam2",
    "sPlayerName",
    "bYellowCard",
    "bRedCard",
    "sGameTeam1Flag",
    "sGameTeam1FlagLarge",
    "sGameTeam2Flag",
    "sGameTeam2FlagLarge",
    "sPlayerFlag",
    "sPlayerFlagLarge"
})
public class TCardInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dGame;
    protected int iMinute;
    @XmlElement(required = true)
    protected String sGameTeam1;
    @XmlElement(required = true)
    protected String sGameTeam2;
    @XmlElement(required = true)
    protected String sPlayerName;
    protected boolean bYellowCard;
    protected boolean bRedCard;
    @XmlElement(required = true)
    protected String sGameTeam1Flag;
    @XmlElement(required = true)
    protected String sGameTeam1FlagLarge;
    @XmlElement(required = true)
    protected String sGameTeam2Flag;
    @XmlElement(required = true)
    protected String sGameTeam2FlagLarge;
    @XmlElement(required = true)
    protected String sPlayerFlag;
    @XmlElement(required = true)
    protected String sPlayerFlagLarge;

    /**
     * Gets the value of the dGame property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDGame() {
        return dGame;
    }

    /**
     * Sets the value of the dGame property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDGame(XMLGregorianCalendar value) {
        this.dGame = value;
    }

    /**
     * Gets the value of the iMinute property.
     * 
     */
    public int getIMinute() {
        return iMinute;
    }

    /**
     * Sets the value of the iMinute property.
     * 
     */
    public void setIMinute(int value) {
        this.iMinute = value;
    }

    /**
     * Gets the value of the sGameTeam1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam1() {
        return sGameTeam1;
    }

    /**
     * Sets the value of the sGameTeam1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam1(String value) {
        this.sGameTeam1 = value;
    }

    /**
     * Gets the value of the sGameTeam2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam2() {
        return sGameTeam2;
    }

    /**
     * Sets the value of the sGameTeam2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam2(String value) {
        this.sGameTeam2 = value;
    }

    /**
     * Gets the value of the sPlayerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPlayerName() {
        return sPlayerName;
    }

    /**
     * Sets the value of the sPlayerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPlayerName(String value) {
        this.sPlayerName = value;
    }

    /**
     * Gets the value of the bYellowCard property.
     * 
     */
    public boolean isBYellowCard() {
        return bYellowCard;
    }

    /**
     * Sets the value of the bYellowCard property.
     * 
     */
    public void setBYellowCard(boolean value) {
        this.bYellowCard = value;
    }

    /**
     * Gets the value of the bRedCard property.
     * 
     */
    public boolean isBRedCard() {
        return bRedCard;
    }

    /**
     * Sets the value of the bRedCard property.
     * 
     */
    public void setBRedCard(boolean value) {
        this.bRedCard = value;
    }

    /**
     * Gets the value of the sGameTeam1Flag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam1Flag() {
        return sGameTeam1Flag;
    }

    /**
     * Sets the value of the sGameTeam1Flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam1Flag(String value) {
        this.sGameTeam1Flag = value;
    }

    /**
     * Gets the value of the sGameTeam1FlagLarge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam1FlagLarge() {
        return sGameTeam1FlagLarge;
    }

    /**
     * Sets the value of the sGameTeam1FlagLarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam1FlagLarge(String value) {
        this.sGameTeam1FlagLarge = value;
    }

    /**
     * Gets the value of the sGameTeam2Flag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam2Flag() {
        return sGameTeam2Flag;
    }

    /**
     * Sets the value of the sGameTeam2Flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam2Flag(String value) {
        this.sGameTeam2Flag = value;
    }

    /**
     * Gets the value of the sGameTeam2FlagLarge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam2FlagLarge() {
        return sGameTeam2FlagLarge;
    }

    /**
     * Sets the value of the sGameTeam2FlagLarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam2FlagLarge(String value) {
        this.sGameTeam2FlagLarge = value;
    }

    /**
     * Gets the value of the sPlayerFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPlayerFlag() {
        return sPlayerFlag;
    }

    /**
     * Sets the value of the sPlayerFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPlayerFlag(String value) {
        this.sPlayerFlag = value;
    }

    /**
     * Gets the value of the sPlayerFlagLarge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPlayerFlagLarge() {
        return sPlayerFlagLarge;
    }

    /**
     * Sets the value of the sPlayerFlagLarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPlayerFlagLarge(String value) {
        this.sPlayerFlagLarge = value;
    }

}
