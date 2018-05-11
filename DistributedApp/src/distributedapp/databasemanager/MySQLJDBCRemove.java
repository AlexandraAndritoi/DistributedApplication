/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.databasemanager;

/**
 *
 * @author Alexandra
 */
public class MySQLJDBCRemove {
    private static MySQLJDBCRemove removingObject = null;
    
    private MySQLJDBCRemove(){
        
    }
    
    public static MySQLJDBCRemove getMySQLJDBCRemove(){
        if(removingObject == null)
            removingObject = new MySQLJDBCRemove();
        return removingObject;
    }
}
