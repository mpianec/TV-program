/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpianec_zadaca_3;

import java.util.List;

/**
 *
 * @author Matija
 */
public class ConcreteIteratorEmisije implements Iterator<TjedniPlanComponent>{
    List<TjedniPlanComponent> listaTPC;
    int brojac;

    public ConcreteIteratorEmisije(List<TjedniPlanComponent> listaTPC) {
        this.listaTPC = listaTPC;
        brojac=0;
    }

    @Override
    public boolean hasNext() {
         if(listaTPC!=null && listaTPC.size()>brojac){
             return true;
         }
         return false;
    }

    @Override
    public TjedniPlanComponent getNext() {
        TjedniPlanComponent tpc=listaTPC.get(brojac);
        brojac++;
        return tpc;
    }

    @Override
    public void remove(TjedniPlanComponent emisija) {
        if(listaTPC.remove(emisija)){
            
        }else{
            
        }
        
    }

    
}
