package th.rosenheim.vv.Maschine;

import java.util.Scanner;
import java.util.TreeMap;

public class main {
    //Treemaps anlegen


    public static void main(String[] args) {
        final int RUNDEN = 2;
        String eingabeTerm;

        // Zuerst States, dann die Symbole erzeugen.
        Zustand s1 = new Zustand("s1");
        Zustand s2 = new Zustand("s2");
        Zustand s3 = new Zustand( "s3");

        //Eingabesymbole
        Symbol eingabeA = new Symbol("a");
        Symbol eingabeB = new Symbol("b");

        //Ausgabsymbole

        Symbol ausgabeC = new Symbol("C");
        Symbol ausgabeD = new Symbol("D");
        Symbol ausgabeE = new Symbol("E");
        Symbol ausgabeF = new Symbol("F");

        TreeMap<Symbol, TreeMap<Symbol, Zustand>> inOutStateTable = new TreeMap<>();
        TreeMap<Symbol, Zustand> outStateTable = new TreeMap<>();


        //Zustandstabelle Instazieren, unsinnig? -> Zustände werden in State gespeichert.
        //Zustandstabelle zstb = new Zustandstabelle();

        //Treemap füllen für s1
        //a
        outStateTable.put(ausgabeC, s2);
        inOutStateTable.put(eingabeA, outStateTable);
        s1.setStateTable(inOutStateTable);
        outStateTable.clear();
        inOutStateTable.clear();
        //b
        outStateTable.put(ausgabeD, s3);
        inOutStateTable.put(eingabeB, outStateTable);
        outStateTable.clear();
        inOutStateTable.clear();

        //Treemap füllen s2
        //a
        outStateTable.put(ausgabeE, s3);
        inOutStateTable.put(eingabeA, outStateTable);
        outStateTable.clear();
        inOutStateTable.clear();
        //b
        outStateTable.put(ausgabeF, s1);
        inOutStateTable.put(eingabeB, outStateTable);
        outStateTable.clear();
        inOutStateTable.clear();

        Scanner input = new Scanner(System.in);
        eingabeTerm = input.next();
        //do
        {
            try{
                if(eingabeTerm.equals("a") || eingabeTerm.equals("b")){

                }
            }
            catch (Exception ex){
                //Geht wahrscheinlich auch schöner.
                System.out.println("Sorry bro. War kein gültiges Eingabezeichen. Systemabbruch");
            }
            finally {

            }

        }//while(true)
    }

}
