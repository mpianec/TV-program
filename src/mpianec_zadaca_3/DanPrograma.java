/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpianec_zadaca_3;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class DanPrograma implements TjedniPlanComponent {

    private int iD;
    private List<TjedniPlanComponent> listaEmisija;
    private LocalTime pocetak;
    private LocalTime kraj;
    private TjedniPlanComponent tcp;

    public boolean dodaj(List<TjedniPlanComponent> emisije) {
        for (TjedniPlanComponent emisija : emisije) {
            if (emisija instanceof EmisijaProgram) {
                EmisijaProgram ep = (EmisijaProgram) emisija;
                if (ep.getKraj() != null && ep.getPocetak() != null
                        && !ep.getKraj().isAfter(kraj)
                        && !ep.getPocetak().isBefore(pocetak)
                        && !ep.getPocetak().isAfter(ep.getKraj())
                        && ep.getDanUTjednu() == iD) {
                    if (listaEmisija.isEmpty()) {
                        listaEmisija.add(emisija);
                    } else {
                        boolean kriviZapis = false;
                        for (TjedniPlanComponent em : listaEmisija) {
                            EmisijaProgram eprog = (EmisijaProgram) em;
                            if (eprog.getPocetak().isBefore(ep.getKraj())
                                    && eprog.getKraj().isAfter(ep.getPocetak())) {
                                kriviZapis = true;
                            }
                        }
                        if (!kriviZapis) {
                            listaEmisija.add(emisija);
                        }
                    }
                }
            }
        }
        sort();
        for (TjedniPlanComponent emisija : emisije) {
            if (emisija instanceof EmisijaProgram) {
                EmisijaProgram ep = (EmisijaProgram) emisija;
                if (ep.getDanUTjednu() == iD && ep.getPocetak() == null) {
                    if (listaEmisija.isEmpty()) {
                        ep.setPocetak(pocetak);
                        ep.setKraj(ep.getPocetak().plusMinutes(ep.getEmisija().getTrajanje()));
                        listaEmisija.add(emisija);
                    } else {
                        EmisijaProgram zaListu = (EmisijaProgram) listaEmisija.get(0);
                        long minuteDoPrveEmisije = Duration.between(this.pocetak, zaListu.getPocetak()).toMinutes();
                        if (minuteDoPrveEmisije > ep.getEmisija().getTrajanje()) {
                            ep.setPocetak(pocetak);
                            ep.setKraj(pocetak.plusMinutes(ep.getEmisija().getTrajanje()));
                            listaEmisija.add(emisija);
                            sort();
                        } else {
                            for (int i = 0; i < listaEmisija.size() - 1; i++) {
                                EmisijaProgram prosla = (EmisijaProgram) listaEmisija.get(i);
                                EmisijaProgram iduca = (EmisijaProgram) listaEmisija.get(i + 1);
                                LocalTime krajProsle = prosla.getKraj();
                                LocalTime pocetakIduce = iduca.getPocetak();
                                minuteDoPrveEmisije = Duration.between(krajProsle, pocetakIduce).toMinutes();
                                if (ep.getEmisija().getTrajanje() <= minuteDoPrveEmisije) {
                                    ep.setPocetak(krajProsle);
                                    ep.setKraj(krajProsle.plusMinutes(ep.getEmisija().getTrajanje()));
                                    listaEmisija.add(emisija);
                                    sort();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        sort();
        for (TjedniPlanComponent emisija : emisije) {
            if (emisija instanceof EmisijaProgram) {
                EmisijaProgram ep = (EmisijaProgram) emisija;
                if (ep.getDanUTjednu() == 0 && ep.getPocetak() == null) {
                    if (listaEmisija.isEmpty()) {
                        ep.setPocetak(pocetak);
                        ep.setKraj(ep.getPocetak().plusMinutes(ep.getEmisija().getTrajanje()));
                        ep.setDanUTjednu(this.iD);
                        listaEmisija.add(emisija);
                    } else {
                        EmisijaProgram zaListu = (EmisijaProgram) listaEmisija.get(0);
                        long minuteDoPrveEmisije = Duration.between(this.pocetak, zaListu.getPocetak()).toMinutes();
                        if (minuteDoPrveEmisije > ep.getEmisija().getTrajanje()) {
                            ep.setPocetak(pocetak);
                            ep.setKraj(pocetak.plusMinutes(ep.getEmisija().getTrajanje()));
                            ep.setDanUTjednu(this.iD);
                            listaEmisija.add(emisija);
                            sort();
                        } else {
                            for (int i = 0; i < listaEmisija.size() - 1; i++) {
                                EmisijaProgram prosla = (EmisijaProgram) listaEmisija.get(i);
                                EmisijaProgram iduca = (EmisijaProgram) listaEmisija.get(i + 1);
                                LocalTime krajProsle = prosla.getKraj();
                                LocalTime pocetakIduce = iduca.getPocetak();
                                minuteDoPrveEmisije = Duration.between(krajProsle, pocetakIduce).toMinutes();
                                if (ep.getEmisija().getTrajanje() <= minuteDoPrveEmisije) {
                                    ep.setPocetak(krajProsle);
                                    ep.setKraj(krajProsle.plusMinutes(ep.getEmisija().getTrajanje()));
                                    ep.setDanUTjednu(this.iD);
                                    listaEmisija.add(emisija);
                                    sort();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void sort() {
        for (int i = 0; i < listaEmisija.size(); i++) {
            for (int j = i + 1; j < listaEmisija.size(); j++) {
                EmisijaProgram prvi = (EmisijaProgram) listaEmisija.get(i);
                EmisijaProgram drugi = (EmisijaProgram) listaEmisija.get(j);

                if (prvi.getPocetak().isAfter(drugi.getPocetak())) {
                    listaEmisija.set(i, drugi);
                    listaEmisija.set(j, prvi);
                }
            }
        }
    }

    public DanPrograma() {
        listaEmisija = new ArrayList<>();
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public List<TjedniPlanComponent> getListaEmisija() {
        return listaEmisija;
    }

    public void setListaEmisija(List<TjedniPlanComponent> listaEmisija) {
        this.listaEmisija = listaEmisija;
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

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public TjedniPlanComponent kopiraj() {
        DanPrograma novi = new DanPrograma();
        novi.setiD(this.iD);
        novi.setListaEmisija(this.listaEmisija);
        novi.setKraj(this.kraj);
        novi.setPocetak(this.pocetak);
        novi.setTcp(tcp);
        return novi;
    }

    public TjedniPlanComponent getTcp() {
        return tcp;
    }

    public void setTcp(TjedniPlanComponent tcp) {
        this.tcp = tcp;
    }
    public boolean dodaj2(TjedniPlanComponent tpc) {
        if (listaEmisija.add(tpc)) {
            return true;
        }
        return false;
    }

}
