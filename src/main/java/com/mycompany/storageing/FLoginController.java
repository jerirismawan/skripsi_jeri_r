/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storageing;
import aplikasi_penyimpanan.config.config;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mycompany.util.ConnectionUtil;
import com.mycompany.util.User;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.mycompany.storageing.Form_pengelolaan_dokumenController;
import java.sql.Statement;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author vb080719
 */
public class FLoginController implements Initializable {

    @FXML
    private AnchorPane f_Logiin;
    @FXML
    private JFXPasswordField tfpassword;
    @FXML
    private JFXTextField tfuser;
    @FXML
    private JFXButton buttonLogin;
    @FXML
    private JFXButton logindaftarakun;
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User user = new User();
    @FXML
    private ImageView panetambah_akun;
    @FXML
    private Pane pane_tambahakun;
    @FXML
    private AnchorPane iddaftarakun;
    @FXML
    private JFXTextField tfnpm;
    @FXML
    private JFXTextField tfnama;
    @FXML
    private Button simpanakun;
    @FXML
    private Button batalakun;
    @FXML
    private JFXTextField tfemail;
    @FXML
    private JFXTextField tftlp;
    @FXML
    private JFXTextField tfuser1;
    @FXML
    private TextField tfcat;
    @FXML
    private JFXTextField tfpasss;
    @FXML
    private JFXTextField tfid;
    @FXML
    private Label tdklngkap;
    @FXML
    private Label alret1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public FLoginController() {
        connection = ConnectionUtil.connectdb();
   }
 
    @FXML
    private void btn_login(ActionEvent event) {
     cek();   
    }
    
    public void login(){
          String username = tfuser.getText().toString();
        String password = tfpassword.getText().toString();
    
        String sql = "SELECT * FROM tabel_user WHERE username = ? and password = ?";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
             resultSet= preparedStatement.executeQuery();
             if(!resultSet.next()){
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert = new Alert(Alert.AlertType.INFORMATION);
                
                alert.setTitle("pesan");
                alert.setHeaderText(null);
                alert.setContentText("username atau password salah !");
                alert.showAndWait();   
               
            }else{
                user.setUsername(username);
                  f_Logiin.getChildren().clear();
            Node [] nodes = new  Node[15];
            for(int i = 0; i<1; i++){
                try {
                    nodes[i] = (Node)FXMLLoader.load(getClass().getResource("/fxml/fPengelolaan_dokumen.fxml"));
                    f_Logiin.getChildren().add(nodes[i]);  
                     Alert alrm = new Alert(Alert.AlertType.WARNING);
                alrm = new Alert(Alert.AlertType.WARNING);
                alrm.setTitle("pesan");
                alrm.setHeaderText(null);
                alrm.setContentText("Selamat Datang "+username);
                alrm.showAndWait(); 
                    
                } catch (IOException ex) {
                    Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                            } 
                        }
                    }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }
  
    
    public void cek (){
         String users = tfuser.getText().toString();
        String username = tfuser.getText();
        connection = ConnectionUtil.connectdb();
                  
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM tabel_user WHERE username = '"+tfuser.getText()+"' and password = '"+tfpassword.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
         
            if(rs.next()){
                if(rs.getString("username").equals("admin")){
                        user.setUsername(username);
                  f_Logiin.getChildren().clear();
            Node [] nodes = new  Node[15];
            for(int i = 0; i<1; i++){
                try {
                    nodes[i] = (Node)FXMLLoader.load(getClass().getResource("/fxml/fPengelolaan_dokumen.fxml"));
                    f_Logiin.getChildren().add(nodes[i]);  
                     Alert alrm = new Alert(Alert.AlertType.WARNING);
                alrm = new Alert(Alert.AlertType.WARNING);
                alrm.setTitle("pesan");
                alrm.setHeaderText(null);
                alrm.setContentText("Selamat Datang "+username);
                alrm.showAndWait(); 
                    
                } catch (IOException ex) {
                    Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                            }                 
                }else{
                  user.setUsername(username);
                  f_Logiin.getChildren().clear();
                        Node [] nodes = new  Node[15];
                         for(int i = 0; i<1; i++){
                try {
                    nodes[i] = (Node)FXMLLoader.load(getClass().getResource("/fxml/f_mahasiswa.fxml"));
                    f_Logiin.getChildren().add(nodes[i]);  
                    Alert alrm = new Alert(Alert.AlertType.WARNING);
                    alrm = new Alert(Alert.AlertType.WARNING);
                    alrm.setTitle("pesan");
                    alrm.setHeaderText(null);
                    alrm.setContentText("Selamat Datang "+username);
                    alrm.showAndWait(); 
                    
                } catch (IOException ex) {
                    Logger.getLogger(Form_pengelolaan_dokumenController.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                            }
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("pesan");
                alert.setHeaderText(null);
                alert.setContentText("username atau password salah !");
                alert.showAndWait();   
            }
        }catch(SQLException e){
        e.printStackTrace();
        }
    }
    @FXML
    private void btn_daftarakun(ActionEvent event) {
        pane_tambahakun.setVisible(true);
        tdklngkap.setVisible(false);
    }

    @FXML
    private void btn_simpanakun(ActionEvent event) {
        mTambahAkun();
    }

    @FXML
    private void btn_batalakun(ActionEvent event) {
        pane_tambahakun.setVisible(false);
        alret1.setVisible(false);
        tfnpm.setText("");
        tfnama.setText("");
        tfemail.setText("");
        tftlp.setText("");
        tfuser1.setText("");
        tfpasss.setText("");
        tfcat.setText("");
        
    }
    private void mTambahAkun(){
       
        String user = tfuser1.getText();
         String NPM = tfnpm.getText();
         String nama = tfnama.getText();
          String email = tfemail.getText();
           String tlp = tftlp.getText();
            String pas = tfpasss.getText();
            String cat = tfcat.getText();
         //var usename
          if((user=="")||(NPM=="")||(email=="")||(tlp=="")||(pas=="")||(cat=="")) {
              tdklngkap.setVisible(true);
              alret1.setVisible(false);
            
          }else{
        
               try {
            String sql = "INSERT INTO tabel_user VALUES ('"+tfnpm.getText()+"','"+tfnama.getText()+"','"+tfemail.getText()+"','"+tftlp.getText()+"','"+tfuser1.getText()+"','"+tfpasss.getText()+"','"+tfcat.getText()+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
          tdklngkap.setVisible(false);
          alret1.setVisible(false);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("pesan");
                alert.setHeaderText(null);
                alert.setContentText("Akun "+user+" berhasil ditambahkan");
                alert.showAndWait();
                pane_tambahakun.setVisible(false);
                alret1.setVisible(false);
                tfnpm.setText("");
                tfnama.setText("");
                tfemail.setText("");
                tftlp.setText("");
                tfuser1.setText("");
                tfpasss.setText("");
                tfcat.setText("");
            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);               
                alert.setTitle("pesan");
                alert.setHeaderText(null);   
                alert.setContentText("Username sudah terpakai!");
                alert.showAndWait();
                tdklngkap.setVisible(false);
                alret1.setVisible(true);
                               
        }
              
                }
  

    }
}