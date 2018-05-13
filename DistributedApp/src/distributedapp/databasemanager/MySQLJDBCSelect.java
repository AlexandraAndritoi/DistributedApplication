/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.databasemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexandra
 */
public class MySQLJDBCSelect {
    private static MySQLJDBCSelect selectionObject = null;
    
    private MySQLJDBCSelect(){
        
    }
    
    public ArrayList<String> selectUser(String username){
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectUser(): "
                + "User data is ready to be selected from database...");
        
        ArrayList<String> array =  new ArrayList<String>();
        
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE username =?";
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectUser(): "
                + sql);
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
           
            System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectUser(): "
                    + "Connected");
            
            pstmt.setString(1, username);
            
            rs    = pstmt.executeQuery();
            
            if (rs.next()) {
                array.add(rs.getString("id"));
                array.add(rs.getString("username"));
                array.add(rs.getString("first_name"));
                array.add(rs.getString(4));
                array.add(rs.getString(5));
                array.add(rs.getString(6));
                array.add(rs.getString(7));
                array.add(rs.getString(8));
                array.add(rs.getString(9));
                array.add(rs.getString(10));
                array.add(String.valueOf(rs.getDate(11)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectUser() "
                + array.get(0));
        
        return array;
    }
    
    public String selectFirstName(String username, String password){
        
        String sql = "SELECT first_name FROM user WHERE username=? AND password=?";
        
        ResultSet rs = null;
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectFirstName(): "
                + sql);
        
        String first_name = "Invalid user";
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            
            System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectFirstName(): "
                    + "Connected to database");
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            rs    = pstmt.executeQuery();
            
            if(rs.next())
                first_name = rs.getString("first_name");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return first_name;
    }
    
    public int getUserId(String username){
        String sql = "SELECT id FROM user WHERE username = ?";
        
        ResultSet rs = null;
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.getUserId(): "
                + sql);
        
        int id = 0;
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            rs    = pstmt.executeQuery();
            
            if(rs.next())
                id = rs.getInt("id");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return id;
    }
    
    public static MySQLJDBCSelect getMySQLJDBCSelect(){
        if(selectionObject == null)
            selectionObject =  new MySQLJDBCSelect();
        return selectionObject;
    }
}
