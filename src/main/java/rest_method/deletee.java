/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest_method;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javafx.scene.control.Alert;

/**
 *
 * @author vb080719
 */
public class deletee {
    public void deleteResponse(String id ) { 
      try { 
            com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();
            
        WebResource webResource = client.resource("http://localhost:9200/skripsi/_doc/"+id); 
        ClientResponse response = webResource.accept("") 
                .delete(ClientResponse.class); 
        if (response.getStatus() != 200) { 
              Alert alrm = new Alert(Alert.AlertType.WARNING);
                                      alrm = new Alert(Alert.AlertType.WARNING);
                                      alrm.setTitle("pesan");
                                      alrm.setHeaderText(null);
                                      alrm.setContentText("maaf ID Dokumen tidak tersedia");
                                      alrm.showAndWait(); 
            throw new RuntimeException("Failed : HTTP error code : " + 
                    response.getStatus());
        }  
        String output2 = response.getEntity(String.class); 
        //System.out.println("\n=====Plain Text Response======"); 
        System.out.println(output2); 
            Alert alrm = new Alert(Alert.AlertType.INFORMATION);
                  alrm = new Alert(Alert.AlertType.INFORMATION);
                  alrm.setTitle("pesan");
                  alrm.setHeaderText(null);
                  alrm.setContentText("Dokumen dengan Id "+id+" berhasil hapus");
                  alrm.showAndWait(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }  
    }//end of method 
}
    
