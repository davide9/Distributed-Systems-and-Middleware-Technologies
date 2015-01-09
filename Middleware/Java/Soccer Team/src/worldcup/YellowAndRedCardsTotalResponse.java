
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
 *         &lt;element name="YellowAndRedCardsTotalResult" type="{http://footballpool.dataaccess.eu}tCards"/>
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
    "yellowAndRedCardsTotalResult"
})
@XmlRootElement(name = "YellowAndRedCardsTotalResponse")
public class YellowAndRedCardsTotalResponse {

    @XmlElement(name = "YellowAndRedCardsTotalResult", required = true)
    protected TCards yellowAndRedCardsTotalResult;

    /**
     * Gets the value of the yellowAndRedCardsTotalResult property.
     * 
     * @return
     *     possible object is
     *     {@link TCards }
     *     
     */
    public TCards getYellowAndRedCardsTotalResult() {
        return yellowAndRedCardsTotalResult;
    }

    /**
     * Sets the value of the yellowAndRedCardsTotalResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCards }
     *     
     */
    public void setYellowAndRedCardsTotalResult(TCards value) {
        this.yellowAndRedCardsTotalResult = value;
    }

}
