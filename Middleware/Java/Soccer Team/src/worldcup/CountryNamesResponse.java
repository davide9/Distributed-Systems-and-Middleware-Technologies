
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountryNamesResult" type="{http://footballpool.dataaccess.eu}ArrayOftCountryInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "countryNamesResult"
})
@XmlRootElement(name = "CountryNamesResponse")
public class CountryNamesResponse {

    @XmlElement(name = "CountryNamesResult", required = true)
    protected ArrayOftCountryInfo countryNamesResult;

    /**
     * Gets the value of the countryNamesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountryInfo }
     *     
     */
    public ArrayOftCountryInfo getCountryNamesResult() {
        return countryNamesResult;
    }

    /**
     * Sets the value of the countryNamesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountryInfo }
     *     
     */
    public void setCountryNamesResult(ArrayOftCountryInfo value) {
        this.countryNamesResult = value;
    }

}
