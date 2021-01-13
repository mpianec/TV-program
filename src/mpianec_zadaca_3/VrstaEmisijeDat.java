package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class VrstaEmisijeDat extends Datoteke {

    private final List<VrstaEmisije> listaVrsteEmisija;

    public VrstaEmisijeDat(String naziv) {
        super.setNaziv(naziv);
        listaVrsteEmisija = new ArrayList<>();
    }

    @Override
    protected VrstaEmisijeDat ucitaj() {
        List<String[]> listaElemenata = super.citajZapisDatoteke();
        for (String[] elementi : listaElemenata) {
            VrstaEmisije vrstaEmisije = new VrstaEmisije();
            vrstaEmisije.setiD(Integer.parseInt(elementi[0].trim()));
            vrstaEmisije.setNaziv(elementi[1].trim());
            vrstaEmisije.setImaReklame(Integer.parseInt(elementi[2].trim()));
            vrstaEmisije.setMaxTrajanjeReklame(Integer.parseInt(elementi[3].trim()));
            listaVrsteEmisija.add(vrstaEmisije);
        }
      
        return this;
    }

    public List<VrstaEmisije> getListaVrsteEmisija() {
        return listaVrsteEmisija;
    }

}
