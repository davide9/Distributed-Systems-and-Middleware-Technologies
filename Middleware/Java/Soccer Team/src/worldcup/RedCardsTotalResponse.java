
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
 *         &lt;element name="RedCardsTotalResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "redCardsTotalResult"
})
@XmlRootElement(name = "RedCardsTotalResponse")
public class RedCardsTotalResponse {

    @XmlElement(name = "RedCardsTotalResult")
    protected int redCardsTotalResult;

    /**
     * Gets the value of the redCardsTotalResult property.
     * 
     */
    public int getRedCardsTotalResult() {
        return redCardsTotalResult;
    }

    /**
     * Sets the value of the redCardsTotalResult property.
     * 
     */
    public void setRedCardsTotalResult(int value) {
        this.redCardsTotalResult = value;
    }

}
