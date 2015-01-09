
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
 *         &lt;element name="FullTeamInfoResult" type="{http://footballpool.dataaccess.eu}tFullTeamInfo"/>
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
    "fullTeamInfoResult"
})
@XmlRootElement(name = "FullTeamInfoResponse")
public class FullTeamInfoResponse {

    @XmlElement(name = "FullTeamInfoResult", required = true)
    protected TFullTeamInfo fullTeamInfoResult;

    /**
     * Gets the value of the fullTeamInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link TFullTeamInfo }
     *     
     */
    public TFullTeamInfo getFullTeamInfoResult() {
        return fullTeamInfoResult;
    }

    /**
     * Sets the value of the fullTeamInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFullTeamInfo }
     *     
     */
    public void setFullTeamInfoResult(TFullTeamInfo value) {
        this.fullTeamInfoResult = value;
    }

}
