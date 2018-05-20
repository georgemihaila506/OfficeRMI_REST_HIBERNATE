package Domain;

import java.io.Serializable;

public class Rezervare implements Serializable {
    private String nume;
    private int nrLocuri;

    public Rezervare(String nume, int nrLocuri) {
        this.nume = nume;
        this.nrLocuri = nrLocuri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        return "Rezervare{" +
                "nume='" + nume + '\'' +
                ", nrLocuri=" + nrLocuri +
                '}';
    }
}
