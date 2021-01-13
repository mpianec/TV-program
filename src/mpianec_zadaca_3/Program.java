package mpianec_zadaca_3;

import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Program {

    private int iD;
    private String nazivPrograma;
    private LocalTime kraj;
    private LocalTime pocetak;
    private String nazivDatoteke;
    private List<EmisijaProgram> listaEmisijaPrograma;
    
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNazivPrograma() {
        return nazivPrograma;
    }

    public void setNazivPrograma(String nazivPrograma) {
        this.nazivPrograma = nazivPrograma;
    }

    public String getNazivDatoteke() {
        return nazivDatoteke;
    }

    public void setNazivDatoteke(String nazivDatoteke) {
        this.nazivDatoteke = nazivDatoteke;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalTime kraj) {
        this.kraj = kraj;
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalTime pocetak) {
        this.pocetak = pocetak;
    }

    public List<EmisijaProgram> getListaEmisijaPrograma() {
        return listaEmisijaPrograma;
    }

    public void setListaEmisijaPrograma(List<EmisijaProgram> listaEmisijaPrograma) {
        this.listaEmisijaPrograma = listaEmisijaPrograma;
    }

   
}
