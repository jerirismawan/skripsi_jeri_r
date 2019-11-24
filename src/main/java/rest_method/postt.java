package rest_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.control.Alert;
import static org.elasticsearch.common.xcontent.XContentType.JSON;


public class postt {
    
        public void postResponse(String iddoc, String author, String title, Integer year, String fulteks) {try {

			URL url = new URL("http://localhost:9200/skripsi/_doc/"+iddoc);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"IDDoc\":\""+iddoc+"\",\"Author\":\""+author+"\",\"Title\":\""+title+"\",\"Year\":"+year+",\"Fulltext\":\""+fulteks+"\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                               
				
                                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Pesan");
                                 alert.setHeaderText(null);
                                 alert.setContentText("Data gagal disimpan \n Kode Error :"+ conn.getResponseCode());
                                 alert.show();
                                throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

                        BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
                                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Pesan");
                                 alert.setHeaderText(null);
                                 alert.setContentText("Data berhasil disimpan");
                                 alert.showAndWait();
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
                        
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

    
}
