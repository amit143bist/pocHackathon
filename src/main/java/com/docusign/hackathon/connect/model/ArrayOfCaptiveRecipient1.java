
package com.docusign.hackathon.connect.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCaptiveRecipient1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCaptiveRecipient1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BrandResultItem" type="{http://www.docusign.net/API/3.0}CaptiveRecipient" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCaptiveRecipient1", propOrder = {
    "brandResultItem"
})
public class ArrayOfCaptiveRecipient1 {

    @XmlElement(name = "BrandResultItem")
    protected List<CaptiveRecipient> brandResultItem;

    /**
     * Gets the value of the brandResultItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the brandResultItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBrandResultItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaptiveRecipient }
     * 
     * 
     */
    public List<CaptiveRecipient> getBrandResultItem() {
        if (brandResultItem == null) {
            brandResultItem = new ArrayList<CaptiveRecipient>();
        }
        return this.brandResultItem;
    }

}
