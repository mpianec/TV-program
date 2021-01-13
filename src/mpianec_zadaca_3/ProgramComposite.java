/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class ProgramComposite implements TjedniPlanComponent{
    private int iD;
    private List<TjedniPlanComponent> listaDanaUTjednu;
    private TjedniPlanComponent tcp;

    public ProgramComposite() {
        listaDanaUTjednu=new ArrayList<>();
    }
    
    public boolean dodaj(TjedniPlanComponent dan){
        if(listaDanaUTjednu.add(dan))
            return true;
        return false;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public List<TjedniPlanComponent> getListaDanaUTjednu() {
        return listaDanaUTjednu;
    }

    public void setListaDanaUTjednu(List<TjedniPlanComponent> listaDanaUTjednu) {
        this.listaDanaUTjednu = listaDanaUTjednu;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public TjedniPlanComponent getTcp() {
        return tcp;
    }

    public void setTcp(TjedniPlanComponent tcp) {
        this.tcp = tcp;
    }

    @Override
    public TjedniPlanComponent kopiraj() {
        ProgramComposite programComposite = new ProgramComposite();
        programComposite.setiD(this.iD);
        programComposite.setListaDanaUTjednu(this.listaDanaUTjednu);
        programComposite.setTcp(tcp);
        return programComposite;
    }
    
}
