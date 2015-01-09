
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tTopSelectedGoalScorer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTopSelectedGoalScorer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iSelected" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Countries" type="{http://footballpool.dataaccess.eu}ArrayOftCountrySelectedTopScorer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTopSelectedGoalScorer", propOrder = {
    "sName",
    "iSelected",
    "countries"
})
public class TTopSelectedGoalScorer {

    @XmlElement(required = true)
    protected String sName;
    protected int iSelected;
    @XmlElement(name = "Countries", required = true)
    protected ArrayOftCountrySelectedTopScorer countries;

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
     * Gets the value of the iSelected property.
     * 
     */
    public int getISelected() {
        return iSelected;
    }

    /**
     * Sets the value of the iSelected property.
     * 
     */
    public void setISelected(int value) {
        this.iSelected = value;
    }

    /**
     * Gets the value of the countries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountrySelectedTopScorer }
     *     
     */
    public ArrayOftCountrySelectedTopScorer getCountries() {
        return countries;
    }

    /**
     * Sets the value of the countries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountrySelectedTopScorer }
     *     
     */
    public void setCountries(ArrayOftCountrySelectedTopScorer value) {
        this.countries = value;
    }

}
