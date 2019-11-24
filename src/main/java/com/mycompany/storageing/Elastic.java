 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storageing;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import com.mycompany.storageing.Form_pengindeksan_dokumenController;

/**
 *
 * @author vb080719
 */
public class Elastic {
    private final String index = "skripsi";
    public RestHighLevelClient client;
    
    public Elastic() {
        client = new RestHighLevelClient(
            RestClient.builder(
                new HttpHost("127.0.0.1",9200, "http")
            )
        );
    }
    
  public void creatIndex () throws IOException{ 
      CreateIndexRequest request = new CreateIndexRequest("skripsi");
      request.settings(Settings.builder() 
        .put("index.number_of_shards", 3)
        .put("index.number_of_replicas", 2)
            );
      request.mapping(
        "{\n" +
        "  \"properties\": {\n" +
        "    \"message\": {\n" +
        "      \"type\": \"text\"\n" +
        "    }\n" +
        "  }\n" +
        "}", 
        XContentType.JSON);
      XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
          builder.startObject("settings");
          {
          builder.field("number_of_shards", 5);
          builder.field("number_of_replicas", 1);
          }
          builder.endObject();
          builder.startObject("mappings");
          {
          builder.startObject("_doc");
          {
          builder.startObject("properties");
          {
          builder.startObject("IDDoc");
          {
          builder.field("type", "text");
          }
          builder.endObject();
          builder.startObject("NPM");
          {
          builder.field("type", "text");
                            }
          builder.endObject();
          builder.startObject("Author");
          {
          builder.field("type", "text");
          }
          builder.endObject();
          builder.startObject("Title");
          {
          builder.field("type", "text");
          }
          builder.endObject();
          builder.startObject("Keywords");
          {
          builder.field("type", "text");
          }
          builder.endObject();
          builder.startObject("Year");
          {
          builder.field("type", "integer");
          }
          builder.endObject();
          builder.startObject("Month");
          {
          builder.field("type", "integer");
          }
          builder.endObject();
          builder.startObject("Status");
          {
          builder.field("type", "Text");
          }
          builder.endObject();
          builder.startObject("Tags");
          {
          builder.field("type", "integer");
          }
          builder.endObject();
          builder.startObject("FullText");
          {
          builder.field("type", "text");
          }
            builder.endObject();
            }
            builder.endObject();
            }
            builder.endObject();
    request.source(builder);
    CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
    boolean acknowledged = createIndexResponse.isAcknowledged();
} 
}
}

    void IDDoc(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
}
