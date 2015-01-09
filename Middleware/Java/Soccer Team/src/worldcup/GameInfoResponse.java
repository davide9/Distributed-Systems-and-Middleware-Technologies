
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
 *         &lt;element name="GameInfoResult" type="{http://footballpool.dataaccess.eu}tGameInfo"/>
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
    "gameInfoResult"
})
@XmlRootElement(name = "GameInfoResponse")
public class GameInfoResponse {

    @XmlElement(name = "GameInfoResult", required = true)
    protected TGameInfo gameInfoResult;

    /**
     * Gets the value of the gameInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link TGameInfo }
     *     
     */
    public TGameInfo getGameInfoResult() {
        return gameInfoResult;
    }

    /**
     * Sets the value of the gameInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGameInfo }
     *     
     */
    public void setGameInfoResult(TGameInfo value) {
        this.gameInfoResult = value;
    }

}
