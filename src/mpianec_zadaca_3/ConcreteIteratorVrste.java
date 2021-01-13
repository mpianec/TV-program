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
public class ConcreteIteratorVrste implements IteratorAggregate {

    List<TjedniPlanComponent> listaTPC;
    int brojac;
    int iD;

    public ConcreteIteratorVrste(List<TjedniPlanComponent> listaTPC, int iD) {
listaTPC=new ArrayList<>();
        this.iD = iD;
        for (TjedniPlanComponent tcp : listaTPC) {
            this.listaTPC.add(tcp.kopiraj());
        }
    }

    @Override
    public Iterator getIterator() {
        return new IteratorVrste();
    }

    private class IteratorVrste implements Iterator<TjedniPlanComponent> {

        @Override
        public boolean hasNext() {
            if (listaTPC != null && listaTPC.size() > brojac) {
                return true;
            }
            return false;
        }

        @Override
        public TjedniPlanComponent getNext() {
            if(!hasNext()){
                System.out.println("Pogreška!");
                return null;
            }
            TjedniPlanComponent tjedniPlanComponent = listaTPC.get(0);
            listaTPC.remove(0);
            int brojPrograma = listaTPC.size();
            if (tjedniPlanComponent != null) {
                if (tjedniPlanComponent instanceof ProgramComposite) {
                    ProgramComposite programComposite = (ProgramComposite) tjedniPlanComponent;
                    for (TjedniPlanComponent tcp : ((ProgramComposite) tjedniPlanComponent).getListaDanaUTjednu()) {
                        listaTPC.add(listaTPC.size() - brojPrograma, tcp);
                        if (tcp instanceof DanPrograma) {
                            DanPrograma danPrograma = (DanPrograma) tcp;
                            for (TjedniPlanComponent tcp1 : danPrograma.getListaEmisija()) {
                                if (tcp1 instanceof EmisijaProgram) {
                                    EmisijaProgram programEmisija = (EmisijaProgram) tcp1;
                                    if (programEmisija.getEmisija().getVrstaEmisije().getiD() == iD) {
                                        listaTPC.add(listaTPC.size() - brojPrograma, tcp1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return tjedniPlanComponent;
        }

        @Override
        public void remove(TjedniPlanComponent emisija) {
            listaTPC.remove(emisija);
        }

    }

}
