package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matija
 */
public class EmisijeDat extends Datoteke {

    private final List<Emisija> listaEmisija;

    public EmisijeDat(String naziv) {
        super.setNaziv(naziv);
        listaEmisija = new ArrayList<>();
    }

    @Override
    protected Datoteke ucitaj() {
        List<String[]> listaElemenata = super.citajZapisDatoteke();
        for (String[] elementi : listaElemenata) {
            try{
            Emisija emisija = new Emisija();
            emisija.setiD(Integer.parseInt(elementi[0].trim()));
            emisija.setNaziv(elementi[1].trim());
            for(VrstaEmisije vrstaEmisije:TVKuca.getInstance().getListaVrstaEmisije()){
                if(vrstaEmisije.getiD()==Integer.parseInt(elementi[2])){
                    emisija.setVrstaEmisije(vrstaEmisije);
                    break;
                }
            }
            if(emisija.getVrstaEmisije()==null){
                throw new Exception();
            }
            int zaTrajanje = Integer.parseInt(elementi[3].trim());
            if (zaTrajanje <= 0) {
                System.out.println(Arrays.toString(elementi)+" je kriv.");
                continue;
            }
            emisija.setTrajanje(zaTrajanje);         
            if (elementi.length == 5 && !elementi[4].trim().isEmpty()) {
                String[] osobaUloga=elementi[4].split(",");
                List<OsobeUloge> listaOsobaUloga=new ArrayList<>();              
                for(String string:osobaUloga){
                    String[] crticaRascjep=string.split("-");
                    int osoba=Integer.parseInt(crticaRascjep[0].trim());
                    int uloga=Integer.parseInt(crticaRascjep[1].trim());
                    OsobeUloge ou=new OsobeUloge();
                    for(Osoba os:TVKuca.getInstance().getListaOsoba()){
                        if(os.getiD()==osoba){
                            ou.setOsoba(os);
                            break;
                        }
                    }
                    for(Uloga ul:TVKuca.getInstance().getListaUloga()){
                        if(ul.getiD()==uloga){
                            ou.setUloga(ul);
                            break;
                        }
                    }
                    if(ou.getOsoba()==null || ou.getUloga()==null){
                        throw new Exception();
                    }
                    listaOsobaUloga.add(ou);
               }
                emisija.setListaOsobeUloge(listaOsobaUloga);
            }
            listaEmisija.add(emisija);}
            catch(Exception e){
                System.err.println(Arrays.toString(elementi)+" je kriv.");
            }
        }  
        return this;
    }

    public List<Emisija> getListaEmisija() {
        return listaEmisija;
    }

}
