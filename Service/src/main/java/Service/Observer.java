package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {

     void update(ServiceInterface observer) throws RemoteException;
}
