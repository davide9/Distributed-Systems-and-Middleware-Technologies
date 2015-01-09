
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
 *         &lt;element name="StadiumURLResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "stadiumURLResult"
})
@XmlRootElement(name = "StadiumURLResponse")
public class StadiumURLResponse {

    @XmlElement(name = "StadiumURLResult", required = true)
    protected String stadiumURLResult;

    /**
     * Gets the value of the stadiumURLResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStadiumURLResult() {
        return stadiumURLResult;
    }

    /**
     * Sets the value of the stadiumURLResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStadiumURLResult(String value) {
        this.stadiumURLResult = value;
    }

}
