
package worldcup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="DateOfFirstGameResult" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "dateOfFirstGameResult"
})
@XmlRootElement(name = "DateOfFirstGameResponse")
public class DateOfFirstGameResponse {

    @XmlElement(name = "DateOfFirstGameResult", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfFirstGameResult;

    /**
     * Gets the value of the dateOfFirstGameResult property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfFirstGameResult() {
        return dateOfFirstGameResult;
    }

    /**
     * Sets the value of the dateOfFirstGameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfFirstGameResult(XMLGregorianCalendar value) {
        this.dateOfFirstGameResult = value;
    }

}
