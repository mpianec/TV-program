package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matija
 */
public class OsobeDat extends Datoteke {

    private List<Osoba> listaOsoba;

    public OsobeDat(String naziv) {
        super.setNaziv(naziv);
        listaOsoba = new ArrayList<>();
    }

    @Override
    protected Datoteke ucitaj() {
        List<String[]> listaElemenata = super.citajZapisDatoteke();
        for (String[] elementi : listaElemenata) {
            try {
                Osoba osoba = new Osoba();
                osoba.setiD(Integer.parseInt(elementi[0].trim()));
                osoba.setImePrezime(elementi[1].trim());
                listaOsoba.add(osoba);
            } catch (Exception e) {
                System.err.println(Arrays.toString(elementi) + " je kriv.");
            }
        }

        return this;
    }

    public List<Osoba> getListaOsoba() {
        return listaOsoba;
    }

}
