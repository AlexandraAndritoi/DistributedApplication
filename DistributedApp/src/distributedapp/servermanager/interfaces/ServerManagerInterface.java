/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.servermanager.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Alexandra
 */
public interface ServerManagerInterface extends Remote {
    
    public void insertUser(User user) throws RemoteException;
    
    public ArrayList<String> getUser(String username) throws RemoteException;
    
    public String getFirstName(String username, String password) 
            throws RemoteException;
    
    public String updateUser(User user) throws RemoteException;
    
    public String sendCart(String username, ArrayList<CartItemBean> cart, double totalPrice) throws RemoteException;
    
    public void sendMessage(String s) throws RemoteException;
    
}
