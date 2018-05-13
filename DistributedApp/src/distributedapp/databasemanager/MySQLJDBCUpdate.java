/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.databasemanager;

import distributedapp.servermanager.interfaces.CartItemBean;
import distributedapp.servermanager.interfaces.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alexandra
 */
public class MySQLJDBCUpdate {
    private static MySQLJDBCUpdate updatingObject = null;
    
    private MySQLJDBCUpdate(){
        
    }
    
    public String updateUser(User user){
        
        String sql = "UPDATE user "
                + "SET first_name=?, "
                + "last_name=?, "
                + "email=?, "
                + "number=?, "
                + "address=?, "
                + "country=?, "
                + "zipcode=? "
                + "WHERE username=?";
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCUpdate.updateUser(): "
                + sql);
        
        int rowAffected = 0;
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getCountry());
            pstmt.setString(7, user.getZipcode());
            pstmt.setString(8, user.getUsername());

           
            rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
        if(rowAffected == 0) return "Failed to update user";
        else    return "Updated User";
    }
    
    public void updateStock(int productID, int quantity){
        System.out.println("distributedapp.databasemanager.MySQLJDBCUpdate.updateStock(): "
                + "Ready to update the product's stock...");
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCUpdate.updateStock(): "
                + "product ID: " + productID);
        
        String sql = "UPDATE product "
                + "SET stock=? "
                + "WHERE id=?";
        
        System.out.println("distributedapp.databasemanager.MySQLJDBCUpdate.updateStock(): "
                + sql);
        
        int rowAffected = 0;
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            MySQLJDBCSelect selectionObject = MySQLJDBCSelect.getMySQLJDBCSelect();
            int productStock = selectionObject.selectProductStock(productID);
            
            int newProductStock = productStock - quantity;
            
            pstmt.setInt(1, newProductStock);
            pstmt.setInt(2, productID);

           
            rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int checkAndUpdateTheStock(CartItemBean cart){
        System.out.println("distributedapp.databasemanager.MySQLJDBCUpdate.checkAndUpdateTheStock(): "
                + "Product " + cart.getTitle() + " ready to be checked...");
        
        int productID = 0;
        
        MySQLJDBCSelect selectionObject = MySQLJDBCSelect.getMySQLJDBCSelect();
        
        productID = selectionObject.selectProductID(cart.getTitle());
        
        this.updateStock(productID, cart.getQuantity());
        
        return productID;
    }
    
    public static MySQLJDBCUpdate getMySQLJDBCUpdate(){
        if(updatingObject == null)
            updatingObject = new MySQLJDBCUpdate();
        return updatingObject;
    }
}
