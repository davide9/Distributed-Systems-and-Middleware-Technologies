
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tCountryInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCountryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sIsoCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iPersons" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCountryInfo", propOrder = {
    "iId",
    "sName",
    "sIsoCode",
    "iPersons"
})
public class TCountryInfo {

    protected int iId;
    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sIsoCode;
    protected int iPersons;

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
     * Gets the value of the sIsoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIsoCode() {
        return sIsoCode;
    }

    /**
     * Sets the value of the sIsoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIsoCode(String value) {
        this.sIsoCode = value;
    }

    /**
     * Gets the value of the iPersons property.
     * 
     */
    public int getIPersons() {
        return iPersons;
    }

    /**
     * Sets the value of the iPersons property.
     * 
     */
    public void setIPersons(int value) {
        this.iPersons = value;
    }

}
