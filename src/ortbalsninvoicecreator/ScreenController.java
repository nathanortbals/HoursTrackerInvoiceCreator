/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nathan
 */
public class ScreenController {
    
    private Parent previewRoot;
    private Parent settingsRoot;
    
    private Scene previewScene;
    private Scene settingsScene;
         
    private Stage stage;
    
    public ScreenController(Stage stage){
        this.stage = stage;
        
        try {
            FXMLLoader previewLoader =  new FXMLLoader(getClass().getResource("FXMLPreview.fxml"));
            FXMLLoader settingsLoader =  new FXMLLoader(getClass().getResource("FXMLSettings.fxml"));
            previewRoot = previewLoader.<Parent>load();
            settingsRoot = settingsLoader.<Parent>load();
            
            FXMLPreviewController previewController = previewLoader.<FXMLPreviewController>getController();
            FXMLSettingsController settingsController = settingsLoader.<FXMLSettingsController>getController();
            
            previewController.setScreenController(this);
            settingsController.setScreenController(this);
            previewController.setStage(stage);
            settingsController.setStage(stage);
            
            previewScene = new Scene(previewRoot);
            settingsScene = new Scene(settingsRoot);
        } catch (IOException ex) {
           ex.printStackTrace(); 
        }

        this.stage.setScene(previewScene);
        this.stage.show();
    }
    
    public void switchScreens(){
        if(stage.getScene().equals(previewScene))
            stage.setScene(settingsScene);
        else
            stage.setScene(previewScene);
    }
}
