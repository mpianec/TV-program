/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpianec_zadaca_3;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Matija
 */
public class KonstrukcijaIspisa {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void Zaglavlje() {
        System.out.println("----------------------------------");
        Ispis zaglavljeFormat = new DekoratorStringova(new DekoratorStringova(new DekoratorStringova(
                new DekoratorStringova(new DekoratorStringova(new IspisString())))));
        String s = String.format(zaglavljeFormat.uredi().toString(), "Pocetak", "Zavrsetak", "Trajanje u min", "Naziv emsije", "Ime sudionika", "Uloga sudionika");
        System.out.println(s);
    }

    public static void ZaglavljeReklame() {
        System.out.println("----------------------------------");
        Ispis zaglavljeFormat = new DekoratorStringova(new DekoratorStringova(new DekoratorStringova(
                new DekoratorStringova(new DekoratorStringova(new IspisString())))));
        String s = String.format(zaglavljeFormat.uredi().toString(), "Pocetak", "Zavrsetak", "Trajanje u min", "Naziv emsije", "", "Reklame");
        System.out.println(s);
    }

    public static void ZaglavljeVrsta() {
        System.out.println("----------------------------------");
        Ispis zaglavljeFormat = new DekoratorStringova(new IspisString());
        String s = String.format(zaglavljeFormat.uredi().toString(), "Naziv emsije", "Redni broj dana u tjednu");
        System.out.println(s);
    }

    public static void Prikazi(EmisijaProgram ep) {
        Ispis emisijaFormat = new DekoratorStringova(new DekoratorStringova(new DekoratorStringova(
                new DekoratorCijelihBrojeva(new DekoratorStringova(new IspisString())))));
        String emisijaString = String.format(emisijaFormat.uredi().toString(),
                ep.getPocetak().format(formatter),
                ep.getKraj().format(formatter),
                ep.getEmisija().getTrajanje(), ep.getEmisija().getNaziv(), "", "");
        System.out.println(emisijaString);
        Ispis sudionikFormat = new DekoratorStringova(new DekoratorStringova(new DekoratorStringova(
                new DekoratorStringova(new DekoratorStringova(new IspisString())))));
        for (OsobeUloge sudionik : ep.getListaOsobeUloge()) {
            String sudionikString = String.format(sudionikFormat.uredi().toString(),
                    "", "", "", "", sudionik.getOsoba().getImePrezime(), sudionik.getUloga().getOpis());
            System.out.println(sudionikString);
        }
    }

    public static void PrikaziReklame(EmisijaProgram ep, int reklame) {
        Ispis emisijaFormat = new DekoratorStringova(new DekoratorStringova(new DekoratorStringova(
                new DekoratorCijelihBrojeva(new DekoratorStringova(new IspisString())))));
        String emisijaString = String.format(emisijaFormat.uredi().toString(),
                ep.getPocetak().format(formatter),
                ep.getKraj().format(formatter),
                ep.getEmisija().getTrajanje(), ep.getEmisija().getNaziv(), "", reklame);
        System.out.println(emisijaString);
    }

    public static void PrikaziVrsta(TjedniPlanComponent tp) {
        if (tp instanceof EmisijaProgram) {
            EmisijaProgram ep=(EmisijaProgram)tp;
            Ispis emisijaFormat = new DekoratorStringova(new DekoratorStringova(new IspisString()));
            String emisijaString = String.format(emisijaFormat.uredi().toString(),
                    ep.getEmisija().getNaziv(), ep.getDanUTjednu(),"");
            System.out.println(emisijaString);
        }
    }
}
