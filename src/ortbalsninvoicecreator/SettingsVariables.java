/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

/**
 *
 * @author nathan
 */
public class SettingsVariables implements java.io.Serializable {
    private String imageFilePath;
    private int invoiceNumber;
    
    private String billingName;
    private String billingAddress;
    private String billingState;
    private String billingEmail;
    private String billingNumber;
    
    private String contactName;
    private String contactAddress;
    private String contactState;
    private String contactEmail;
    private String contactNumber;
       
    public SettingsVariables(){
        imageFilePath = "";
        invoiceNumber = 0;
    
        billingName = "";
        billingAddress = "";
        billingState = "";
        billingEmail = "";
        billingNumber = "";
    
        contactName = "";
        contactAddress = "";
        contactState = "";
        contactEmail = "";
        contactNumber = "";
    }
    
    
    
    /**
     * @return the imageFilePath
     */
    public String getImageFilePath() {
        return imageFilePath;
    }

    /**
     * @param imageFilePath the imageFilePath to set
     */
    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    /**
     * @return the invoiceNumber
     */
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * @return the billingName
     */
    public String getBillingName() {
        return billingName;
    }

    /**
     * @param billingName the billingName to set
     */
    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    /**
     * @return the billingAddress
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     * @param billingAddress the billingAddress to set
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * @return the billingState
     */
    public String getBillingState() {
        return billingState;
    }

    /**
     * @param billingState the billingState to set
     */
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    /**
     * @return the billingEmail
     */
    public String getBillingEmail() {
        return billingEmail;
    }

    /**
     * @param billingEmail the billingEmail to set
     */
    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    /**
     * @return the billingNumber
     */
    public String getBillingNumber() {
        return billingNumber;
    }

    /**
     * @param billingNumber the billingNumber to set
     */
    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the contactAddress
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * @param contactAddress the contactAddress to set
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     * @return the contactState
     */
    public String getContactState() {
        return contactState;
    }

    /**
     * @param contactState the contactState to set
     */
    public void setContactState(String contactState) {
        this.contactState = contactState;
    }

    /**
     * @return the contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * @param contactEmail the contactEmail to set
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
