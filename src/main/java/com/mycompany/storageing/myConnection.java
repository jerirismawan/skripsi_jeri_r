/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storageing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vb080719
 */
class myConnection {
    public static Connection getConnection() throws SQLException{
Connection con = null;    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/storageing","root","");
        
    } catch (ClassNotFoundException ex) {
        System.out.println(ex.getMessage());
    }
    return con;
}
}
           