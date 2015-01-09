
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
 *         &lt;element name="TeamsResult" type="{http://footballpool.dataaccess.eu}ArrayOftTeamInfo"/>
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
    "teamsResult"
})
@XmlRootElement(name = "TeamsResponse")
public class TeamsResponse {

    @XmlElement(name = "TeamsResult", required = true)
    protected ArrayOftTeamInfo teamsResult;

    /**
     * Gets the value of the teamsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTeamInfo }
     *     
     */
    public ArrayOftTeamInfo getTeamsResult() {
        return teamsResult;
    }

    /**
     * Sets the value of the teamsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTeamInfo }
     *     
     */
    public void setTeamsResult(ArrayOftTeamInfo value) {
        this.teamsResult = value;
    }

}
