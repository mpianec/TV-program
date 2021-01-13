package mpianec_zadaca_3;

public interface Visitor {

    int visit(EmisijaProgram emisija);

    int visit(DanPrograma dan);

    int visit(ProgramComposite program);
    int visitComposite(Collection collection);
}
