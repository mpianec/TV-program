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
public class KratkometrazneEmisijeHandler implements Handler{
    private Handler handler;

    @Override
    public void calculate(int broj) {
        if(broj<=35){
            System.out.println("Emisija je kratkometražna, traje: "+broj+" minuta");
        }
        else if(handler!=null){
            handler.calculate(broj);
        }
    }
    @Override
    public void setNext(Handler handler) {
        this.handler=handler;
    }
    
}
