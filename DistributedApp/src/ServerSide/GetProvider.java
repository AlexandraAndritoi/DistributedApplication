/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSide;

/**
 *
 * @author Alexandra
 */

import java.rmi.*;

public interface GetProvider extends java.rmi.Remote{
	String getProvider(int commandNo, String destination) throws RemoteException;
	String getState(int commandNo) throws RemoteException;
}
