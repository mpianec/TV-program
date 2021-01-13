package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class ConcreteBuilder {

    Plan plan;
    
    public ConcreteBuilder(Plan plan) {
        this.plan=plan;
    }
    
    public List<EmisijaProgram> puni(){
        List<EmisijaProgram> listaEmisija=new ArrayList<>();
        
        return listaEmisija;
    }
    
}
