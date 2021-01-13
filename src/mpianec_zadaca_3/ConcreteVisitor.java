package mpianec_zadaca_3;

public class ConcreteVisitor implements Visitor {

    @Override
    public int visit(EmisijaProgram emisija) {
        return emisija.getEmisija().getVrstaEmisije().getMaxTrajanjeReklame();
    }

    @Override
    public int visit(DanPrograma dan) {
        return 0;
    }

    @Override
    public int visit(ProgramComposite program) {
        return 0;
    }

    @Override
    public int visitComposite(Collection collection) {
        int zbroj=0;
        if (collection.getTpc() instanceof DanPrograma) {
            DanPrograma dan = (DanPrograma) collection.getTpc();
            for (TjedniPlanComponent tpc : dan.getListaEmisija()) {
                zbroj+=tpc.accept(this);
            }
        }
        return zbroj;
    }

}
