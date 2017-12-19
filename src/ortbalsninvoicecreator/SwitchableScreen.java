/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author nathan
 */
public abstract class SwitchableScreen implements Initializable {
    protected ScreenController screenController;
    protected Stage stage;
    
    public void setScreenController(ScreenController screenController){
        this.screenController = screenController;
    }
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
   
    @Override
    public abstract void initialize(URL url, ResourceBundle rb);
}
