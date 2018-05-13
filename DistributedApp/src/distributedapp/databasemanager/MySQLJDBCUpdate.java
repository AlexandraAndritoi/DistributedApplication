/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.databasemanager;

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
                + "SET first_name = ?, "
                + "last_name = ?, "
                + "email = ?, "
                + "password = ?, "
                + "number = ?, "
                + "address = ?, "
                + "country = ?, "
                + "zipcode = ? "
                + "WHERE username = ?";
        
        int rowAffected = 0;
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getAddress());
            pstmt.setString(7, user.getCountry());
            pstmt.setString(8, user.getZipcode());
           
            rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
        if(rowAffected == 0) return "Failed to update user";
        else    return "User updated";
    }
    
    public static MySQLJDBCUpdate getMySQLJDBCUpdate(){
        if(updatingObject == null)
            updatingObject = new MySQLJDBCUpdate();
        return updatingObject;
    }
}
