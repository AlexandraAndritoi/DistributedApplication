/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.servermanager;

import distributedapp.databasemanager.MySQLJDBCInsert;
import distributedapp.servermanager.interfaces.Product;
import distributedapp.servermanager.interfaces.ServerManagerInterface;
import distributedapp.servermanager.interfaces.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Alexandra
 */
public class ServerManager extends UnicastRemoteObject implements ServerManagerInterface {

    @Override
    public void insertUser(User user) throws RemoteException {
        
        System.out.println("distributedapp.servermanager.ServerManager.insertUser() Serializable object was sent!");
        
        MySQLJDBCInsert insertObject = MySQLJDBCInsert.getMySQLJDBCInsert();
        
        if(insertObject != null) System.out.println("distributedapp.servermanager.ServerManager.insertUser() Insertion object is not null!");
        
        insertObject.insertUser(user);
    }

    @Override
    public User getUser(String username) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(String username) throws RemoteException {
        
    }

    @Override
    public Product getProduct() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMessage(String s) throws RemoteException {
        System.out.println("distributedapp.servermanager.ServerManager.sendMessage() " + s);
    }
    
    public ServerManager() throws RemoteException{
        super();
    }
}
