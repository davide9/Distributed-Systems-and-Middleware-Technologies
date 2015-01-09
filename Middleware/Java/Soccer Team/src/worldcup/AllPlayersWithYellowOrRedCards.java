
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="bSortedByName" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bSortedByYellowCards" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bSortedByRedCards" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "bSortedByName",
    "bSortedByYellowCards",
    "bSortedByRedCards"
})
@XmlRootElement(name = "AllPlayersWithYellowOrRedCards")
public class AllPlayersWithYellowOrRedCards {

    protected boolean bSortedByName;
    protected boolean bSortedByYellowCards;
    protected boolean bSortedByRedCards;

    /**
     * Gets the value of the bSortedByName property.
     * 
     */
    public boolean isBSortedByName() {
        return bSortedByName;
    }

    /**
     * Sets the value of the bSortedByName property.
     * 
     */
    public void setBSortedByName(boolean value) {
        this.bSortedByName = value;
    }

    /**
     * Gets the value of the bSortedByYellowCards property.
     * 
     */
    public boolean isBSortedByYellowCards() {
        return bSortedByYellowCards;
    }

    /**
     * Sets the value of the bSortedByYellowCards property.
     * 
     */
    public void setBSortedByYellowCards(boolean value) {
        this.bSortedByYellowCards = value;
    }

    /**
     * Gets the value of the bSortedByRedCards property.
     * 
     */
    public boolean isBSortedByRedCards() {
        return bSortedByRedCards;
    }

    /**
     * Sets the value of the bSortedByRedCards property.
     * 
     */
    public void setBSortedByRedCards(boolean value) {
        this.bSortedByRedCards = value;
    }

}
