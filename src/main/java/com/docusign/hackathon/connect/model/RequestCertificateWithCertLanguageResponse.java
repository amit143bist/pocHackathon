
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
 *         &lt;element name="RequestCertificateWithCertLanguageResult" type="{http://www.docusign.net/API/3.0}DocumentPDFs" minOccurs="0"/>
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
    "requestCertificateWithCertLanguageResult"
})
@XmlRootElement(name = "RequestCertificateWithCertLanguageResponse")
public class RequestCertificateWithCertLanguageResponse {

    @XmlElement(name = "RequestCertificateWithCertLanguageResult")
    protected DocumentPDFs requestCertificateWithCertLanguageResult;

    /**
     * Gets the value of the requestCertificateWithCertLanguageResult property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentPDFs }
     *     
     */
    public DocumentPDFs getRequestCertificateWithCertLanguageResult() {
        return requestCertificateWithCertLanguageResult;
    }

    /**
     * Sets the value of the requestCertificateWithCertLanguageResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentPDFs }
     *     
     */
    public void setRequestCertificateWithCertLanguageResult(DocumentPDFs value) {
        this.requestCertificateWithCertLanguageResult = value;
    }

}
