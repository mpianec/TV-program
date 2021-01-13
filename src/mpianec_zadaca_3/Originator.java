
package mpianec_zadaca_3;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Originator {
    private int id;
    private List<TjedniPlanComponent> listaKomponenata;
    private LocalDateTime localDateTime;
    
    public void set(List<TjedniPlanComponent> listaKomponenata, int id){
        this.listaKomponenata=listaKomponenata;
        this.id=id;
    }
    public Memento saveToMemento(){
        return new Memento(listaKomponenata, this.id, LocalDateTime.now());
    }
    public void restoreFromMemento(Memento memento){
        this.listaKomponenata=memento.getListaKomponenata();
        this.id=memento.getId();
        this.localDateTime=memento.getLocalDateTime();
    }

    public List<TjedniPlanComponent> getListaKomponenata() {
        return listaKomponenata;
    }
    
}
