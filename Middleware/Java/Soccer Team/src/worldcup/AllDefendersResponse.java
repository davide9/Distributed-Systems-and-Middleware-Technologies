
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
 *         &lt;element name="AllDefendersResult" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
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
    "allDefendersResult"
})
@XmlRootElement(name = "AllDefendersResponse")
public class AllDefendersResponse {

    @XmlElement(name = "AllDefendersResult", required = true)
    protected ArrayOfString allDefendersResult;

    /**
     * Gets the value of the allDefendersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAllDefendersResult() {
        return allDefendersResult;
    }

    /**
     * Sets the value of the allDefendersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAllDefendersResult(ArrayOfString value) {
        this.allDefendersResult = value;
    }

}
