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
import java.sql.Statement;

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
/*
        int userId = 0;
        String sql = "INSERT INTO user(username,first_name,last_name,email,password,"
                + "number,adress,country,zipcode,birthdate)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try(Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            
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
*/
    }
    
    public static MySQLJDBCInsert getMySQLJDBCInsert(){
        if(insertionObject == null)
            insertionObject = new MySQLJDBCInsert();
        return insertionObject;
    }
}
