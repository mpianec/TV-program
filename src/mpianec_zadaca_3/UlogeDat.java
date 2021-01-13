/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpianec_zadaca_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matija
 */
public class UlogeDat extends Datoteke{
    private final List<Uloga> listaUloga;
    
    public UlogeDat(String naziv){
        super.setNaziv(naziv);
        listaUloga=new ArrayList<>();
    }
    
    @Override
    protected Datoteke ucitaj() {
        List<String[]> listaElemenata=super.citajZapisDatoteke();
        for(String[] elementi:listaElemenata){
            try{
            Uloga uloga=new Uloga();
            uloga.setiD(Integer.parseInt(elementi[0].trim()));
            uloga.setOpis(elementi[1].trim());
            listaUloga.add(uloga);}catch(Exception e){
                System.err.println(Arrays.toString(elementi)+" je kriv.");
            }
        }
       
        return this;
    }

    public List<Uloga> getListaUloga() {
        return listaUloga;
    }
    
}
