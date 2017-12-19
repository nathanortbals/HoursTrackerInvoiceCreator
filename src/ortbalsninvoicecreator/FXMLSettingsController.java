/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author nathan
 */
public class FXMLSettingsController extends SwitchableScreen{    
    @FXML
    private Label message;
    
    @FXML
    private ImageView headerImage;
        
    @FXML
    private TextField invoiceNumber;
    
    @FXML
    private TextField billingName;
    
    @FXML
    private TextField billingAddress;
    
    @FXML
    private TextField billingState;
    
    @FXML
    private TextField billingEmail;
    
    @FXML
    private TextField billingPhoneNumber;
    
    @FXML
    private TextField contactName;
    
    @FXML
    private TextField contactAddress;
    
    @FXML
    private TextField contactState;
    
    @FXML
    private TextField contactEmail;
    
    @FXML
    private TextField contactPhoneNumber;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadFields();
    }
    
    private void loadFields(){
        try{
            Image image = new Image(Settings.getSettings().getImageFilePath());
            headerImage.setImage(image);
            invoiceNumber.setText(Integer.toString((Settings.getSettings().getInvoiceNumber())));
            billingName.setText(Settings.getSettings().getBillingName());
            billingAddress.setText(Settings.getSettings().getBillingAddress());
            billingState.setText(Settings.getSettings().getBillingState());
            billingEmail.setText(Settings.getSettings().getBillingEmail());
            billingPhoneNumber.setText(Settings.getSettings().getBillingNumber());
            contactName.setText(Settings.getSettings().getContactName());
            contactAddress.setText(Settings.getSettings().getContactAddress());
            contactState.setText(Settings.getSettings().getContactState());
            contactEmail.setText(Settings.getSettings().getContactEmail());
            contactPhoneNumber.setText(Settings.getSettings().getContactNumber());
        } catch(Exception ex){
            message.setText(ex.getMessage());
        }
    }
    
    @FXML
    private void saveFields(ActionEvent event){
        try {
            Settings.getSettings().setInvoiceNumber(Integer.parseInt(invoiceNumber.getText()));
            Settings.getSettings().setBillingName(billingName.getText());
            Settings.getSettings().setBillingAddress(billingAddress.getText());
            Settings.getSettings().setBillingState(billingState.getText());
            Settings.getSettings().setBillingEmail(billingEmail.getText());
            Settings.getSettings().setBillingNumber(billingPhoneNumber.getText());
            Settings.getSettings().setContactName(contactName.getText());
            Settings.getSettings().setContactAddress(contactAddress.getText());
            Settings.getSettings().setContactState(contactState.getText());
            Settings.getSettings().setContactEmail(contactEmail.getText());
            Settings.getSettings().setContactNumber(contactPhoneNumber.getText());
            
            Settings.saveSettings();
        } catch (Exception ex) {
            message.setText(ex.getMessage());
        }
    }
    
    @FXML
    private void selectImage(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Header Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG Image", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(super.stage);
        
        try{
            Settings.getSettings().setImageFilePath(selectedFile.toURI().toString());
            Image image = new Image(selectedFile.toURI().toString());
            headerImage.setImage(image);
        } catch(Exception ex){
            message.setText(ex.getMessage());
        }   
    }
    
    @FXML
    private void backToPreview(ActionEvent event){
        super.screenController.switchScreens();
    }
}
