package mpianec_zadaca_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matija
 */
public abstract class Datoteke {

    private String naziv;
    private List<String[]> listaElemenata;

    protected abstract Datoteke ucitaj();

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    protected List<String[]> citajZapisDatoteke() {
        listaElemenata = new ArrayList<>();
        File file = new File(naziv);
        BufferedReader bufferedReader;
        try {
            String[] elementi;
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.readLine();
            String red;
            while ((red = bufferedReader.readLine()) != null) {
                elementi = red.split("[;]",-1);
                listaElemenata.add(elementi);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datoteke.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Datoteke.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaElemenata;
    }
}
