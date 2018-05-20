package Service;

import Domain.Cursa;
import Domain.Rezervare;
import Domain.Users;
import Repository.RepositoryCursaInterface;
import Repository.RepositoryRezervareInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ServiceOffice implements ServiceInterface {

    private RepositoryCursaInterface repoCursa;

    private RepositoryRezervareInterface repoRezervare;

    List<Observer> observers=new ArrayList<>();

    public ServiceOffice(RepositoryCursaInterface repoCursa, RepositoryRezervareInterface repoRezervare)
    {
        this.repoCursa=repoCursa;
        this.repoRezervare=repoRezervare;
    }

    @Override
    public void addObserver(Observer observer) {

        System.out.println(observer);
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() throws RemoteException {

        observers.forEach(x-> {
            try {
                x.update(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    public synchronized void rezerva(Cursa cursa, Rezervare rezervare) throws ServiceException,RemoteException
    {
        int codCursa=repoCursa.cautaCursa(cursa);
        int nrLocuriDisponibile=repoCursa.getNrLocuriDisponibile(codCursa);
        if(nrLocuriDisponibile>=rezervare.getNrLocuri()) {
            repoRezervare.rezerva(codCursa,cursa,rezervare);
            repoCursa.updateNrLocuri(rezervare.getNrLocuri(),codCursa);

        }
        notifyAllObservers();
    }
    public synchronized List<Rezervare> cautaRezervari(Cursa cursa) throws ServiceException,RemoteException
    {
        return repoRezervare.cautaRezervari(repoCursa.cautaCursa(cursa));
    }
    public synchronized List<Cursa> getAllTrips()throws ServiceException,RemoteException
    {
        return repoCursa.getAll();
    }

    @Override
    public synchronized void checkUser(Users user)throws ServiceException,RemoteException{
    }

}
