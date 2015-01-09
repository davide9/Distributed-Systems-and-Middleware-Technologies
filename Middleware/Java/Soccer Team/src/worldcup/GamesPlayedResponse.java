
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
 *         &lt;element name="GamesPlayedResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "gamesPlayedResult"
})
@XmlRootElement(name = "GamesPlayedResponse")
public class GamesPlayedResponse {

    @XmlElement(name = "GamesPlayedResult")
    protected int gamesPlayedResult;

    /**
     * Gets the value of the gamesPlayedResult property.
     * 
     */
    public int getGamesPlayedResult() {
        return gamesPlayedResult;
    }

    /**
     * Sets the value of the gamesPlayedResult property.
     * 
     */
    public void setGamesPlayedResult(int value) {
        this.gamesPlayedResult = value;
    }

}
