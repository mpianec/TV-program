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
public class ConcreteAggregate implements IteratorAggregate {

    List<TjedniPlanComponent> listaTPC;

    public ConcreteAggregate(List<TjedniPlanComponent> listaTPC) {
        this.listaTPC = listaTPC;
    }

    @Override
    public Iterator getIterator() {
        return new EmisijaIterator();
    }
    private class EmisijaIterator implements Iterator<TjedniPlanComponent> {

        int brojer = 0;


        @Override
        public boolean hasNext() {
            if (listaTPC.isEmpty() || brojer >= listaTPC.size()) {
                return false;
            }
            return true;
        }

        @Override
        public TjedniPlanComponent getNext() {
            if (!hasNext()) {
                return null;
            }
            TjedniPlanComponent output = listaTPC.get(brojer);
            brojer++;
            return output;
        }

        @Override
        public void remove(TjedniPlanComponent planComponent) {
            if (listaTPC.remove(planComponent)) {
                System.out.println("Emisija je izbrisana!");
            } else {
                System.out.println("Pogreška prilikom brisanja emisije!");
            }
        }
    }
}
