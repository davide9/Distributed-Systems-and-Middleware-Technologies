
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tTeamCompete complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTeamCompete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iCompeted" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iWon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CoachInfo" type="{http://footballpool.dataaccess.eu}tCoaches"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTeamCompete", propOrder = {
    "iCompeted",
    "iWon",
    "coachInfo"
})
public class TTeamCompete {

    protected int iCompeted;
    protected int iWon;
    @XmlElement(name = "CoachInfo", required = true)
    protected TCoaches coachInfo;

    /**
     * Gets the value of the iCompeted property.
     * 
     */
    public int getICompeted() {
        return iCompeted;
    }

    /**
     * Sets the value of the iCompeted property.
     * 
     */
    public void setICompeted(int value) {
        this.iCompeted = value;
    }

    /**
     * Gets the value of the iWon property.
     * 
     */
    public int getIWon() {
        return iWon;
    }

    /**
     * Sets the value of the iWon property.
     * 
     */
    public void setIWon(int value) {
        this.iWon = value;
    }

    /**
     * Gets the value of the coachInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TCoaches }
     *     
     */
    public TCoaches getCoachInfo() {
        return coachInfo;
    }

    /**
     * Sets the value of the coachInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCoaches }
     *     
     */
    public void setCoachInfo(TCoaches value) {
        this.coachInfo = value;
    }

}
