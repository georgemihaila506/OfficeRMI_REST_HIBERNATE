package Service;

import Domain.Cursa;
import Domain.Rezervare;
import Domain.Users;

import java.rmi.RemoteException;
import java.util.List;

public interface ServiceInterface extends Observable {
    void rezerva(Cursa cursa, Rezervare rezervare) throws ServiceException,RemoteException;
    List<Rezervare> cautaRezervari(Cursa cursa) throws ServiceException,RemoteException;
    List<Cursa> getAllTrips() throws ServiceException,RemoteException;
    void checkUser(Users user) throws ServiceException,RemoteException;
}
