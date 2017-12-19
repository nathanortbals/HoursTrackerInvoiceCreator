/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author nathan
 */
public class Settings {
    private static SettingsVariables settings;

    public static void saveSettings() throws Exception{
        FileOutputStream fileOut = new FileOutputStream("Settings.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(settings);
        out.close();
        fileOut.close();
    }
    
    private static void loadSettings() throws Exception{
        settings = new SettingsVariables();
        FileInputStream fileIn = new FileInputStream("Settings.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        settings = (SettingsVariables) in.readObject();
        in.close();
        fileIn.close();
    }
    
    public static SettingsVariables getSettings() throws Exception{
        if(settings == null){
            loadSettings();
        }
        
        return settings;      
    }
}
