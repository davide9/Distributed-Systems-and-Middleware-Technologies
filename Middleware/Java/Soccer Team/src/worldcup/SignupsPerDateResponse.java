
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
 *         &lt;element name="SignupsPerDateResult" type="{http://footballpool.dataaccess.eu}ArrayOftSignupCount"/>
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
    "signupsPerDateResult"
})
@XmlRootElement(name = "SignupsPerDateResponse")
public class SignupsPerDateResponse {

    @XmlElement(name = "SignupsPerDateResult", required = true)
    protected ArrayOftSignupCount signupsPerDateResult;

    /**
     * Gets the value of the signupsPerDateResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftSignupCount }
     *     
     */
    public ArrayOftSignupCount getSignupsPerDateResult() {
        return signupsPerDateResult;
    }

    /**
     * Sets the value of the signupsPerDateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftSignupCount }
     *     
     */
    public void setSignupsPerDateResult(ArrayOftSignupCount value) {
        this.signupsPerDateResult = value;
    }

}
