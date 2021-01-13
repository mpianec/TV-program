package mpianec_zadaca_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matija
 */
public class ProgramDat extends Datoteke {

    private List<Program> listaPrograma;

    ProgramDat(String naziv) {
        super.setNaziv(naziv);
        listaPrograma = new ArrayList<>();

    }

    @Override
    protected Datoteke ucitaj() {
        List<String[]> listaElemenata = super.citajZapisDatoteke();
        for (String[] elementi : listaElemenata) {
            try {
                Program program = new Program();
                program.setiD(Integer.parseInt(elementi[0]));
                program.setNazivPrograma(elementi[1]);
                String[] vrijemePocetak = elementi[2].split(":");
                if (vrijemePocetak.length == 3) {
                    program.setPocetak(LocalTime.of(Integer.parseInt(vrijemePocetak[0].trim()), Integer.parseInt(vrijemePocetak[1].trim()), Integer.parseInt(vrijemePocetak[2].trim())));
                } else {
                    program.setPocetak(LocalTime.of(Integer.parseInt(vrijemePocetak[0].trim()), Integer.parseInt(vrijemePocetak[1].trim())));
                }
                if (elementi[3].contains("")) {
                    program.setKraj(LocalTime.parse("23:59"));
                } else {
                    String[] vrijemeKraj = elementi[3].split(":");
                    if (vrijemeKraj.length == 3) {
                        program.setKraj(LocalTime.of(Integer.parseInt(vrijemeKraj[0].trim()), Integer.parseInt(vrijemeKraj[1].trim()), Integer.parseInt(vrijemeKraj[2].trim())));
                    } else {
                        program.setKraj(LocalTime.of(Integer.parseInt(vrijemeKraj[0].trim()), Integer.parseInt(vrijemeKraj[1].trim())));
                    }
                }

                program.setNazivDatoteke(elementi[4]);
                listaPrograma.add(program);

            } catch (Exception e) {
                System.err.println(Arrays.toString(elementi) + " je kriv.");
            }
        }

        return this;
    }

    public List<Program> getListaPrograma() {
        return listaPrograma;
    }

}
