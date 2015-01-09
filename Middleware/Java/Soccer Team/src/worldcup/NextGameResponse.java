
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
 *         &lt;element name="NextGameResult" type="{http://footballpool.dataaccess.eu}tGameInfo"/>
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
    "nextGameResult"
})
@XmlRootElement(name = "NextGameResponse")
public class NextGameResponse {

    @XmlElement(name = "NextGameResult", required = true)
    protected TGameInfo nextGameResult;

    /**
     * Gets the value of the nextGameResult property.
     * 
     * @return
     *     possible object is
     *     {@link TGameInfo }
     *     
     */
    public TGameInfo getNextGameResult() {
        return nextGameResult;
    }

    /**
     * Sets the value of the nextGameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGameInfo }
     *     
     */
    public void setNextGameResult(TGameInfo value) {
        this.nextGameResult = value;
    }

}
