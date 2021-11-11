package th.rosenheim.vv;

import th.rosenheim.fehlerabfragen.Definitions;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/11/10
 */

public class State implements Comparator {

    private String zustand; //einheitlich auch private
    TreeMap <Symbol, TreeMap<Symbol, State>> stateTable = new TreeMap<>();
    //TreeMap <Symbol, State> outState = new TreeMap<>();

    //statechange hier! State als rückgabert. übergabe als State


    //Constructors
    public State(String zustand){
        if(!Definitions.isNullOrEmpty(zustand)){
            this.zustand = zustand;
        }
    }

    //kann man verwenden. Derzeit noch nicht.
    public void State(String zustand, TreeMap vergleichstabelle) {
        if(!Definitions.isNullOrEmpty(zustand) && vergleichstabelle.isEmpty()){
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


    public TreeMap<Symbol, TreeMap<Symbol, State>> getStateTable() {
        return stateTable;
    }

    public void setStateTable(TreeMap<Symbol, TreeMap<Symbol, State>> stateTable) {
        this.stateTable = stateTable;
    }

    public TreeMap<Symbol, State> getOutState() {
        return outState;
    }

    public void setOutState(TreeMap<Symbol, State> outState) {
        this.outState = outState;
    }

    @Override
    public int compare(Object o, Object t1) {
        State state1 = (State) o;
        State state2 = (State) t1;
        return state1.getZustand().compareTo(state2.getZustand());
    }
}



