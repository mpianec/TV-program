package mpianec_zadaca_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class TVKuca {

    private String naziv;
    private static TVKuca tvKuca = null;
    private static List<Program> listaPrograma;
    private static List<Osoba> listaOsoba;
    private static List<Uloga> listaUloga;
    private static List<Emisija> listaEmisija;
    private static List<VrstaEmisije> listaVrstaEmisije;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public static TVKuca getInstance() {
        if (tvKuca == null) {
            tvKuca = new TVKuca();
            listaPrograma = new ArrayList<>();
            listaOsoba = new ArrayList<>();
            listaUloga = new ArrayList<>();
            listaEmisija = new ArrayList<>();
            listaVrstaEmisije = new ArrayList<>();
        }
        return tvKuca;
    }

    public  List<Program> getListaPrograma() {
        return listaPrograma;
    }

    public  void setListaPrograma(List<Program> aListaPrograma) {
        listaPrograma = aListaPrograma;
    }

    public List<Osoba> getListaOsoba() {
        return listaOsoba;
    }

    public void setListaOsoba(List<Osoba> listaOsoba) {
        this.listaOsoba = listaOsoba;
    }

    public List<Uloga> getListaUloga() {
        return listaUloga;
    }

    public void setListaUloga(List<Uloga> listaUloga) {
        this.listaUloga = listaUloga;
    }

    public List<Emisija> getListaEmisija() {
        return listaEmisija;
    }

    public void setListaEmisija(List<Emisija> listaEmisija) {
        this.listaEmisija = listaEmisija;
    }

    public List<VrstaEmisije> getListaVrstaEmisije() {
        return listaVrstaEmisije;
    }

    public void setListaVrstaEmisije(List<VrstaEmisije> listaVrstaEmisije) {
        this.listaVrstaEmisije = listaVrstaEmisije;
    }
}
