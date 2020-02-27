/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBConnector {
    
    public static Connection getConnection() throws SQLException{
        
       // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/student","root","");
         Connection connection= (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/student","root","");

        
        return connection;
        
    }
    
}
