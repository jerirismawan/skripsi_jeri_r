/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest_method;


import com.mycompany.storageing.Form_pengindeksan_dokumenController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.control.Alert;


public class lengkapi_dok {
    
       public void lrResponse(String iddoc, String npm, String author,String title, String key, 
                                Integer year, String month, String stat, Integer tags, String full) {
            try {
 
			URL url = new URL("http://localhost:9200/skripsi/_doc/"+iddoc);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"IDDoc\":\""+iddoc+"\",\"NPM\":\""+npm+"\",\"Author\":\""+author+"\",\"Title\":\""+title+"\",\"Keywords\":\""+key+"\",\"Year\":"+year+",\"Month\":\""+month+"\",\"Status\":\""+stat+"\",\"Tags\":"+tags+",\"Fulltext\":\""+full+"\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
                         BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
                        String output;
			System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                            	    Alert alrm = new Alert(Alert.AlertType.INFORMATION);
                                      alrm = new Alert(Alert.AlertType.INFORMATION);
                                      alrm.setTitle("pesan");
                                      alrm.setHeaderText(null);
                                      alrm.setContentText("Dokumen berhasil disimpan");
                                      alrm.showAndWait(); 
                                      
                            throw new RuntimeException("data berhasil disimpan"+output);  
                    
     			}
                     
                      System.out.println(conn.getResponseCode());
                                      Alert alr = new Alert(Alert.AlertType.INFORMATION);
                                      alr = new Alert(Alert.AlertType.INFORMATION);
                                      alr.setTitle("pesan");
                                      alr.setHeaderText(null);
                                      alr.setContentText("Dokumen gagal disimpan");
                                      alr.showAndWait(); 
                                      throw new RuntimeException("Failed : HTTP error code : "
                                      );
                          
			}
                        
			conn.disconnect();
                        
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}
       
      
           } 

  

