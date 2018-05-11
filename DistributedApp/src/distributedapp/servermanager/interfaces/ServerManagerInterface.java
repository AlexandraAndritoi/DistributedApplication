/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.servermanager.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Alexandra
 */
public interface ServerManagerInterface extends Remote {
    
    public void insertUser(User user) throws RemoteException;
    
    public User getUser(String username) throws RemoteException;
    
    public String getFirstName(String username, String password) 
            throws RemoteException;
    
    public void updateUser(String username) throws RemoteException;
    
    public Product getProduct() throws RemoteException;
    
    public void sendMessage(String s) throws RemoteException;
    
}
