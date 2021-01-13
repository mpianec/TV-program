package mpianec_zadaca_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Matija
 */
public class Mpianec_zadaca_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 10) {
            System.out.println("Nisu unesene sve datoteke.");
            System.exit(0);
        }
        Mpianec_zadaca_3 zadaca = new Mpianec_zadaca_3();

        boolean status = zadaca.provjeriParametre(Arrays.asList(args));
        if (!status) {
            System.out.println("Parametri ne odgovaraju");
            return;
        }
        String putanja = ucitaj(Arrays.asList(args), "-t");
        TvornicaDatoteka tvornica = new TvornicaDatoteka();
        Datoteke datoteke = tvornica.stvori(ucitaj(Arrays.asList(args), "-u"), "u").ucitaj();
        UlogeDat uloge = (UlogeDat) datoteke;
        TVKuca.getInstance().setListaUloga(uloge.getListaUloga());
        datoteke = tvornica.stvori(ucitaj(Arrays.asList(args), "-o"), "o").ucitaj();
        OsobeDat osobe = (OsobeDat) datoteke;
        TVKuca.getInstance().setListaOsoba(osobe.getListaOsoba());
        datoteke = tvornica.stvori(ucitaj(Arrays.asList(args), "-v"), "v").ucitaj();
        VrstaEmisijeDat vrstaEmisije = (VrstaEmisijeDat) datoteke;
        TVKuca.getInstance().setListaVrstaEmisije(vrstaEmisije.getListaVrsteEmisija());
        datoteke = tvornica.stvori(ucitaj(Arrays.asList(args), "-e"), "e").ucitaj();
        EmisijeDat emisije = (EmisijeDat) datoteke;
        TVKuca.getInstance().setListaEmisija(emisije.getListaEmisija());
        datoteke = tvornica.stvori(putanja, "t").ucitaj();
        ProgramDat program = (ProgramDat) datoteke;
        TVKuca.getInstance().setListaPrograma(program.getListaPrograma());
        List<TjedniPlanComponent> listaPrograma = new ArrayList<>();
        for (Program prog : TVKuca.getInstance().getListaPrograma()) {
            ProgramComposite programComposite = new ProgramComposite();
            programComposite.setiD(prog.getiD());
            String pattern = Pattern.quote(System.getProperty("file.separator"));
            String[] putanjaPrograma = putanja.split(pattern);
            String nazivPrograma = "";
            for (int i = 0; i < putanjaPrograma.length - 1; i++) {
                nazivPrograma += putanjaPrograma[i] + File.separator;
            }
            nazivPrograma += prog.getNazivDatoteke();
            datoteke = tvornica.stvori(nazivPrograma, "p").ucitaj();
            EmisijaProgramDat emisijaProgram = (EmisijaProgramDat) datoteke;
            prog.setListaEmisijaPrograma(emisijaProgram.getListaEmisijaProgram());
            for (int i = 1; i <= 7; i++) {
                DanPrograma danProgram = new DanPrograma();
                danProgram.setiD(i);
                danProgram.setPocetak(prog.getPocetak());
                danProgram.setKraj(prog.getKraj());
                danProgram.dodaj((List<TjedniPlanComponent>) (List<?>) prog.getListaEmisijaPrograma());
                for (TjedniPlanComponent tpc : danProgram.getListaEmisija()) {
                    EmisijaProgram nekaj = (EmisijaProgram) tpc;
                    nekaj.setiD(Counter.counter);
                    Counter.counter++;
                }
                programComposite.dodaj(danProgram);
                System.out.println("\n");
            }
            listaPrograma.add(programComposite);
        }
        int odabir = 0;
        do {
            try {
                System.out.println("Unesite broj radnje koju želite izvršiti: ");
                System.out.println("1. Ispis vremenskog plana za određeni dan i program.");
                System.out.println("2. Ispis potencijalnih prihoda od reklama(u min) za određeni dan i program.");
                System.out.println("3. Ispis tjednog plana po programima, danima i emisijama za određenu vrstu emisije.");
                System.out.println("4. Ispis osoba, uloga, zamjena uloga u postojećim emisijama.");
                System.out.println("5. Brisanje emisije temeljem njenog broja.");
                System.out.println("6. Ispis broja pohranjivanja.");
                System.out.println("7. Vraćanje na spremljeno stanje.");
                System.out.println("8. Provjera je li serija kratko/srednje/dugometražna i ispis trajanja.");
                System.out.println("9. Izlaz iz programa.");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String broj = reader.readLine();
                try {
                    odabir = Integer.parseInt(broj);
                } catch (NumberFormatException ex) {
                }
                switch (odabir) {
                    case 1:
                        System.out.print("Unesite ID programa: ");
                        int uneseniIdProgram = Integer.parseInt(reader.readLine());
                        System.out.print("Unesite dan u tjednu(broj dana):");
                        int uneseniDan = Integer.parseInt(reader.readLine());
                        IteratorAggregate iteratorAggregate = new ConcreteAggregate(listaPrograma);
                        Iterator<TjedniPlanComponent> iteratorPrograma = iteratorAggregate.getIterator();
                        KonstrukcijaIspisa.Zaglavlje();
                        for (Iterator<TjedniPlanComponent> iteratorProgram = iteratorAggregate.getIterator(); iteratorPrograma.hasNext();) {
                            TjedniPlanComponent tpc = iteratorProgram.getNext();
                            ProgramComposite programComposite = (ProgramComposite) iteratorPrograma.getNext();
                            if (programComposite.getiD() == uneseniIdProgram) {
                                iteratorAggregate = new ConcreteAggregate(programComposite.getListaDanaUTjednu());
                                for (Iterator<TjedniPlanComponent> iteratorDana = iteratorAggregate.getIterator(); iteratorDana.hasNext();) {
                                    TjedniPlanComponent tjedniPC = iteratorDana.getNext();
                                    DanPrograma danPrograma = (DanPrograma) tjedniPC;
                                    if (danPrograma.getiD() == uneseniDan) {
                                        iteratorAggregate = new ConcreteAggregate(danPrograma.getListaEmisija());
                                        for (Iterator<TjedniPlanComponent> iteratorEmisija = iteratorAggregate.getIterator(); iteratorEmisija.hasNext();) {
                                            TjedniPlanComponent tpc2 = iteratorEmisija.getNext();
                                            EmisijaProgram ep = (EmisijaProgram) tpc2;
                                            KonstrukcijaIspisa.Prikazi(ep);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        int maxTrajanje = 0;
                        System.out.print("Unesite ID programa: ");
                        int uneseniIdProgramRek = Integer.parseInt(reader.readLine());
                        System.out.print("Unesite dan u tjednu(broj dana):");
                        int uneseniDanRek = Integer.parseInt(reader.readLine());
                        IteratorAggregate iteratorAggregateRek = new ConcreteAggregate(listaPrograma);
                        Iterator<TjedniPlanComponent> iteratorProgramaRek = iteratorAggregateRek.getIterator();
                        KonstrukcijaIspisa.ZaglavljeReklame();
                        for (Iterator<TjedniPlanComponent> iteratorProgram = iteratorAggregateRek.getIterator(); iteratorProgramaRek.hasNext();) {
                            TjedniPlanComponent tpc = iteratorProgram.getNext();
                            ProgramComposite programComposite = (ProgramComposite) iteratorProgramaRek.getNext();
                            if (programComposite.getiD() == uneseniIdProgramRek) {
                                iteratorAggregate = new ConcreteAggregate(programComposite.getListaDanaUTjednu());
                                for (Iterator<TjedniPlanComponent> iteratorDana = iteratorAggregate.getIterator(); iteratorDana.hasNext();) {
                                    TjedniPlanComponent tjedniPC = iteratorDana.getNext();
                                    DanPrograma danPrograma = (DanPrograma) tjedniPC;
                                    if (danPrograma.getiD() == uneseniDanRek) {
                                        iteratorAggregate = new ConcreteAggregate(danPrograma.getListaEmisija());
                                        for (Iterator<TjedniPlanComponent> iteratorEmisija = iteratorAggregate.getIterator(); iteratorEmisija.hasNext();) {
                                            TjedniPlanComponent tpc2 = iteratorEmisija.getNext();
                                            EmisijaProgram ep = (EmisijaProgram) tpc2;
                                            if (ep != null && ep.getEmisija().getVrstaEmisije().getImaReklame() == 1) {
                                                maxTrajanje = ep.getEmisija().getVrstaEmisije().getMaxTrajanjeReklame();
                                                //System.out.println("Program " + programComposite.getiD() + ". " + ep.getEmisija().getNaziv() + " " + ep.getPocetak() + "-" + ep.getKraj()+" ,prihod od reklama: "+maxTrajanje);
                                                KonstrukcijaIspisa.PrikaziReklame(ep, maxTrajanje);
                                            }
                                        }
                                        Collection coll = new Collection(danPrograma);
                                        Visitor visitor = new ConcreteVisitor();
                                        System.out.println("Suma: " + visitor.visitComposite(coll));
                                    }
                                }
                            }
                        }

                        break;
                    case 3:
                        System.out.println("Unesite vrstu emisije: ");
                        int vrsta = Integer.parseInt(reader.readLine());
                        IteratorAggregate iteratorAggregateVrsta = new ConcreteVrsteAggregate(listaPrograma, vrsta);
                        KonstrukcijaIspisa.ZaglavljeVrsta();
                        for (Iterator<TjedniPlanComponent> iteratorVrsta = iteratorAggregateVrsta.getIterator(); iteratorVrsta.hasNext();) {
                            TjedniPlanComponent tcpVrste = iteratorVrsta.getNext();
                            KonstrukcijaIspisa.PrikaziVrsta(tcpVrste);
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Unesite broj emisije");
                        int jednoznačniRedniBroj = Integer.parseInt(reader.readLine());
                        IteratorAggregate iteratorAggregateBrisanje = new ConcreteAggregate(listaPrograma);
                        Iterator<TjedniPlanComponent> iteratorProgramaBrisanje = iteratorAggregateBrisanje.getIterator();
                        for (Iterator<TjedniPlanComponent> iteratorProgramaBris = iteratorAggregateBrisanje.getIterator(); iteratorProgramaBris.hasNext();) {
                            TjedniPlanComponent planComponent = iteratorProgramaBris.getNext();
                            ProgramComposite programComposite = (ProgramComposite) planComponent;
                            iteratorAggregateBrisanje = new ConcreteAggregate(programComposite.getListaDanaUTjednu());
                            for (Iterator<TjedniPlanComponent> iteratorDana = iteratorAggregateBrisanje.getIterator(); iteratorDana.hasNext();) {
                                TjedniPlanComponent pc = iteratorDana.getNext();
                                if (pc instanceof DanPrograma) {
                                    DanPrograma danProgram = (DanPrograma) pc;
                                    iteratorAggregateBrisanje = new ConcreteAggregate(danProgram.getListaEmisija());
                                    for (Iterator<TjedniPlanComponent> iteratorEmisija = iteratorAggregateBrisanje.getIterator(); iteratorEmisija.hasNext();) {
                                        TjedniPlanComponent pc1 = iteratorEmisija.getNext();
                                        if ((pc1 instanceof EmisijaProgram)) {
                                            EmisijaProgram ep = (EmisijaProgram) pc1;
                                            if (ep.getiD() == jednoznačniRedniBroj) {
                                                Caretaker.addMemento(listaPrograma);
                                                iteratorEmisija.remove(pc1);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 6:
                        Caretaker.ispis();
                        break;
                    case 7:
                        System.out.print("Unesite ID spremanja za koji želite vratiti podatke: ");
                        int mementoId = Integer.parseInt(reader.readLine());
                        listaPrograma = Caretaker.returnMemento(mementoId);
                        break;
                    case 8:
                        System.out.print("Unesite ID spremanja za koji želite vratiti podatke: ");
                        int emisijaId = Integer.parseInt(reader.readLine());
                        for(int e=0;e<TVKuca.getInstance().getListaEmisija().size();e++){
                            if(TVKuca.getInstance().getListaEmisija().get(e).getiD()==emisijaId){
                                System.out.println("Odabrana emisija je: "+ TVKuca.getInstance().getListaEmisija().get(e).getNaziv());
                                Handler kratko=new KratkometrazneEmisijeHandler();
                                Handler srednje=new SrednjemetrazneEmisijeHandler();
                                Handler dugo=new DugometrazneEmisijeHandler();
                                kratko.setNext(srednje);
                                srednje.setNext(dugo);
                                kratko.calculate(TVKuca.getInstance().getListaEmisija().get(e).getTrajanje());
                            }
                        }
                        
                        break;
                    case 9:
                        System.exit(0);
                    default:
                        System.out.println("Pogrešan unos.");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Mpianec_zadaca_3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (odabir
                != 9);

    }

    public static String ucitaj(List<String> parametri, String zastavica) {
        for (int i = 0; i < parametri.size() - 1; i++) {
            if (parametri.get(i).equals(zastavica)) {
                return parametri.get(i + 1);
            }
        }
        return null;
    }

    public boolean provjeriParametre(List<String> parametri) {
        boolean status;
        if (parametri.contains("-t") && parametri.contains("-u") && parametri.contains("-v") && parametri.contains("-o") && parametri.contains("-e")) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }
}
