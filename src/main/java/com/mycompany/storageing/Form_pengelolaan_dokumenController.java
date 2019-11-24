
package com.mycompany.storageing;

import java.util.regex.Pattern;
import rest_method.postt;
import aplikasi_penyimpanan.config.config;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.openjson.JSONArray;
import org.json.JSONArray;
import org.json.JSONObject;
//mport com.github.openjson.JSONObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeView;
import com.mycompany.util.ConnectionUtil;
import com.mycompany.storageing.Elastic;
import module.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger; 
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import com.mycompany.storageing.Elastic;
import java.io.BufferedInputStream;
import static java.lang.System.console;
import java.net.MalformedURLException;
import java.net.URLConnection;
import static java.time.Clock.system;
import javafx.scene.control.TextArea;
import javax.swing.JFileChooser;
import static joptsimple.util.RegexMatcher.regex;
import org.apache.tika.exception.TikaException;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.xml.sax.SAXException;
import rest_method.deletee;
import rest_method.updatee;

public class Form_pengelolaan_dokumenController implements Initializable {
    
    @FXML
    private AnchorPane formpengelolaandokumen;
    @FXML
    private AnchorPane pengdok;
    @FXML
    private JFXButton btnPengDok;
    @FXML
    private JFXButton btnIndexDok;
    @FXML
    private JFXButton logout;
    @FXML
    private JFXButton browsedok;
    @FXML
    private JFXButton simpan_dok;
    @FXML
    private TextField listvieww;
    public JFXButton btn_reset;
    public JFXTextField txt_judul;
    public JFXTextField txt_tahun;
    public JFXTextField txt_author;
    private TextField tf_file;
    private JFXTextField txt_npm;
    private JFXTextField txt_nama;
    private JFXTextField txt_pass;
    @FXML
    private Button hapusakun;
    @FXML
    private Button idbatalreset;
    private JFXTextField txt_email;
    private JFXTextField txt_tlp;
    private JFXTextField txt_username;
    private TextField txt_cat;
    @FXML
    private TextField txt_masukan_user;
    @FXML
    private AnchorPane idinput;
    @FXML
    private VBox idvxbox;
    @FXML
    private TextField txtcaridok;
    @FXML
    private Button idcaridok;
    private JFXTextField txt_author1;
    private JFXTextField txt_judul_skrip;
    @FXML
    private Button hapusdok;
    @FXML
    private Button idbatalhapusdok;
    private JFXTextField txt_tahunterbit;
    private JFXTextField tahun;
    @FXML
    private Pane pane_reset;
    @FXML
    private Pane pane_hapusdok;
    @FXML
    private JFXTextField tAuthor;
    @FXML
    private JFXTextField tTitle;
    @FXML
    private JFXTextField tYear;
    @FXML
    private JFXTextField IDDoc;
    @FXML
    private Pane pane_edit;
    @FXML
    private JFXTextField tAuthor1;
    @FXML
    private JFXTextField tTitle1;
    @FXML
    private JFXTextField tYear1;
    @FXML
    private TextField IDDoc1;
     
