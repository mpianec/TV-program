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
public class Decorator implements Ispis{
    
    protected Ispis formatiraniIspis;
    
    @Override
    public String uredi() {
       return "";
    }
    
    public Decorator(Ispis formatiraniIspis){
        this.formatiraniIspis=formatiraniIspis;
    }
}
