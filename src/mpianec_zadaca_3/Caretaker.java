package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Caretaker {

    private static List<Object> listaObjekata = new ArrayList<>();
    static Originator originator = new Originator();
    static int pohranjivanja = 0;

    public static List<Object> getListaObjekata() {
        return listaObjekata;
    }
    public static int getBrojSpremljenihObjekata() {
        return listaObjekata.size();
    }

    public static List<TjedniPlanComponent> returnMemento(int id) {
        for (Object object : listaObjekata) {
            Memento memento = (Memento) object;
            if (memento.getId() == id) {
                originator.restoreFromMemento(memento);
                return originator.getListaKomponenata();
            }
        }
        return null;
    }

    public static void addMemento(List<TjedniPlanComponent> listaKomponenta) {
        originator.set(listaKomponenta, pohranjivanja);
        listaObjekata.add(originator.saveToMemento());
        pohranjivanja++;
    }

    public static void ispis() {
        System.out.println("Broj pohranjivanja: " + pohranjivanja);
        for (Object object:listaObjekata) {
            Memento memento=(Memento) object;
            System.out.println("Datum pohranjivanja: "+memento.getLocalDateTime());
            System.out.println("Memento ID: "+memento.getId());
        }
    }
    
}
