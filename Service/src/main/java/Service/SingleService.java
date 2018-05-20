package Service;

import Domain.Cursa;
import Domain.Rezervare;
import Domain.Users;
import Repository.RepoUser;
import Repository.RepositoryCursa;
import Repository.RepositoryRezervare;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class SingleService implements ServiceInterface {
    private RepositoryRezervare repoRezervare;
    private RepositoryCursa repoCursa;
    private RepoUser repoUser;
    private List<Observer> observers=new ArrayList<>();
    public SingleService(RepositoryCursa repoCursa, RepositoryRezervare repoRezervare, RepoUser repoUser)
    {
        this.repoCursa=repoCursa;
        this.repoRezervare=repoRezervare;
        this.repoUser=repoUser;
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
                x.update((ServiceInterface) this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    public  void rezerva(Cursa cursa, Rezervare rezervare) throws ServiceException,RemoteException
    {
        int codCursa=repoCursa.cautaCursa(cursa);
        int nrLocuriDisponibile=repoCursa.getNrLocuriDisponibile(codCursa);
        if(nrLocuriDisponibile>=rezervare.getNrLocuri()) {
            repoRezervare.rezerva(codCursa,cursa,rezervare);
            repoCursa.updateNrLocuri(rezervare.getNrLocuri(),codCursa);

        }
        notifyAllObservers();
    }
    public  List<Rezervare> cautaRezervari(Cursa cursa) throws ServiceException,RemoteException
    {
        return repoRezervare.cautaRezervari(repoCursa.cautaCursa(cursa));
    }
    public  List<Cursa> getAllTrips()throws ServiceException,RemoteException
    {
        return repoCursa.getAll();
    }
    public  void checkUser(Users user)throws ServiceException,RemoteException {

        if(repoUser.checkUser(user)==false)
            throw new ServiceException("Date incorecte!");
    }
}
