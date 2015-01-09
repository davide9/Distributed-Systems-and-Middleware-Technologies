
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
 *         &lt;element name="AllPlayersWithYellowOrRedCardsResult" type="{http://footballpool.dataaccess.eu}ArrayOftPlayersWithCards"/>
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
    "allPlayersWithYellowOrRedCardsResult"
})
@XmlRootElement(name = "AllPlayersWithYellowOrRedCardsResponse")
public class AllPlayersWithYellowOrRedCardsResponse {

    @XmlElement(name = "AllPlayersWithYellowOrRedCardsResult", required = true)
    protected ArrayOftPlayersWithCards allPlayersWithYellowOrRedCardsResult;

    /**
     * Gets the value of the allPlayersWithYellowOrRedCardsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftPlayersWithCards }
     *     
     */
    public ArrayOftPlayersWithCards getAllPlayersWithYellowOrRedCardsResult() {
        return allPlayersWithYellowOrRedCardsResult;
    }

    /**
     * Sets the value of the allPlayersWithYellowOrRedCardsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftPlayersWithCards }
     *     
     */
    public void setAllPlayersWithYellowOrRedCardsResult(ArrayOftPlayersWithCards value) {
        this.allPlayersWithYellowOrRedCardsResult = value;
    }

}
