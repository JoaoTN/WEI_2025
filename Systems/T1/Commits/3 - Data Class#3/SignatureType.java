//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2021.03.05 às 03:20:26 PM BRT 
//


package br.jus.esocialjt.comunicacao.eventos.retorno.evento;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java de SignatureType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SignatureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}SignedInfo"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}SignatureValue"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}KeyInfo" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Object" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureType", propOrder = {
    "signedInfo",
    "signatureValue",
    "keyInfo",
    "object"
})
public class SignatureType {
    @XmlElement(name = "SignedInfo", required = true)
    private SignedInfoType signedInfo;

    @XmlElement(name = "SignatureValue", required = true)
    private SignatureValueType signatureValue;

    @XmlElement(name = "KeyInfo")
    private KeyInfoType keyInfo;

    @XmlElement(name = "Object")
    private List<ObjectType> objects;

    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    private String id;

    // Construtores, getters e setters

    public SignatureType() {
        // Construtor padrão
    }

    public SignatureType(SignedInfoType signedInfo, SignatureValueType signatureValue, KeyInfoType keyInfo,
                         List<ObjectType> objects, String id) {
        this.signedInfo = signedInfo;
        this.signatureValue = signatureValue;
        this.keyInfo = keyInfo;
        this.objects = objects;
        this.id = id;
    }

    public SignedInfoType getSignedInfo() {
        return signedInfo;
    }

    public void setSignedInfo(SignedInfoType signedInfo) {
        this.signedInfo = signedInfo;
    }

    public SignatureValueType getSignatureValue() {
        return signatureValue;
    }

    public void setSignatureValue(SignatureValueType signatureValue) {
        this.signatureValue = signatureValue;
    }

    public KeyInfoType getKeyInfo() {
        return keyInfo;
    }

    public void setKeyInfo(KeyInfoType keyInfo) {
        this.keyInfo = keyInfo;
    }

    public List<ObjectType> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectType> objects) {
        this.objects = objects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém o valor da propriedade signedInfo.
     * 
     * @return
     *     possible object is
     *     {@link SignedInfoType }
     *     
     */
    public SignedInfoType getSignedInfo() {
        return signedInfo;
    }

    /**
     * Define o valor da propriedade signedInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedInfoType }
     *     
     */
    public void setSignedInfo(SignedInfoType value) {
        this.signedInfo = value;
    }

    /**
     * Obtém o valor da propriedade signatureValue.
     * 
     * @return
     *     possible object is
     *     {@link SignatureValueType }
     *     
     */
    public SignatureValueType getSignatureValue() {
        return signatureValue;
    }

    /**
     * Define o valor da propriedade signatureValue.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureValueType }
     *     
     */
    public void setSignatureValue(SignatureValueType value) {
        this.signatureValue = value;
    }

    /**
     * Obtém o valor da propriedade keyInfo.
     * 
     * @return
     *     possible object is
     *     {@link KeyInfoType }
     *     
     */
    public KeyInfoType getKeyInfo() {
        return keyInfo;
    }

    /**
     * Define o valor da propriedade keyInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyInfoType }
     *     
     */
    public void setKeyInfo(KeyInfoType value) {
        this.keyInfo = value;
    }

    /**
     * Gets the value of the object property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the object property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectType }
     * 
     * 
     */
    public List<ObjectType> getObject() {
        if (object == null) {
            object = new ArrayList<ObjectType>();
        }
        return this.object;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
