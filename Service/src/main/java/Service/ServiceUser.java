package Service;

import Domain.Cursa;
import Domain.Rezervare;
import Domain.Users;
import Repository.RepoUserInterface;

import java.rmi.RemoteException;
import java.util.List;

public class ServiceUser implements ServiceInterface {
    RepoUserInterface repoUserInterface;
    public ServiceUser(RepoUserInterface repoUserInterface)
    {
        this.repoUserInterface=repoUserInterface;
    }

    @Override
    public synchronized void rezerva(Cursa cursa, Rezervare rezervare) throws ServiceException,RemoteException {

    }

    @Override
    public  synchronized List<Rezervare> cautaRezervari(Cursa cursa)throws ServiceException,RemoteException {
        return null;
    }

    @Override
    public synchronized List<Cursa> getAllTrips()throws ServiceException,RemoteException {
        return null;
    }

    public synchronized void checkUser(Users user)throws ServiceException,RemoteException {

        if(repoUserInterface.checkUser(user)==false)
            throw new ServiceException("Date incorecte!");
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void notifyAllObservers() {

    }
}
