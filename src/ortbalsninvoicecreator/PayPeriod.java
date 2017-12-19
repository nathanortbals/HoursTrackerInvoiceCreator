/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author nathan
 */
public class PayPeriod {
    private List<Shift> shifts;
    private boolean isPopulated;
    
    public PayPeriod(){
        isPopulated = false;
    }
    
    public void tryParseCSVExport(File csvExport) throws FileNotFoundException, IOException, ParseException{
        BufferedReader br = new BufferedReader(new FileReader(csvExport));
        String line;
        String splitBy = "\",\"";
        br.readLine();
        shifts = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] shift = line.split(splitBy);
            SimpleDateFormat parser=new SimpleDateFormat("M/d/y h:m a");
            Date clockedIn = parser.parse(shift[1]);
            Date clockedOut = parser.parse(shift[2]);
            Double hourlyRate = Double.parseDouble(shift[3]);
            Double duration = Double.parseDouble(shift[4]);
            Double earnings = Double.parseDouble(shift[5]);
            String comment = shift[6];
            
            shifts.add(new Shift(clockedIn, clockedOut, duration, hourlyRate, earnings, comment));
        }
        br.close();
        
        isPopulated = true;
    }
    
    public boolean isPopulated(){
        return isPopulated;
    }
    
    public JRDataSource createDataSource() {
            return new JRBeanCollectionDataSource(shifts);
    }
}
