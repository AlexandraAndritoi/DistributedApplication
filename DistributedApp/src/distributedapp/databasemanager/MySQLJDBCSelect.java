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
public class MySQLJDBCSelect {
    private static MySQLJDBCSelect selectionObject = null;
    
    private MySQLJDBCSelect(){
        
    }
    
    public String selectFirstName(){
        return "First Name";
    }
    
    public static MySQLJDBCSelect getMySQLJDBCSelect(){
        if(selectionObject == null)
            selectionObject =  new MySQLJDBCSelect();
        return selectionObject;
    }
}
