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
public class Plan {
    private List<Integer> daniUTjednu;
    private int trajanje;
    private int iDProgram;
    private LocalTime pocetak;
    private LocalTime kraj;

    public List<Integer> getDaniUTjednu() {
        return daniUTjednu;
    }

    public void setDaniUTjednu(List<Integer> daniUTjednu) {
        this.daniUTjednu = daniUTjednu;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getiDProgram() {
        return iDProgram;
    }

    public void setiDProgram(int iDProgram) {
        this.iDProgram = iDProgram;
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
    
}
