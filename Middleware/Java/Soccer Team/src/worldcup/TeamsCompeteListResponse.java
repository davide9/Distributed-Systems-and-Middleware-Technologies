
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
 *         &lt;element name="TeamsCompeteListResult" type="{http://footballpool.dataaccess.eu}ArrayOftTeamCompete"/>
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
    "teamsCompeteListResult"
})
@XmlRootElement(name = "TeamsCompeteListResponse")
public class TeamsCompeteListResponse {

    @XmlElement(name = "TeamsCompeteListResult", required = true)
    protected ArrayOftTeamCompete teamsCompeteListResult;

    /**
     * Gets the value of the teamsCompeteListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTeamCompete }
     *     
     */
    public ArrayOftTeamCompete getTeamsCompeteListResult() {
        return teamsCompeteListResult;
    }

    /**
     * Sets the value of the teamsCompeteListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTeamCompete }
     *     
     */
    public void setTeamsCompeteListResult(ArrayOftTeamCompete value) {
        this.teamsCompeteListResult = value;
    }

}
