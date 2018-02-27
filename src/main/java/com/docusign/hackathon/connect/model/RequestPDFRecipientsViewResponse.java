
package com.docusign.hackathon.connect.model;

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
 *         &lt;element name="RequestPDFRecipientsViewResult" type="{http://www.docusign.net/API/3.0}EnvelopePDF" minOccurs="0"/>
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
    "requestPDFRecipientsViewResult"
})
@XmlRootElement(name = "RequestPDFRecipientsViewResponse")
public class RequestPDFRecipientsViewResponse {

    @XmlElement(name = "RequestPDFRecipientsViewResult")
    protected EnvelopePDF requestPDFRecipientsViewResult;

    /**
     * Gets the value of the requestPDFRecipientsViewResult property.
     * 
     * @return
     *     possible object is
     *     {@link EnvelopePDF }
     *     
     */
    public EnvelopePDF getRequestPDFRecipientsViewResult() {
        return requestPDFRecipientsViewResult;
    }

    /**
     * Sets the value of the requestPDFRecipientsViewResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvelopePDF }
     *     
     */
    public void setRequestPDFRecipientsViewResult(EnvelopePDF value) {
        this.requestPDFRecipientsViewResult = value;
    }

}
