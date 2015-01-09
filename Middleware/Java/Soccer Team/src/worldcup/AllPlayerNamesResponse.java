
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
 *         &lt;element name="AllPlayerNamesResult" type="{http://footballpool.dataaccess.eu}ArrayOftPlayerNames"/>
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
    "allPlayerNamesResult"
})
@XmlRootElement(name = "AllPlayerNamesResponse")
public class AllPlayerNamesResponse {

    @XmlElement(name = "AllPlayerNamesResult", required = true)
    protected ArrayOftPlayerNames allPlayerNamesResult;

    /**
     * Gets the value of the allPlayerNamesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftPlayerNames }
     *     
     */
    public ArrayOftPlayerNames getAllPlayerNamesResult() {
        return allPlayerNamesResult;
    }

    /**
     * Sets the value of the allPlayerNamesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftPlayerNames }
     *     
     */
    public void setAllPlayerNamesResult(ArrayOftPlayerNames value) {
        this.allPlayerNamesResult = value;
    }

}
