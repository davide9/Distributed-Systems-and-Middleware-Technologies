
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
 *         &lt;element name="CoachesResult" type="{http://footballpool.dataaccess.eu}ArrayOftCoaches"/>
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
    "coachesResult"
})
@XmlRootElement(name = "CoachesResponse")
public class CoachesResponse {

    @XmlElement(name = "CoachesResult", required = true)
    protected ArrayOftCoaches coachesResult;

    /**
     * Gets the value of the coachesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCoaches }
     *     
     */
    public ArrayOftCoaches getCoachesResult() {
        return coachesResult;
    }

    /**
     * Sets the value of the coachesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCoaches }
     *     
     */
    public void setCoachesResult(ArrayOftCoaches value) {
        this.coachesResult = value;
    }

}
