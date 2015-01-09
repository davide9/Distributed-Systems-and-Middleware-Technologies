
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
 *         &lt;element name="AllForwardsResult" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
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
    "allForwardsResult"
})
@XmlRootElement(name = "AllForwardsResponse")
public class AllForwardsResponse {

    @XmlElement(name = "AllForwardsResult", required = true)
    protected ArrayOfString allForwardsResult;

    /**
     * Gets the value of the allForwardsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAllForwardsResult() {
        return allForwardsResult;
    }

    /**
     * Sets the value of the allForwardsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAllForwardsResult(ArrayOfString value) {
        this.allForwardsResult = value;
    }

}
