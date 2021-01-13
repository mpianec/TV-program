package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matija
 */
public class Emisija {
    private int iD;
    private String naziv;
    private int trajanje;
    private VrstaEmisije vrstaEmisije; 
    private List<OsobeUloge> listaOsobeUloge;

    public Emisija() {
        listaOsobeUloge=new ArrayList<>();
    }

    
    
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public VrstaEmisije getVrstaEmisije() {
        return vrstaEmisije;
    }

    public void setVrstaEmisije(VrstaEmisije vrstaEmisije) {
        this.vrstaEmisije = vrstaEmisije;
    }

    public List<OsobeUloge> getListaOsobeUloge() {
        return listaOsobeUloge;
    }

    public void setListaOsobeUloge(List<OsobeUloge> listaOsobeUloge) {
        this.listaOsobeUloge = listaOsobeUloge;
    }


}
