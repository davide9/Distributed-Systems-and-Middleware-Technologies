
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tTopGoalScorer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTopGoalScorer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iGoals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTopGoalScorer", propOrder = {
    "sName",
    "iGoals",
    "sCountry",
    "sFlag",
    "sFlagLarge"
})
public class TTopGoalScorer {

    @XmlElement(required = true)
    protected String sName;
    protected int iGoals;
    @XmlElement(required = true)
    protected String sCountry;
    @XmlElement(required = true)
    protected String sFlag;
    @XmlElement(required = true)
    protected String sFlagLarge;

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
     * Gets the value of the iGoals property.
     * 
     */
    public int getIGoals() {
        return iGoals;
    }

    /**
     * Sets the value of the iGoals property.
     * 
     */
    public void setIGoals(int value) {
        this.iGoals = value;
    }

    /**
     * Gets the value of the sCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountry() {
        return sCountry;
    }

    /**
     * Sets the value of the sCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountry(String value) {
        this.sCountry = value;
    }

    /**
     * Gets the value of the sFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFlag() {
        return sFlag;
    }

    /**
     * Sets the value of the sFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFlag(String value) {
        this.sFlag = value;
    }

    /**
     * Gets the value of the sFlagLarge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFlagLarge() {
        return sFlagLarge;
    }

    /**
     * Sets the value of the sFlagLarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFlagLarge(String value) {
        this.sFlagLarge = value;
    }

}
