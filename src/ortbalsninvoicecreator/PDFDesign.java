/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

import javafx.scene.image.Image;

/**
 *
 * @author nathan
 */
public interface PDFDesign {
    
    void build(PayPeriod payPeriod) throws Exception;
    
    String getDesignName();
    
    Image getDesignPreview();
    
}
