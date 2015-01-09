
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tCards complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iYellow" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iRed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCards", propOrder = {
    "iYellow",
    "iRed"
})
public class TCards {

    protected int iYellow;
    protected int iRed;

    /**
     * Gets the value of the iYellow property.
     * 
     */
    public int getIYellow() {
        return iYellow;
    }

    /**
     * Sets the value of the iYellow property.
     * 
     */
    public void setIYellow(int value) {
        this.iYellow = value;
    }

    /**
     * Gets the value of the iRed property.
     * 
     */
    public int getIRed() {
        return iRed;
    }

    /**
     * Sets the value of the iRed property.
     * 
     */
    public void setIRed(int value) {
        this.iRed = value;
    }

}
