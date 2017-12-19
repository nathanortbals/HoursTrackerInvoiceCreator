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

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.Date;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import net.sf.dynamicreports.examples.Templates;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.StretchType;


/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class InvoiceDesign1 implements PDFDesign{
    
    private final String designName = "InvoiceDesign1";
    private final String previewFileName = "InvoiceDesign1Preview.jpg";
    
    @Override
    public String getDesignName(){
        return designName;
    }
    
    @Override
    public Image getDesignPreview(){
        try{
            Image image = new Image(getClass().getResource(previewFileName).toURI().toString());
            return image;
        } catch (Exception ex){
            return null;
        }   
    }
    
    @Override
    public void build(PayPeriod payPeriod) throws Exception{
        TextColumnBuilder<Date> dateColumn = col.column("Date", "clockedIn", type.dateType());
        TextColumnBuilder<Date> startColumn = col.column("Start", "clockedIn", type.timeHourToMinuteType());
        TextColumnBuilder<Date> endColumn = col.column("End", "clockedOut", type.timeHourToMinuteType());
        TextColumnBuilder<Double> durationColumn = col.column("Duration", "duration", type.doubleType());
        TextColumnBuilder<Double> rateColumn = col.column("Hourly Rate" , "hourlyRate", type.doubleType());
        TextColumnBuilder<Double> earningsColumn = col.column("Earnings", "earnings", type.doubleType());
        TextColumnBuilder<String> commentColumn = col.column("Comment", "comment", type.stringType());
        
        AggregationSubtotalBuilder<Double> totalDuration = sbt.sum("duration", Double.class, durationColumn).setLabel("Total Hours");
        AggregationSubtotalBuilder<Double> totalEarnings = sbt.sum("earnings", Double.class, earningsColumn).setLabel("Total Earnings");
        
        report()
                .setTemplate(Templates.reportTemplate)
                .columns(dateColumn, startColumn, endColumn, durationColumn, rateColumn, earningsColumn, commentColumn) 
                .title(
                     cmp.horizontalList().add(createTitleComponent()),
                     cmp.horizontalList().setStyle(stl.style(10)).setGap(50).add(
                             cmp.hListCell(createCustomerComponent()),
                             cmp.hListCell(createContactComponent()))
                )
                .subtotalsAtSummary(totalDuration, totalEarnings)
                .pageFooter(Templates.footerComponent)
                .setDataSource(payPeriod.createDataSource())
                .show();
    }
    
    private ComponentBuilder<?, ?> createTitleComponent() throws Exception{
        BufferedImage header = null;
        header = ImageIO.read(new File(new URI(Settings.getSettings().getImageFilePath())));
        
        HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10).setTopPadding(10).setBottomPadding(10));
        list.add(cmp.image(header).setFixedDimension(300, 45).setImageScale(ImageScale.FILL_FRAME), 
                 cmp.text("Invoice #: " + Integer.toString(Settings.getSettings().getInvoiceNumber())).setStyle(Templates.bold18CenteredStyle).setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT));
        
        return cmp.verticalList(list, cmp.filler().setStyle(stl.style().setTopBorder(stl.pen1Point())));
    }
          
    private ComponentBuilder<?, ?> createCustomerComponent() throws Exception{
        HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));
        list.add(cmp.text("Name: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getBillingName())).newRow();
        list.add(cmp.text("Address: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getBillingAddress())).newRow();
        list.add(cmp.text("City: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getBillingState())).newRow();
        list.add(cmp.text("Email: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getBillingEmail())).newRow();
        list.add(cmp.text("Phone Number: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getBillingNumber())).newRow();
        return cmp.verticalList(cmp.text("Bill To:").setStyle(Templates.boldStyle), list);
    }
    
    private ComponentBuilder<?, ?> createContactComponent() throws Exception{
        HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));
        list.add(cmp.text("Name: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getContactName())).newRow();
        list.add(cmp.text("Address: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getContactAddress())).newRow();
        list.add(cmp.text("City: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getContactState())).newRow();
        list.add(cmp.text("Email: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getContactEmail())).newRow();
        list.add(cmp.text("Phone Number: ").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(Settings.getSettings().getContactNumber())).newRow();
        return cmp.verticalList(cmp.text("Contact:").setStyle(Templates.boldStyle), list);
    }
    

    
    

}

