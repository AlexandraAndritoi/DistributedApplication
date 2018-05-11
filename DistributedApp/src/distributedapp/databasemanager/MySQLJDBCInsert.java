/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.databasemanager;

import distributedapp.servermanager.interfaces.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
    
    public static MySQLJDBCInsert getMySQLJDBCInsert(){
        if(insertionObject == null)
            insertionObject = new MySQLJDBCInsert();
        return insertionObject;
    }
}
