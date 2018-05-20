package Repository;

import Domain.Cursa;

public interface RepositoryCursaInterface extends IRepository<Cursa> {
    int cautaCursa(Cursa cursa);
    void updateNrLocuri(int nrLocuri, int codCursa);
    int getNrLocuriDisponibile(int codCursa);
}
