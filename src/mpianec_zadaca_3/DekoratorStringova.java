/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpianec_zadaca_3;

/**
 *
 * @author Matija
 */
public class DekoratorStringova extends Decorator{
    public DekoratorStringova(Ispis formatiraniIspis) {
        super(formatiraniIspis);
    }
    public String uredi() {
       return formatiraniIspis.uredi()+" %-25s";
    } 
}
