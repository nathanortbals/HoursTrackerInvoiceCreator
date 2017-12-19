/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.paint.Color;

/**
 *
 * @author nathan
 */
public class FXMLPreviewController extends SwitchableScreen implements Initializable {    
    private PayPeriod payPeriod;
    private InvoiceDesign1 design1;
    
    @FXML
    private Label message;
    
    @FXML
    private Label designPreviewLabel;
    
    @FXML
    private Button generateButton;
    
    @FXML
    private ImageView previewImageView;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       payPeriod = new PayPeriod();
       generateButton.setDisable(true);
       loadDesigns();       
    }
   
    @FXML
    private void handleOpenCSVExport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSVExport File");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(super.stage);
        
        if (selectedFile != null){
            try{
                payPeriod.tryParseCSVExport(selectedFile);
                message.setText(selectedFile.getPath());
                message.setTextFill(Color.BLACK);
                generateButton.setDisable(false);
            } catch(FileNotFoundException ex){
                message.setText("File not found");
                message.setTextFill(Color.RED);
            } catch(IOException ex){
                message.setText("IOException");
                message.setTextFill(Color.RED);
            } catch (ParseException ex){ 
                message.setText("File could not be parsed");
                message.setTextFill(Color.RED);
            }  
        }
    }
    
    @FXML
    private void handleSave(ActionEvent event){
        if(payPeriod.isPopulated()){
            message.setText("Generating PDF...");
            try{
                design1.build(payPeriod);
            } catch(Exception ex){
                message.setText(ex.getMessage());
            }
        }
    }
    
    @FXML
    private void handleSettings(ActionEvent event){
        super.screenController.switchScreens();
    }

    @FXML
    private void handleAbout(ActionEvent event){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText(
                  "This application takes a .csv file from the"
                + " iPhone app \"HoursTracker\" and creates a invoice in PDF form. "
                + " Addtional information is added to the invoice through the settings"
                + " page. A sample .csv file is provided in the project zip folder"
                + " for testing purposes. \n\n"
                + " I built this app for my internship this summer, where"
                + " I am hired contractually and must bill my hours bi-weekly. \n\n"
                + " This application utilizes the open source library"
                + " \"Dynamic Reports\" to generate the PDF programatically.");
        alert.showAndWait();
    }
    
    private void loadDesigns(){
        design1 = new InvoiceDesign1();
        
        designPreviewLabel.setText(design1.getDesignName() + " Preview:");
        previewImageView.setImage(design1.getDesignPreview());
    }
}
