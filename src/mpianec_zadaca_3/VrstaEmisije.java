package mpianec_zadaca_3;

/**
 *
 * @author Matija
 */
public class VrstaEmisije {
    private int iD;
    private String naziv;
    private int imaReklame;
    private int maxTrajanjeReklame;

    public VrstaEmisije() {
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

 

    public int getMaxTrajanjeReklame() {
        return maxTrajanjeReklame;
    }

    public void setMaxTrajanjeReklame(int maxTrajanjeReklame) {
        this.maxTrajanjeReklame = maxTrajanjeReklame;
    }

    public int getImaReklame() {
        return imaReklame;
    }

    public void setImaReklame(int imaReklame) {
        this.imaReklame = imaReklame;
    }
    
}
