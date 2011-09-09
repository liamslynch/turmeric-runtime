//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.07 at 12:06:52 PM GMT+05:30 
//


package com.ebay.marketplace.search.v1.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DominantProductTypeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DominantProductTypeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sort" type="{http://www.ebay.com/marketplace/search/v1/services}DFNSortType"/>
 *         &lt;element name="fetchSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="coverageThreshold" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DominantProductTypeRequest", propOrder = {
    "sort",
    "fetchSize",
    "coverageThreshold"
})
public class DominantProductTypeRequest {

    @XmlElement(required = true)
    protected DFNSortType sort;
    protected Integer fetchSize;
    protected Float coverageThreshold;

    /**
     * Gets the value of the sort property.
     * 
     * @return
     *     possible object is
     *     {@link DFNSortType }
     *     
     */
    public DFNSortType getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     * @param value
     *     allowed object is
     *     {@link DFNSortType }
     *     
     */
    public void setSort(DFNSortType value) {
        this.sort = value;
    }

    /**
     * Gets the value of the fetchSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFetchSize() {
        return fetchSize;
    }

    /**
     * Sets the value of the fetchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFetchSize(Integer value) {
        this.fetchSize = value;
    }

    /**
     * Gets the value of the coverageThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCoverageThreshold() {
        return coverageThreshold;
    }

    /**
     * Sets the value of the coverageThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCoverageThreshold(Float value) {
        this.coverageThreshold = value;
    }

}