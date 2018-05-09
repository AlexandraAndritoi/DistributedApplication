/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributtedapp;

import distributtedapp.databsemanager.MySQLJDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexandra
 */
public class DistributtedApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Connection conn = MySQLJDBCUtil.getConnection();
               Statement stmt = conn.createStatement()) {
            
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
