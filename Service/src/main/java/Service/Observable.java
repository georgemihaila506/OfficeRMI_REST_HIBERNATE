package Service;

import java.rmi.RemoteException;

public interface Observable {

    void addObserver(Observer observer);

    void notifyAllObservers() throws RemoteException;
}
