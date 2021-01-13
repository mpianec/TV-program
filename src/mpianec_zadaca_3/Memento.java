package mpianec_zadaca_3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Memento {

    private int id;
    private LocalDateTime localDateTime;
    private List<TjedniPlanComponent> listaKomponenata = new ArrayList();

    public Memento(List<TjedniPlanComponent> listaKomponenata, int id, LocalDateTime localDateTime) {
        IteratorAggregate iteratorAggregate = new ConcreteAggregate(listaKomponenata);
        for (Iterator<TjedniPlanComponent> iteratorPrograma = iteratorAggregate.getIterator(); iteratorPrograma.hasNext();) {
            TjedniPlanComponent tpc1 = iteratorPrograma.getNext();
            ProgramComposite pc1 = (ProgramComposite) tpc1;
            ProgramComposite pc2 = new ProgramComposite();
            pc2.setiD(pc1.getiD());
            iteratorAggregate = new ConcreteAggregate(pc1.getListaDanaUTjednu());
            for (Iterator<TjedniPlanComponent> iteratorDana = iteratorAggregate.getIterator(); iteratorDana.hasNext();) {
                TjedniPlanComponent tpc2 = iteratorDana.getNext();
                DanPrograma danProgram1 = (DanPrograma) tpc2;
                DanPrograma danProgram2 = new DanPrograma();
                danProgram2.setiD(danProgram1.getiD());
                danProgram2.setKraj(danProgram1.getKraj());
                danProgram2.setPocetak(danProgram1.getPocetak());
                iteratorAggregate = new ConcreteAggregate(danProgram1.getListaEmisija());
                for (Iterator<TjedniPlanComponent> iteratorEmisija = iteratorAggregate.getIterator(); iteratorEmisija.hasNext();) {
                    TjedniPlanComponent tpc3 = iteratorEmisija.getNext();
                    EmisijaProgram ep1 = (EmisijaProgram) tpc3;
                    EmisijaProgram ep2 = ep1.kopiraj();
                    danProgram2.dodaj2(ep2);

                }
                pc2.dodaj(danProgram2);
            }
            this.listaKomponenata.add(pc2);
        }
        this.id = id;
        this.localDateTime = localDateTime;

    }

    public int getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public List<TjedniPlanComponent> getListaKomponenata() {
        return listaKomponenata;
    }

}
