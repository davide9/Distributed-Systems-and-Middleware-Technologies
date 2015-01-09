
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tTournamentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTournamentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dFirstGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dLastGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dLastGroupDateGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iGames" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTournamentInfo", propOrder = {
    "dFirstGame",
    "dLastGame",
    "dLastGroupDateGame",
    "iGames"
})
public class TTournamentInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dFirstGame;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dLastGame;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dLastGroupDateGame;
    protected int iGames;

    /**
     * Gets the value of the dFirstGame property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFirstGame() {
        return dFirstGame;
    }

    /**
     * Sets the value of the dFirstGame property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFirstGame(XMLGregorianCalendar value) {
        this.dFirstGame = value;
    }

    /**
     * Gets the value of the dLastGame property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDLastGame() {
        return dLastGame;
    }

    /**
     * Sets the value of the dLastGame property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDLastGame(XMLGregorianCalendar value) {
        this.dLastGame = value;
    }

    /**
     * Gets the value of the dLastGroupDateGame property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDLastGroupDateGame() {
        return dLastGroupDateGame;
    }

    /**
     * Sets the value of the dLastGroupDateGame property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDLastGroupDateGame(XMLGregorianCalendar value) {
        this.dLastGroupDateGame = value;
    }

    /**
     * Gets the value of the iGames property.
     * 
     */
    public int getIGames() {
        return iGames;
    }

    /**
     * Sets the value of the iGames property.
     * 
     */
    public void setIGames(int value) {
        this.iGames = value;
    }

}
