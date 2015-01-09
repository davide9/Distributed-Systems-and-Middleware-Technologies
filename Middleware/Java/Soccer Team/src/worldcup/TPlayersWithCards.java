
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPlayersWithCards complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPlayersWithCards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iYellowCards" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iRedCards" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sTeamName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sTeamFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sTeamFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPlayersWithCards", propOrder = {
    "sName",
    "iYellowCards",
    "iRedCards",
    "sTeamName",
    "sTeamFlag",
    "sTeamFlagLarge"
})
public class TPlayersWithCards {

    @XmlElement(required = true)
    protected String sName;
    protected int iYellowCards;
    protected int iRedCards;
    @XmlElement(required = true)
    protected String sTeamName;
    @XmlElement(required = true)
    protected String sTeamFlag;
    @XmlElement(required = true)
    protected String sTeamFlagLarge;

    /**
     * Gets the value of the sName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSName() {
        return sName;
    }

    /**
     * Sets the value of the sName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSName(String value) {
        this.sName = value;
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
     * Gets the value of the sTeamName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamName() {
        return sTeamName;
    }

    /**
     * Sets the value of the sTeamName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamName(String value) {
        this.sTeamName = value;
    }

    /**
     * Gets the value of the sTeamFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamFlag() {
        return sTeamFlag;
    }

    /**
     * Sets the value of the sTeamFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamFlag(String value) {
        this.sTeamFlag = value;
    }

    /**
     * Gets the value of the sTeamFlagLarge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamFlagLarge() {
        return sTeamFlagLarge;
    }

    /**
     * Sets the value of the sTeamFlagLarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamFlagLarge(String value) {
        this.sTeamFlagLarge = value;
    }

}
