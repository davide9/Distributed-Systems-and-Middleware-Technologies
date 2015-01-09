
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
 *         &lt;element name="GroupsResult" type="{http://footballpool.dataaccess.eu}ArrayOftGroupInfo"/>
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
    "groupsResult"
})
@XmlRootElement(name = "GroupsResponse")
public class GroupsResponse {

    @XmlElement(name = "GroupsResult", required = true)
    protected ArrayOftGroupInfo groupsResult;

    /**
     * Gets the value of the groupsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftGroupInfo }
     *     
     */
    public ArrayOftGroupInfo getGroupsResult() {
        return groupsResult;
    }

    /**
     * Sets the value of the groupsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftGroupInfo }
     *     
     */
    public void setGroupsResult(ArrayOftGroupInfo value) {
        this.groupsResult = value;
    }

}