    private String fullText;
    @FXML
    private JFXButton simpanedit;
    private JFXTextField tAuthor11;
    private JFXTextField tTitle11;
    private JFXTextField tYear11;
    private TextField IDDoc11;
    private JFXListView<String> lvhasil;
    private JFXTextField tfpencarian;
    @FXML
    private TextField authorr;
    @FXML
    private TextField titlee;
    @FXML
    private TextField yearr;
    private JFXButton simpan_edit;
    @FXML
    private JFXButton btl_edit;
    @FXML
    private JFXButton cari_edit;
    private TextArea tFullText;
    @FXML
    private JFXListView<String> lv_judul;
    @FXML
    private JFXButton DATA_JUDUL;
    @FXML
    private TextField txt_caritahun;
    @FXML
    private JFXButton edit;
    @FXML
    private JFXButton hapus_dok;
    @FXML
    private JFXButton reset_akun;
  
  
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
    }
        
  
    
    @FXML
    private void handleButtonClicks(MouseEvent event) {
    }

    private void btnPengDok(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("pesan");
                alert.setHeaderText(null);
                alert.setContentText("Anda berada di form pengelolaan dokumen!");
                alert.showAndWait();   
               
    }

    @FXML
    private void btn_pengindeks(ActionEvent event) {
         pengdok.getChildren().clear();
            Node [] nodes = new  Node[15];
            for(int i = 0; i<10; i++){
                try {
                    nodes[i] = (Node)FXMLLoader.load(getClass().getResource("/fxml/fLengkapi_dok.fxml"));
                    pengdok.getChildren().add(nodes[i]);   
                } catch (IOException ex) {
                    Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
                
                    }           
                
    }
    }

    @FXML
    private void btn_logout(ActionEvent event) {
           pengdok.getChildren().clear();
            Node [] nodes = new  Node[15];
            for(int i = 0; i<10; i++){
                try {
                    nodes[i] = (Node)FXMLLoader.load(getClass().getResource("/fxml/fLogin.fxml"));
                    pengdok.getChildren().add(nodes[i]);   
                } catch (IOException ex) {
                    Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
                
                }}
    }
 
    @FXML
    private void btn_browse_dok(ActionEvent event) {
       
        
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);         
            if (selectedFile != null){
        String dir = selectedFile.getAbsolutePath();

        listvieww.setText(dir);
            Parse konver = new Parse();
            
        try {
            fullText = konver.convertPdf(dir);
        } catch (IOException ex) {
            Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TikaException ex) {
            Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
          }

         
      //  connversi();
    } 
            
            
            else {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("pesan");
                alert.setHeaderText(null);
                alert.setContentText("Data Tidak falid !");
                alert.showAndWait();
            }
    }
    
    public void connversi(String[] args){
//         Parse.convertPdf() aksesVar= new Parse();
//        tFullText.setText("akses :"+aksesVar.full);
    }
    
    @FXML
    private void btn_hapus_dok(ActionEvent event) {
        pane_hapusdok.setVisible(true);
        idinput.setDisable(true);
        idvxbox.setDisable(true);
        hapusdok.setDisable(true);
        
    } 
    @FXML  
    public void btn_simpan_dok(ActionEvent event) {
     creat();
        IDDoc.setText("");
        tAuthor.setText("");
        tTitle.setText("");
        tYear.setText("");
        
     }
     
    public void creat(){
     //  String fulteks = tFullText.getText(); 
        //String ft = fullText;
        String iddoc = IDDoc.getText();
        String author = tAuthor.getText();
        String title = tTitle.getText();
        int year; 
        year = Integer.valueOf(tYear.getText());  
        String regex = "\\s+|\\[|\\]|\\{|\\}|\\”|\\“|\\\\|\"";
        String full  = fullText .replaceAll(regex, " ");   
       System.out.println(full);
      
   
        
        new postt().postResponse(iddoc, author, title, year,full);        
    }
    
    
    
     
    @FXML
    private void btn_hapusakun(ActionEvent event) {
    String user ="";
    String sql = "";
    ResultSet res= null;
    
    user = txt_masukan_user.getText();
        try {    
             java.sql.Connection conn=(Connection)config.configDB();
             java.sql.PreparedStatement pst;
             sql = "select * from tabel_user where username='"+user+"'";
             pst=conn.prepareStatement(sql);
             res = pst.executeQuery();
              if(!res.next()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Username tidak ditemukan!!!");
                alert.setTitle("Gagal");
                alert.showAndWait();
              }else{
                sql = "delete from tabel_user where username='"+user+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("pesan");
                alert.setHeaderText(null);
                alert.setContentText("Akun " +user+" berhasil Reset !");
                alert.showAndWait();
                pane_reset.setVisible(false);
                idinput.setDisable(false);
                idvxbox.setDisable(false);
                txt_masukan_user.setText("");
          }
        } catch (Exception h) {
          
        }
        
    }

    
    @FXML
    private void btl_batalreset(ActionEvent event) {
        pane_reset.setVisible(false);
        idinput.setDisable(false);
        idvxbox.setDisable(false);
        
    }
        
    @FXML
    public void btn_reset(ActionEvent event) {
        pane_reset.setVisible(true);
        idinput.setDisable(true);
        idvxbox.setDisable(true);
     }

    
   @FXML
    private void btn_hapusdok(ActionEvent event) { 
      String id = txtcaridok.getText();
      new deletee().deleteResponse(id );
        txtcaridok.setText("");
        authorr.setText("");
        titlee.setText("");
        yearr.setText("");
        
        pane_hapusdok.setVisible(false);
        idinput.setDisable(false);
        idvxbox.setDisable(false);
    }
    
    private void mHapusDokumen(){
     
    }

    @FXML
    private void btn_batalhapusdok(ActionEvent event) {
        pane_hapusdok.setVisible(false);
        idinput.setDisable(false);
        idvxbox.setDisable(false);
    }
 
    @FXML
    private void btn_pengdok(ActionEvent event) {
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void btn_edit(ActionEvent event) {
       pane_edit.setVisible(true);
        idinput.setDisable(true);
        idvxbox.setDisable(true);
        simpanedit.setDisable(true);
        
    }

    @FXML
    private void btn_bataledit(ActionEvent event) {
    pane_edit.setVisible(false);
        idinput.setDisable(false);
        idvxbox.setDisable(false);
        IDDoc1.setText("");
        tAuthor1.setText("");
        tTitle1.setText("");
        tYear1.setText("");
    }
    

    @FXML
    private void btn_simpanedit(ActionEvent event) {
        String fulltext = listvieww.getText();
        String iddoc = IDDoc1.getText();
        String author = tAuthor1.getText();
        String title = tTitle1.getText();
        int year;
        year = Integer.valueOf(tYear1.getText());         
             
        new updatee().updateResponse(iddoc, author, title, year); 
        listvieww.setText("");
        IDDoc1.setText("");
        tAuthor1.setText("");
        tTitle1.setText("");
        
        pane_edit.setVisible(false);
        idinput.setDisable(false);
        idvxbox.setDisable(false);   
        
    }

    @FXML
    private void btn_cariID(ActionEvent event) {
                   
        String iddocx = txtcaridok.getText();
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
                        String nama = (source.getString("Author"));
                        String judul = (source.getString("Title"));  
                        int tahun;
                        tahun= (source.getInt ("Year")); 
                    //  lvhasil.getItems().addAll(titlle); 
                        authorr.setText(nama);
                        titlee.setText(judul);
                        yearr.setText(Integer.toString(tahun));
                        hapusdok.setDisable(false);
                    }
                }                 
            } catch(Exception e) {
              
            }
        }
    }  


    @FXML
    private void btn_cari_edit(ActionEvent event) {
         String iddocx = IDDoc1.getText();
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
                        String nama = (source.getString("Author"));
                        String judul = (source.getString("Title"));  
                        int tahun;
                        tahun= (source.getInt ("Year")); 
                    //  lvhasil.getItems().addAll(titlle); 
                        tAuthor1.setText(nama);
                        tTitle1.setText(judul);
                        tYear1.setText(Integer.toString(tahun));
                        simpanedit.setDisable(false);
                    }
                }                 
            } catch(Exception e) {
              
            }
        }
    }

    @FXML
    private void btn_data_judul(ActionEvent event) throws MalformedURLException, IOException {  
              
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

        
        
     
 
     




    

   
 
     