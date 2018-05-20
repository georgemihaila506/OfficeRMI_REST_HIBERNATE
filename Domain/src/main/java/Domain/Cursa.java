package Domain;
import java.io.Serializable;

public class Cursa implements Serializable {
    private String destinatie;
    private String data;
    private String ora;
    private int nrLocuri;
    public Cursa()
    {

    }
    public Cursa(String destinatie, String data, String ora,int nrLocuri) {
        this.destinatie = destinatie;
        this.data = data;
        this.ora = ora;
        this.nrLocuri=nrLocuri;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "destinatie='" + destinatie + '\'' +
                ", data='" + data + '\'' +
                ", ora='" + ora + '\'' +
                ", nrLocuri=" + nrLocuri +
                '}';
    }
}
