package mpianec_zadaca_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matija
 */
public class EmisijaProgramDat extends Datoteke {

    private List<EmisijaProgram> listaEmisijaProgram;

    public EmisijaProgramDat(String naziv) {
        super.setNaziv(naziv);
        listaEmisijaProgram = new ArrayList<>();
    }

    @Override
    protected Datoteke ucitaj() {
        List<String[]> listaElemenata = super.citajZapisDatoteke();
        for (String[] elementi : listaElemenata) {
            try {
                if (elementi.length != 4) {
                    throw new Exception();
                }
                EmisijaProgram emisijaProgram = new EmisijaProgram();
                for (Emisija emisija : TVKuca.getInstance().getListaEmisija()) {
                    if (emisija.getiD() == Integer.parseInt(elementi[0].trim())) {
                        emisijaProgram.setEmisija(emisija);
                        break;
                    }
                }
                if (emisijaProgram.getEmisija() == null) {
                    throw new Exception();
                }
                List<OsobeUloge> listaOsobaUloga = new ArrayList<>();
                if (elementi.length == 4 && !elementi[3].trim().isEmpty()) {
                    String[] osobaUloga = elementi[3].split(",");

                    for (String string : osobaUloga) {
                        String[] crticaRascjep = string.split("-");
                        int osoba = Integer.parseInt(crticaRascjep[0].trim());
                        int uloga = Integer.parseInt(crticaRascjep[1].trim());
                        OsobeUloge ou = new OsobeUloge();
                        for (Osoba os : TVKuca.getInstance().getListaOsoba()) {
                            if (os.getiD() == osoba) {
                                ou.setOsoba(os);
                                break;
                            }
                        }
                        for (Uloga ul : TVKuca.getInstance().getListaUloga()) {
                            if (ul.getiD() == uloga) {
                                ou.setUloga(ul);
                                break;
                            }
                        }
                        if (ou.getOsoba() == null || ou.getUloga() == null) {
                            throw new Exception();
                        }
                        listaOsobaUloga.add(ou);
                    }
                }

                listaOsobaUloga.addAll(emisijaProgram.getEmisija().getListaOsobeUloge());
                emisijaProgram.setListaOsobeUloge(listaOsobaUloga);
                if (!elementi[2].isEmpty() && !elementi[2].equals("")) {
                    String[] vrijemePocetak = elementi[2].split(":");
                    if (vrijemePocetak.length == 3) {
                        emisijaProgram.setPocetak(LocalTime.of(Integer.parseInt(vrijemePocetak[0].trim()), Integer.parseInt(vrijemePocetak[1].trim()), Integer.parseInt(vrijemePocetak[2].trim())));
                    } else {
                        emisijaProgram.setPocetak(LocalTime.of(Integer.parseInt(vrijemePocetak[0].trim()), Integer.parseInt(vrijemePocetak[1].trim())));
                    }
                    emisijaProgram.setKraj(emisijaProgram.getPocetak().plusMinutes(emisijaProgram.getEmisija().getTrajanje()));
                }
                if (!elementi[1].isEmpty() && !elementi[1].equals("")) {
                    String[] daniCrtica = elementi[1].split("-");
                    if (daniCrtica.length == 2) {
                        int poc = Integer.parseInt(daniCrtica[0].trim());
                        int kraj = Integer.parseInt(daniCrtica[1].trim());
                        for (int i = poc; i <= kraj; i++) {
                            EmisijaProgram novi = new EmisijaProgram();
                            novi.setDanUTjednu(i);
                            novi.setEmisija(emisijaProgram.getEmisija());
                            novi.setPocetak(emisijaProgram.getPocetak());
                            novi.setKraj(emisijaProgram.getKraj());
                            novi.setListaOsobeUloge(emisijaProgram.getListaOsobeUloge());
                            listaEmisijaProgram.add(novi);
                        }
                    }
                    String[] daniZarez = elementi[1].split(",");
                    if (daniZarez.length >= 2) {
                        for (int i = 0; i < daniZarez.length; i++) {
                            EmisijaProgram novi = new EmisijaProgram();
                            novi.setDanUTjednu(Integer.parseInt(daniZarez[i].trim()));
                            novi.setEmisija(emisijaProgram.getEmisija());
                            novi.setPocetak(emisijaProgram.getPocetak());
                            novi.setKraj(emisijaProgram.getKraj());
                            novi.setListaOsobeUloge(emisijaProgram.getListaOsobeUloge());
                            listaEmisijaProgram.add(novi);
                        }
                    }
                    if (!elementi[1].trim().isEmpty() && daniZarez.length == 1 && daniCrtica.length == 1) {
                        EmisijaProgram novi = new EmisijaProgram();
                        novi.setDanUTjednu(Integer.parseInt(elementi[1].trim()));
                        novi.setEmisija(emisijaProgram.getEmisija());
                        novi.setPocetak(emisijaProgram.getPocetak());
                        novi.setKraj(emisijaProgram.getKraj());
                        novi.setListaOsobeUloge(emisijaProgram.getListaOsobeUloge());
                        listaEmisijaProgram.add(novi);
                    }
                    if (elementi[1].trim().isEmpty()) {
                        EmisijaProgram novi = new EmisijaProgram();
                        novi.setDanUTjednu(0);
                        novi.setEmisija(emisijaProgram.getEmisija());
                        novi.setPocetak(emisijaProgram.getPocetak());
                        novi.setKraj(emisijaProgram.getKraj());
                        novi.setListaOsobeUloge(emisijaProgram.getListaOsobeUloge());
                        listaEmisijaProgram.add(novi);
                    }
                }

            } catch (Exception e) {
                System.err.println(Arrays.toString(elementi) + " je kriv.");
            }
        }

        return this;
    }

    public List<EmisijaProgram> getListaEmisijaProgram() {
        return listaEmisijaProgram;
    }

    public void setListaEmisijaProgram(List<EmisijaProgram> listaEmisijaProgram) {
        this.listaEmisijaProgram = listaEmisijaProgram;
    }

}
