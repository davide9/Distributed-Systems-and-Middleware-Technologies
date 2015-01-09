
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
 *         &lt;element name="TopSelectedGoalScorersResult" type="{http://footballpool.dataaccess.eu}ArrayOftTopSelectedGoalScorer"/>
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
    "topSelectedGoalScorersResult"
})
@XmlRootElement(name = "TopSelectedGoalScorersResponse")
public class TopSelectedGoalScorersResponse {

    @XmlElement(name = "TopSelectedGoalScorersResult", required = true)
    protected ArrayOftTopSelectedGoalScorer topSelectedGoalScorersResult;

    /**
     * Gets the value of the topSelectedGoalScorersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTopSelectedGoalScorer }
     *     
     */
    public ArrayOftTopSelectedGoalScorer getTopSelectedGoalScorersResult() {
        return topSelectedGoalScorersResult;
    }

    /**
     * Sets the value of the topSelectedGoalScorersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTopSelectedGoalScorer }
     *     
     */
    public void setTopSelectedGoalScorersResult(ArrayOftTopSelectedGoalScorer value) {
        this.topSelectedGoalScorersResult = value;
    }

}
