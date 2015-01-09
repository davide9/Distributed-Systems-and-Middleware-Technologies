
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tFullTeamInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tFullTeamInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCoach" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iCompeted" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sGoalKeepers" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sDefenders" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sMidFields" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sForwards" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFullTeamInfo", propOrder = {
    "sName",
    "sCountryFlag",
    "sCountryFlagLarge",
    "sCoach",
    "iCompeted",
    "sGoalKeepers",
    "sDefenders",
    "sMidFields",
    "sForwards"
})
public class TFullTeamInfo {

    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sCountryFlag;
    @XmlElement(required = true)
    protected String sCountryFlagLarge;
    @XmlElement(required = true)
    protected String sCoach;
    protected int iCompeted;
    @XmlElement(required = true)
    protected ArrayOfString sGoalKeepers;
    @XmlElement(required = true)
    protected ArrayOfString sDefenders;
    @XmlElement(required = true)
    protected ArrayOfString sMidFields;
    @XmlElement(required = true)
    protected ArrayOfString sForwards;

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

    /**
     * Gets the value of the sCoach property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCoach() {
        return sCoach;
    }

    /**
     * Sets the value of the sCoach property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCoach(String value) {
        this.sCoach = value;
    }

    /**
     * Gets the value of the iCompeted property.
     * 
     */
    public int getICompeted() {
        return iCompeted;
    }

    /**
     * Sets the value of the iCompeted property.
     * 
     */
    public void setICompeted(int value) {
        this.iCompeted = value;
    }

    /**
     * Gets the value of the sGoalKeepers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSGoalKeepers() {
        return sGoalKeepers;
    }

    /**
     * Sets the value of the sGoalKeepers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSGoalKeepers(ArrayOfString value) {
        this.sGoalKeepers = value;
    }

    /**
     * Gets the value of the sDefenders property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSDefenders() {
        return sDefenders;
    }

    /**
     * Sets the value of the sDefenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSDefenders(ArrayOfString value) {
        this.sDefenders = value;
    }

    /**
     * Gets the value of the sMidFields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSMidFields() {
        return sMidFields;
    }

    /**
     * Sets the value of the sMidFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSMidFields(ArrayOfString value) {
        this.sMidFields = value;
    }

    /**
     * Gets the value of the sForwards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSForwards() {
        return sForwards;
    }

    /**
     * Sets the value of the sForwards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSForwards(ArrayOfString value) {
        this.sForwards = value;
    }

}
