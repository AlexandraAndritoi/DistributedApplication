/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributtedapp.databasemanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Alexandra
 */
public class MySQLJDBCUtil {
    public static Connection getConnection() throws SQLException
    {
        Connection conn = null;
        
        //System.out.println("mysqljdbc.MySQLJDBCUtil.getConnection()" + "\nAJUNGE AICI");
        
        
        
        try(FileInputStream f = new FileInputStream("db.properties"))
        {
            
            //load the properties file containg the database properties
            Properties pros = new Properties();
            pros.load(f);
            
            //assing the database parameters
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            
            //System.out.println("mysqljdbc.MySQLJDBCUtil.getConnection()\n" + url + "\n" + user + "\n" + password);
            
            //create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        }catch(IOException e)
        {
            System.out.println("mysqljdbc.MySQLJDBCUtil.getConnection() " + e.getMessage());
        }
        
        return conn;
    }
}
