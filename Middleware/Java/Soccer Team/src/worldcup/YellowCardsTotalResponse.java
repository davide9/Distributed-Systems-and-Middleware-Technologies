
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
 *         &lt;element name="YellowCardsTotalResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "yellowCardsTotalResult"
})
@XmlRootElement(name = "YellowCardsTotalResponse")
public class YellowCardsTotalResponse {

    @XmlElement(name = "YellowCardsTotalResult")
    protected int yellowCardsTotalResult;

    /**
     * Gets the value of the yellowCardsTotalResult property.
     * 
     */
    public int getYellowCardsTotalResult() {
        return yellowCardsTotalResult;
    }

    /**
     * Sets the value of the yellowCardsTotalResult property.
     * 
     */
    public void setYellowCardsTotalResult(int value) {
        this.yellowCardsTotalResult = value;
    }

}
