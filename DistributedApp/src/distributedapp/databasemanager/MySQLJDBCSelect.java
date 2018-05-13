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
import java.sql.Statement;
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
    
    public int selectProductID(String productName){
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectProductID(): "
                + "Ready to select product id...");
        
        String sql = "SELECT id FROM product WHERE  name= ?";
        
        ResultSet rs = null;
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectProductID(): "
                + sql);
        
        int productID = 0;
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, productName);
            
            rs    = pstmt.executeQuery();
            
            if(rs.next())
                productID = rs.getInt("id");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectProductID(): "
                + "product ID: " + productID);
        
        return productID;
    }
    
    public int selectProductStock(int productID){
        String sql = "SELECT stock FROM product WHERE  id=?";
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectProductStock(): "
                + "product ID: " + productID);
        
        ResultSet rs = null;
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectProductStock(): "
                + sql);
        
        int stock = 0;
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, productID);
            
            rs    = pstmt.executeQuery();
            
            if(rs.next())
                stock = rs.getInt("stock");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return stock;
    }
    
    public String selectUserAddress(int userID){
        String sql = "SELECT address FROM user WHERE id = ?";
        
        ResultSet rs = null;
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectUserAddress(): "
                + sql);
        
        String userAddress = "";
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userID);
            
            rs    = pstmt.executeQuery();
            
            if(rs.next())
                userAddress = rs.getString("address");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return userAddress;
    }
    
    public ArrayList<String> selectOrderIDAndAddress(){
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectOrderData(): "
                + "Order ID and Address ready to be selected...");
        
        String sql = "SELECT id,address FROM orders";
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCSelect.selectOrderIDAndAddress(): "
                + sql);
        
        ArrayList<String> orderIDAndAddressList = new ArrayList<String>();
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)) {
            
            while(rs.next())
                orderIDAndAddressList.add(rs.getInt("id") + " " + rs.getString("address"));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return orderIDAndAddressList;
        
    }
    
    public static MySQLJDBCSelect getMySQLJDBCSelect(){
        if(selectionObject == null)
            selectionObject =  new MySQLJDBCSelect();
        return selectionObject;
    }
}
