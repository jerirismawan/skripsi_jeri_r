/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author vb080719
 */
public class User {
    private String file;
    private String author;
    private String title ;
    private Integer year;
    private String iddoc;
   
    

    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file= file;    
            } 
     public String getIDDoc() {
        return iddoc;
    }
    public void setIDDoc(String iddoc) {
        this.iddoc = iddoc;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
      this.title = title;  
    }
     public Integer getYear() {
        return year ;
    }
    public void setYear(Integer year) {
      this.year = year;  
    }
    

}
