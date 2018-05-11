/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp;

import distributedapp.databasemanager.MySQLJDBCUtil;
import distributedapp.servermanager.ServerManager;
import distributedapp.servermanager.interfaces.ServerManagerInterface;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexandra
 */
public class DistributedApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.setProperty("java.security.policy",
                "D:\\An 3\\PAD\\DistributedApplication\\"
                        + "DistributedApp\\src\\distributedapp\\java.policy");
        System.setProperty("java.rmi.server.hostname","10.20.0.137");
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
               Statement stmt = conn.createStatement()) {
            
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(System.getSecurityManager() == null)
        {
            System.setSecurityManager(new RMISecurityManager());
        }
        try{
            ServerManagerInterface server = new ServerManager();
            
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
	    registry.bind("ServerManagerInterface", server);
            //Naming.rebind("//localhost/ServerManagerInterface", server);
            
            System.out.println("distributedapp.DistributedApp.main() "
                    + "Server is ready to listen...");
            
        }catch(Exception e){
            System.err.println("Server Manager Error: " + e.getMessage());
        }
    }
}
