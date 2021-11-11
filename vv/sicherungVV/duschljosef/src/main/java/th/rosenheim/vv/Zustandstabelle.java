package th.rosenheim.vv;

import th.rosenheim.fehlerabfragen.Definitions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Zustandstabelle /*implements Comparable*/ {



    private TreeMap<Symbol, TreeMap<Symbol, State>> zustandstabelleTreemap = new TreeMap<>();
    private TreeMap<Symbol, State> outputFolgeTremap = new TreeMap<>();

    public void Zustandstabelle(Symbol in, Symbol out, State folgezustand) {

        outputFolgeTremap.put(out, folgezustand);
        zustandstabelleTreemap.put(in, outputFolgeTremap);
    }

    // Getter & Setter

    public TreeMap<Symbol, TreeMap<Symbol, State>>
    getZustandstabelleTreemap() {
        return zustandstabelleTreemap;
    }

    public TreeMap<Symbol, State> getOutputFolgeTremap() {
        return outputFolgeTremap;
    }

    public void setZustandstabelleTreemap(TreeMap<Symbol, TreeMap<Symbol, State>> zustandstabelleTreemap) {
        this.zustandstabelleTreemap = zustandstabelleTreemap;
    }

    public void setOutputFolgeTremap(TreeMap<Symbol, State> outputFolgeTremap) {
        this.outputFolgeTremap = outputFolgeTremap;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false; // (1) Vergleich mit 0
        }
        if (obj == this){
            return true; // (2) Prüfe auf Identität
        }
        // (3) Teste ob gleicher Datentyp
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        // (4) Vergleich der Datenelemente, abhängig von Anwendung
        Zustandstabelle other = (Zustandstabelle) obj; // Typecast
        if (this.zustandstabelleTreemap.equals(other.zustandstabelleTreemap) &&
                this.outputFolgeTremap == other.outputFolgeTremap)
            return true;
        return false;
    }
}
