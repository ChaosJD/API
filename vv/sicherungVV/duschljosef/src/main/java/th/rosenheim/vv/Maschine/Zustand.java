package th.rosenheim.vv.Maschine;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/11/10
 */
public class Zustand implements Comparator {
    private String zustand; //einheitlich auch private
    TreeMap <Symbol, TreeMap<Symbol, Zustand>> stateTable = new TreeMap<>();
    //TreeMap <Symbol, State> outState = new TreeMap<>();

    //statechange hier! State als rückgabert. übergabe als State


    //Constructors
    public Zustand(String zustand){
        if(!Definitionen.isNullOrEmpty(zustand)){
            this.zustand = zustand;
        }
    }

    //kann man verwenden. Derzeit noch nicht.
    public void State(String zustand, TreeMap vergleichstabelle) {
        if(!Definitionen.isNullOrEmpty(zustand) && vergleichstabelle.isEmpty()){
            stateTable = vergleichstabelle;
            this.zustand = zustand;
        }
    }

    /**
     * Getter Setter
     */
    public String getZustand() {
        return zustand;
    }

    public void setZustand(String zustand) {
        this.zustand = zustand;
    }


    public TreeMap<Symbol, TreeMap<Symbol, Zustand>> getStateTable() {
        return stateTable;
    }

    public void setStateTable(TreeMap<Symbol, TreeMap<Symbol, Zustand>> stateTable) {
        this.stateTable = stateTable;
    }

    /*
    public TreeMap<Symbol, Zustand> getOutState() {
        return outState;
    }
    */

    /*
    public void setOutState(TreeMap<Symbol, Zustand> outState) {
        this.outState = outState;
    }
    */

    @Override
    public int compare(Object o, Object t1) {
        Zustand state1 = (Zustand) o;
        Zustand state2 = (Zustand) t1;
        return state1.getZustand().compareTo(state2.getZustand());
    }
}
