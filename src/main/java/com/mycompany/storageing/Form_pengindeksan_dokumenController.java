/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storageing;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.json.JSONArray;
import org.json.JSONObject;
import rest_method.lengkapi_dok;
import rest_method.postt;

/**
 * FXML Controller class
 *
 * @author vb080719
 */
public class Form_pengindeksan_dokumenController implements Initializable {

    @FXML
    private AnchorPane formpengindeksandokumen;
    @FXML
    private JFXButton simpanindeks;
    @FXML
    private JFXButton id_pengdok;
    @FXML
    private JFXButton id_lengdok;
    @FXML
    private JFXButton loggout;
    @FXML
    private AnchorPane idlengkapidok;
    private JFXTextField Keywords;
    private JFXTextField Title;
    private JFXTextField Author;

    private JFXTextField NPM;
    private JFXTextField Year;
//fulltext   
    private JFXTextField Status;
    private JFXTextField Tags;
    
    private JFXTextField IDDoc;
    private JFXTextField Month;
    @FXML
    private TextArea FullText;
    @FXML
    private Pane pane_ft;
    @FXML
    private JFXButton btncari122;
    @FXML
    private TextField tf_iddoc;
    @FXML
    private JFXTextField txt_Keywords;
    @FXML
    private JFXTextField txt_Title;
    @FXML
    private JFXTextField txt_Author;
    @FXML
    private JFXTextField txt_NPM;
    @FXML
    private JFXTextField txt_Year;
    @FXML
    private JFXTextField txt_Status;
    @FXML
    private JFXTextField txt_Tags;
    @FXML
    private JFXTextField txt_IDDoc;
    @FXML
    private JFXTextField txt_Month;
    @FXML
    private JFXButton Bersihkan;
    @FXML
    private TextField txt_caritahun;
    @FXML
    private JFXButton DATA_JUDUL;
    @FXML
    private JFXListView<String> lv_judul;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void btn_simpanindeks(ActionEvent event) {
        msimpan();
        
    }
    
    public void msimpan(){
     
        String iddoc = txt_IDDoc.getText();
        String npm = txt_NPM.getText();
        String author = txt_Author.getText();
        String title = txt_Title.getText();
        String key = txt_Keywords.getText();
        int year;
        year = Integer.valueOf(txt_Year.getText());  
        String month = txt_Month.getText();
        String stat = txt_Status.getText();
        int tags;
        tags = Integer.valueOf(txt_Tags.getText()); 
        String full = FullText.getText(); 
                
    new lengkapi_dok().lrResponse( iddoc,  npm,  author, title,  key, year,  month,  stat,  tags,  full);
     txt_IDDoc.setText("");
     txt_NPM.setText("");
     txt_Author.setText("");
     txt_Title.setText("");
     txt_Keywords.setText("");
     txt_Year.setText("");  
     txt_Month.setText("");
     txt_Status.setText("");
     txt_Tags.setText(""); 
     FullText.setText(""); 
    
    } 

