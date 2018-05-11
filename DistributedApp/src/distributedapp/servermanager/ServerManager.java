/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.servermanager;

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
    public void insertUser() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
