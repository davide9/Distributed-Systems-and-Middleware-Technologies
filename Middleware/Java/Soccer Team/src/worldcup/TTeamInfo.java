
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tTeamInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTeamInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sWikipediaURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTeamInfo", propOrder = {
    "iId",
    "sName",
    "sCountryFlag",
    "sWikipediaURL",
    "sCountryFlagLarge"
})
public class TTeamInfo {

    protected int iId;
    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sCountryFlag;
    @XmlElement(required = true)
    protected String sWikipediaURL;
    @XmlElement(required = true)
    protected String sCountryFlagLarge;

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
     * Gets the value of the sCountryFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountryFlag() {
        return sCountryFlag;
    }

    /**
     * Sets the value of the sCountryFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountryFlag(String value) {
        this.sCountryFlag = value;
    }

    /**
     * Gets the value of the sWikipediaURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWikipediaURL() {
        return sWikipediaURL;
    }

    /**
     * Sets the value of the sWikipediaURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWikipediaURL(String value) {
        this.sWikipediaURL = value;
    }

    /**
     * Gets the value of the sCountryFlagLarge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountryFlagLarge() {
        return sCountryFlagLarge;
    }

    /**
     * Sets the value of the sCountryFlagLarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountryFlagLarge(String value) {
        this.sCountryFlagLarge = value;
    }

}