    @FXML
    private void btn_pengdok(ActionEvent event) { 
       
   idlengkapidok.getChildren().clear();
         Node [] nodes = new  Node[15];
            for(int i = 0; i<10; i++){
                try {
                    nodes[i] = (Node)FXMLLoader.load(getClass().getResource("/fxml/fPengelolaan_dokumen.fxml"));
                    idlengkapidok.getChildren().add(nodes[i]);   
                } catch (IOException ex) {
                    Logger.getLogger(Form_pengindeksan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
                
                    }           
                
    }
    }    
    

    @FXML
    private void btn_lengdok(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesan");
                alert.setHeaderText(null);
                alert.setContentText("Anda Berada di form lengkapi dokumen");
                alert.showAndWait();
    }

    @FXML
    private void btn_keluar(ActionEvent event) {
         idlengkapidok.getChildren().clear();
            Node [] nodes = new  Node[15];
            for(int i = 0; i<10; i++){
                try {
                    nodes[i] = (Node)FXMLLoader.load(getClass().getResource("/fxml/fLogin.fxml"));
                    idlengkapidok.getChildren().add(nodes[i]);   
                } catch (IOException ex) {
                    Logger.getLogger(Form_pengindeksan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
                
                    }           
                
    }
    }

    private void back(MouseEvent event) {
        System.out.close();
    }

    @FXML
    private void btn_cariid(ActionEvent event) {    
        String iddocx = tf_iddoc.getText();
        // The input stream from the JSON response
        BufferedInputStream buffer = null;
        
        // URL objects
        String url = "";
        URL urlObject = null;
        URLConnection con = null;
        String response = "";

        // JSON objects
        JSONArray hitsArray = null;
        JSONObject hits = null;
        JSONObject source = null;
        JSONObject json = null;
        
        if(iddocx==""){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Pencarian");
            alert.setHeaderText(null);
            alert.setContentText("Mohon di isi ID Dokumen! ");
            alert.showAndWait();
        } else {  
            //MENCARI DATA DARI ELASTICSEARCH
            try {
                // get a JSON object from ElasticSearch
                url = "http://localhost:9200/skripsi/_search?q=IDDoc:"+iddocx;

                // configure the URL request
                urlObject = new URL(url);
                con = urlObject.openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/5.0");

                buffer = new BufferedInputStream(con.getInputStream());

                while (buffer.available()>0) {
                    response += (char)buffer.read();
                }

                buffer.close();

                // parse the JSON response 		
                json = new JSONObject(response);
                hits = json.getJSONObject("hits");
                hitsArray = hits.getJSONArray("hits");
                
                int jmlHits = hitsArray.length();
                
                if(jmlHits==0){
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Pencarian");
                   alert.setHeaderText(null);
                   alert.setContentText("ID Dokumen yang anda cari tidak cocok!!!");
                   alert.showAndWait();
                } else {  
                  //  lvhasil.getItems().clear();
                    for (int i=0; i<jmlHits; i++) {
                        JSONObject h = hitsArray.getJSONObject(i);
                        source = h.getJSONObject("_source");
                        String id = (source.getString("IDDoc"));
                        String nama = (source.getString("Author"));
                        String judul = (source.getString("Title"));  
                        int tahun;
                        tahun= (source.getInt ("Year")); 
                        String titel = (source.getString("Title"));
                        String ft = (source.getString("Fulltext"));
                    //  lvhasil.getItems().addAll(titlle); 
                        txt_IDDoc.setText(id);   
                        txt_Author.setText(nama);
                        txt_Title.setText(judul);
                        txt_Year.setText(Integer.toString(tahun));
                        FullText.setText(ft);
                        simpanindeks.setDisable(false);
                    }
                }                 
            } catch(Exception e) {
              
            }
        } 
    }
    
    public void kosongkan(){
           txt_IDDoc.setText("");
            txt_NPM.setText("");
            txt_Author.setText("");
            txt_Title.setText(""); 
            txt_Keywords.setText("");
            txt_Year.setText("");
            txt_Month.setText("");
            txt_Status.setText("");
            txt_Tags.setText("");
           FullText.setText("");
    }
public void alret_succes(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesan");
                alert.setHeaderText(null);
                alert.setContentText("Data berhasil disimpan");
                alert.showAndWait();
}

    @FXML
    private void btn_bersihkan(ActionEvent event) {
        kosongkan();
    }

    @FXML
    private void btn_data_judul(ActionEvent event) {
        String value = txt_caritahun.getText();
        
        // The input stream from the JSON response
        BufferedInputStream buffer = null;
        
        // URL objects
        String url = "";
        URL urlObject = null;
        URLConnection con = null;
        String response = "";

        // JSON objects
        JSONArray hitsArray = null;
        JSONObject hits = null;
        JSONObject source = null;
        JSONObject json = null;
        
        if(value==null){
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Pencarian");
            alert.setHeaderText(null);
            alert.setContentText("Mohon diisi tahun Terlebih Dahulu!");
            alert.showAndWait();
        } else {  
            //MENCARI DATA DARI ELASTICSEARCH
            try {
                // get a JSON object from ElasticSearch
                url = "http://localhost:9200/skripsi/_search?q=Year:"+value;

                // configure the URL request
                urlObject = new URL(url);
                con = urlObject.openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/5.0");

                buffer = new BufferedInputStream(con.getInputStream());

                while (buffer.available()>0) {
                    response += (char)buffer.read();
                }

                buffer.close();

                // parse the JSON response 		
                json = new JSONObject(response);
                hits = json.getJSONObject("hits");
                hitsArray = hits.getJSONArray("hits");
                
                int jmlHits = hitsArray.length();
                
                if(jmlHits==0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Pencarian");
                   alert.setHeaderText(null);
                   alert.setContentText("Data yang anda cari tidak cocok!!!");
                   alert.showAndWait();
                } else {  
                    lv_judul.getItems().clear();
                    for (int i=0; i<jmlHits; i++) {
                        JSONObject h = hitsArray.getJSONObject(i);
                        source = h.getJSONObject("_source");
                        String object = (source.getString("Title"));                        
                        lv_judul.getItems().addAll(object);                    
                    }
                }                 
            } catch(Exception e) {
              
            }
        }
    }              
    
}
