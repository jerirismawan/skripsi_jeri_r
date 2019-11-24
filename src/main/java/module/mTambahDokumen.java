/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;
import java.util.Scanner;
import com.mycompany.storageing.Form_pengelolaan_dokumenController;
import javafx.scene.control.Alert;

/**
 *
 * @author vb080719
 */
public class mTambahDokumen {
    
  public static void main (){
    String author = null,
            judul = null,
            tahun = null;
    
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Data Tersimpan" );
                alert.setHeaderText(null);
                 alert.setContentText("Author :"+""+author+","
                         + "Judul :"+""+judul+","
                                 +"Tahun Terbit :"+""+tahun +".");
          
                alert.showAndWait();
  }
}

