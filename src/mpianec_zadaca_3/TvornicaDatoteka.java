package mpianec_zadaca_3;

/**
 *
 * @author Matija
 */
public class TvornicaDatoteka implements TvornicaInterface{
    public Datoteke stvori(String naziv, String vrsta){
        switch(vrsta){
            case "u":
                return new UlogeDat(naziv);
            case "e":
                return new EmisijeDat(naziv);
            case "o":
                return new OsobeDat(naziv);
            case "t":
                TVKuca.getInstance().setNaziv(naziv);
                return new ProgramDat(naziv);
            case "v":
                return new VrstaEmisijeDat(naziv);
            case "p":
                return new EmisijaProgramDat(naziv);
            default:
                return null;
        }
    }


}
