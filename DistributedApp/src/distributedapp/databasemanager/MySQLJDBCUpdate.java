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
public class MySQLJDBCUpdate {
    private static MySQLJDBCUpdate updatingObject = null;
    
    private MySQLJDBCUpdate(){
        
    }
    
    public static MySQLJDBCUpdate getMySQLJDBCUpdate(){
        if(updatingObject == null)
            updatingObject = new MySQLJDBCUpdate();
        return updatingObject;
    }
}
