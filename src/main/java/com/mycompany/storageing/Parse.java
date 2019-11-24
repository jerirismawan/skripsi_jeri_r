/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storageing;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;


/**
 *
 * @author vb080719
 */
public class Parse {
    @FXML
    private AnchorPane formpengelolaandokumen;
    @FXML
    private TextField tFullText;
   
   
     public static void main(final String[] args) throws IOException,TikaException, SAXException {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_pengelolaan_dokumenController().setVisible(true);
            }
        });
      
   }
   
   
   
    public String convertPdf(String fileName) throws FileNotFoundException, IOException, SAXException, TikaException{
    
      BodyContentHandler handler = new BodyContentHandler(-1);
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File(fileName));
      ParseContext pcontext = new ParseContext();
      
      //parsing the document using PDF parser
      AutoDetectParser parser = new AutoDetectParser (); 
      parser.parse(inputstream, handler, metadata,pcontext);
      
       
      //getting the content of the document
     // System.out.println("Contents of the PDF :" + handler.toString());
 
      
      //getting metadata of the document
      System.out.println("Metadata of the PDF:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) {
        
         System.out.println(name+ " : " + metadata.get(name));
      }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("pesan");
                alert.setHeaderText(null);
                alert.setContentText("Contents of the PDF :" + handler.toString());
                alert.showAndWait(); 
             //  final String full=("Contents of the PDF :" + handler.toString());
        return handler.toString();     
    }
}
    

