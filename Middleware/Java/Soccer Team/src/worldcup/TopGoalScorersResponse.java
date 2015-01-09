
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
 *         &lt;element name="TopGoalScorersResult" type="{http://footballpool.dataaccess.eu}ArrayOftTopGoalScorer"/>
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
    "topGoalScorersResult"
})
@XmlRootElement(name = "TopGoalScorersResponse")
public class TopGoalScorersResponse {

    @XmlElement(name = "TopGoalScorersResult", required = true)
    protected ArrayOftTopGoalScorer topGoalScorersResult;

    /**
     * Gets the value of the topGoalScorersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTopGoalScorer }
     *     
     */
    public ArrayOftTopGoalScorer getTopGoalScorersResult() {
        return topGoalScorersResult;
    }

    /**
     * Sets the value of the topGoalScorersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTopGoalScorer }
     *     
     */
    public void setTopGoalScorersResult(ArrayOftTopGoalScorer value) {
        this.topGoalScorersResult = value;
    }

}
