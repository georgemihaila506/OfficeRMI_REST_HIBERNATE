package Repository;

import Domain.Cursa;
import Domain.Rezervare;

import java.util.List;

public interface RepositoryRezervareInterface extends IRepository<Rezervare> {
    void rezerva(int codCursa, Cursa cursa, Rezervare rezervare);
    List<Rezervare> cautaRezervari(int codCursa);
}
