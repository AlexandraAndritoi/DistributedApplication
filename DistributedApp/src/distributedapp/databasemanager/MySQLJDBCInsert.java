/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.databasemanager;

import distributedapp.servermanager.interfaces.User;

/**
 *
 * @author Alexandra
 */
public class MySQLJDBCInsert {
    private static MySQLJDBCInsert object = null;
    
    private MySQLJDBCInsert(){
        
    }
    
    public void insertUser(User  user){
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser() Serializable object is ready to be inserted...");
        System.out.println("distributedapp.databasemanager.MySQLJDBCInsert.insertUser() " + user.getAddress());
    }
    
    public static MySQLJDBCInsert getMySQLJDBCInsert(){
        if(object == null)
            object = new MySQLJDBCInsert();
        return object;
    }
}
