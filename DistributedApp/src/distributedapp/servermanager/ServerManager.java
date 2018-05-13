/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.servermanager;

import distributedapp.databasemanager.MySQLJDBCInsert;
import distributedapp.databasemanager.MySQLJDBCSelect;
import distributedapp.servermanager.interfaces.CartItemBean;
import distributedapp.servermanager.interfaces.ServerManagerInterface;
import distributedapp.servermanager.interfaces.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Alexandra
 */
public class ServerManager extends UnicastRemoteObject 
        implements ServerManagerInterface {

    @Override
    public void insertUser(User user) throws RemoteException {
        
        System.out.println("distributedapp.servermanager.ServerManager.insertUser() "
                + "Serializable object was sent!");
        
        MySQLJDBCInsert insertObject = MySQLJDBCInsert.getMySQLJDBCInsert();
        
        if(insertObject != null) 
            System.out.println("distributedapp.servermanager.ServerManager.insertUser() "
                    + "Insertion object is not null!");
        
        insertObject.insertUser(user);
    }

    @Override
    public ArrayList<String> getUser(String username) throws RemoteException {
        MySQLJDBCSelect selectionObject = MySQLJDBCSelect.getMySQLJDBCSelect();
        
        return selectionObject.selectUser(username);
    }
    
    @Override
    public String getFirstName(String username, String password) throws RemoteException {
        
        MySQLJDBCSelect selectionObject = MySQLJDBCSelect.getMySQLJDBCSelect();
        
        System.out.println("distributedapp.servermanager.ServerManager.getFirstName()"
                + "Request from client received...");
        
        return selectionObject.selectFirstName(username, password);
    }

    @Override
    public String updateUser(User user) throws RemoteException {
        System.out.println("distributedapp.servermanager.ServerManager.updateUser(): "
                + "User data received...");
        System.out.println("distributedapp.servermanager.ServerManager.updateUser(): "
                + user.getFirstName());
        
        return "Updated User";
    }

    @Override
    public void sendCart(String username, ArrayList<CartItemBean> cart, double totalPrice) 
        throws RemoteException {
        System.out.println("distributedapp.servermanager.ServerManager.sendCart(): "
                + "Cart received...");
        System.out.println("distributedapp.servermanager.ServerManager.sendCart(): "
                + cart.get(0).getTitle());
        System.out.println("distributedapp.servermanager.ServerManager.sendCart(): "
                + cart.size());
    }

    @Override
    public void sendMessage(String s) throws RemoteException {
        System.out.println("distributedapp.servermanager.ServerManager.sendMessage() "
                + "Test message from client: " + s);      
    }
    
    public ServerManager() throws RemoteException{
        super();
    }

    
}
