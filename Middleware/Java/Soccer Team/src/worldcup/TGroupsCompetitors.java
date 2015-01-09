
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tGroupsCompetitors complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tGroupsCompetitors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupInfo" type="{http://footballpool.dataaccess.eu}tGroupInfo"/>
 *         &lt;element name="TeamsInGroup" type="{http://footballpool.dataaccess.eu}ArrayOftTeamInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGroupsCompetitors", propOrder = {
    "groupInfo",
    "teamsInGroup"
})
public class TGroupsCompetitors {

    @XmlElement(name = "GroupInfo", required = true)
    protected TGroupInfo groupInfo;
    @XmlElement(name = "TeamsInGroup", required = true)
    protected ArrayOftTeamInfo teamsInGroup;

    /**
     * Gets the value of the groupInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TGroupInfo }
     *     
     */
    public TGroupInfo getGroupInfo() {
        return groupInfo;
    }

    /**
     * Sets the value of the groupInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGroupInfo }
     *     
     */
    public void setGroupInfo(TGroupInfo value) {
        this.groupInfo = value;
    }

    /**
     * Gets the value of the teamsInGroup property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTeamInfo }
     *     
     */
    public ArrayOftTeamInfo getTeamsInGroup() {
        return teamsInGroup;
    }

    /**
     * Sets the value of the teamsInGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTeamInfo }
     *     
     */
    public void setTeamsInGroup(ArrayOftTeamInfo value) {
        this.teamsInGroup = value;
    }

}
