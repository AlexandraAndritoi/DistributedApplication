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
    
    public void insertUser() throws RemoteException;
    public User getUser(int id) throws RemoteException;
    public void updateUser(int id) throws RemoteException;
    
    public Product getProduct() throws RemoteException;
    
    public void sendMessage(String s) throws RemoteException;
    
}
