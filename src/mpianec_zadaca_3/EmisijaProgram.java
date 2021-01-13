/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpianec_zadaca_3;

import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Matija
 */
public class EmisijaProgram implements TjedniPlanComponent {

    private int iD;
    private Emisija emisija;
    private int danUTjednu;
    private LocalTime pocetak;
    private LocalTime kraj;
    private List<OsobeUloge> listaOsobeUloge;
    private TjedniPlanComponent tcp;

    public Emisija getEmisija() {
        return emisija;
    }

    public void setEmisija(Emisija emisija) {
        this.emisija = emisija;
    }

    public int getDanUTjednu() {
        return danUTjednu;
    }

    public void setDanUTjednu(int danUTjednu) {
        this.danUTjednu = danUTjednu;
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalTime kraj) {
        this.kraj = kraj;
    }

    public List<OsobeUloge> getListaOsobeUloge() {
        return listaOsobeUloge;
    }

    public void setListaOsobeUloge(List<OsobeUloge> listaOsobeUloge) {
        this.listaOsobeUloge = listaOsobeUloge;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public EmisijaProgram kopiraj() {
        EmisijaProgram emisijaProgram=new EmisijaProgram(iD, emisija, danUTjednu, pocetak, kraj, listaOsobeUloge);
        emisijaProgram.setTcp(tcp);
        return emisijaProgram;
    }

    public EmisijaProgram(int iD, Emisija emisija, int danUTjednu, LocalTime pocetak, LocalTime kraj, List<OsobeUloge> listaOsobeUloge) {
        this.iD = iD;
        this.emisija = emisija;
        this.danUTjednu = danUTjednu;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.listaOsobeUloge = listaOsobeUloge;
    }

    public EmisijaProgram() {
    }

    public TjedniPlanComponent getTcp() {
        return tcp;
    }

    public void setTcp(TjedniPlanComponent tcp) {
        this.tcp = tcp;
    }
    
}
