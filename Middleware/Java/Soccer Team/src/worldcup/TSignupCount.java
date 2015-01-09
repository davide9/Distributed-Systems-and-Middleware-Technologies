
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tSignupCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSignupCount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dSignup" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iAverage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSignupCount", propOrder = {
    "dSignup",
    "iCount",
    "iTotal",
    "iAverage"
})
public class TSignupCount {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dSignup;
    protected int iCount;
    protected int iTotal;
    protected int iAverage;

    /**
     * Gets the value of the dSignup property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDSignup() {
        return dSignup;
    }

    /**
     * Sets the value of the dSignup property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDSignup(XMLGregorianCalendar value) {
        this.dSignup = value;
    }

    /**
     * Gets the value of the iCount property.
     * 
     */
    public int getICount() {
        return iCount;
    }

    /**
     * Sets the value of the iCount property.
     * 
     */
    public void setICount(int value) {
        this.iCount = value;
    }

    /**
     * Gets the value of the iTotal property.
     * 
     */
    public int getITotal() {
        return iTotal;
    }

    /**
     * Sets the value of the iTotal property.
     * 
     */
    public void setITotal(int value) {
        this.iTotal = value;
    }

    /**
     * Gets the value of the iAverage property.
     * 
     */
    public int getIAverage() {
        return iAverage;
    }

    /**
     * Sets the value of the iAverage property.
     * 
     */
    public void setIAverage(int value) {
        this.iAverage = value;
    }

}
