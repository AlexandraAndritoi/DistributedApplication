/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.databasemanager;

import distributedapp.servermanager.interfaces.CartItemBean;
import distributedapp.servermanager.interfaces.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alexandra
 */
public class MySQLJDBCInsert {
    private static MySQLJDBCInsert insertionObject = null;
    
    private MySQLJDBCInsert(){
        
    }
    
    public void insertUser(User  user){
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser() "
                + "Serializable object is ready to be inserted...");
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser() "
                + "user's address: " + user.getAddress());
        
        ResultSet rs = null;
        int userId = 0;
        
        String sql = "INSERT INTO user(username,first_name,last_name,email,password,"
                + "number,address,country,zipcode,birth)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try(Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getPhone());
            pstmt.setString(7, user.getAddress());
            pstmt.setString(8, user.getCountry());
            pstmt.setString(9, user.getZipcode());
            pstmt.setDate(10, Date.valueOf(user.getBirthdate()));
            
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1){
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    userId = rs.getInt(1);
            }
            
        } catch(SQLException e){
            System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                    + e.getMessage());
        } finally {
            try{
                if(rs != null) rs.close();
            } catch(SQLException e){
                System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                        + e.getMessage());
            }
        }
        
        if(userId != 0) 
            System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                + "New user ID: " + userId);
        else System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                + "Error inserting new user!");
        
    }
    
    public int insertCustomer(int id){
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertCustomer(): "
                + "New customer is ready to be inserted...");
        
        ResultSet rs = null;
        int cutomerID = 0;
        
        String sql = "INSERT INTO customer(user_id) VALUES(?)";
        
        try(Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1,id);
            
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1){
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    cutomerID = rs.getInt(1);
            }
            
        } catch(SQLException e){
            System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                    + e.getMessage());
        } finally {
            try{
                if(rs != null) rs.close();
            } catch(SQLException e){
                System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                        + e.getMessage());
            }
        }
        
        return cutomerID;
    }
    
    public int insertOrder(int customerID, double totalPrice){
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertOrder(): "
                + "Ordered ready to be inserted...");
        
        ResultSet rs = null;
        int orderID = 0;
        
        String sql = "INSERT INTO orders(customer_id,total) VALUES(?,?)";
        
        try(Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1,customerID);
            pstmt.setDouble(2, totalPrice);
            
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1){
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    orderID = rs.getInt(1);
            }
            
        } catch(SQLException e){
            System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                    + e.getMessage());
        } finally {
            try{
                if(rs != null) rs.close();
            } catch(SQLException e){
                System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                        + e.getMessage());
            }
        }
        
        return orderID;
    }
    
    public int insertItem(CartItemBean item, int orderID, int productID, int quantity){
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertItem(): "
                + "Item ready to be inserted in order item list...");
        
        ResultSet rs = null;
        int orderItemID = 0;
        
        String sql = "INSERT INTO orderitem(order_id,product_id,quantity) VALUES(?,?,?)";
        
        try(Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1,orderID);
            pstmt.setInt(2,productID);
            pstmt.setInt(3,quantity);
            
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1){
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    orderItemID = rs.getInt(1);
            }
            
        } catch(SQLException e){
            System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertItem(): "
                    + e.getMessage());
        } finally {
            try{
                if(rs != null) rs.close();
            } catch(SQLException e){
                System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser(): "
                        + e.getMessage());
            }
        }
        
        return orderItemID;
    }
    
    public String insertCart(String username, ArrayList<CartItemBean> cart, double totalPrice)
    {
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertCart(): "
                + "Cart is ready to be inserted...");
        
        MySQLJDBCUpdate updatingObject = MySQLJDBCUpdate.getMySQLJDBCUpdate();
        ArrayList<Integer> productID = new ArrayList<Integer>();
        
        //check stock, update stock, return product ID
        for(int i=0; i<cart.size(); i++)
            productID.add(updatingObject.checkAndUpdateTheStock(cart.get(i)));
        
        MySQLJDBCSelect selectionObject = MySQLJDBCSelect.getMySQLJDBCSelect();
        
        // get user's ID
        int userID =  selectionObject.getUserId(username);
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertCart(): "
                + "user's ID: " + userID);
        
        //insert new entry in customer table
        int customerID = this.insertCustomer(userID);
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertCart(): "
                + "customer's ID: " + customerID);
        
        //insert new entry in orders table
        int orderID = this.insertOrder(customerID, totalPrice);
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertCart(): "
                + "order ID: " + orderID);
        
        //insert new entry in orderitem
        for(int i=0; i<productID.size(); i++)
            this.insertItem(cart.get(i), orderID, productID.get(i), cart.get(i).getQuantity());
        
        return "Order Placed";
    }
    
    public static MySQLJDBCInsert getMySQLJDBCInsert(){
        if(insertionObject == null)
            insertionObject = new MySQLJDBCInsert();
        return insertionObject;
    }
}
