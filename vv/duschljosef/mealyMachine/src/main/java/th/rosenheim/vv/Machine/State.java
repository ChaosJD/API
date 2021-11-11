package th.rosenheim.vv.Machine;

import th.rosenheim.vv.Helping.HelpingMethods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.nio.file.Path;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/11/10
 */
@XmlType(name="something")
@XmlAccessorType(XmlAccessType.FIELD)
public class State implements Comparable{

    private String state;
    private TreeMap<Symbol, TreeMap<Symbol, State>> stateTable = new TreeMap<>();
    private TreeMap<Symbol, State> symbolState = new TreeMap<>();

    /**
     * default Constructor
     */
    public State(){ }

    /**Constructor
     *
     * @param state get the current state
     */
    public State(String state){
        if(!HelpingMethods.isNullOrEmptyString(state)){
            this.state = state;
        }
    }

    public void setStateTable(Symbol symbol, TreeMap<Symbol, State> ausein){
        stateTable.put(symbol, ausein);
    }

    /**
     * Getter Setter
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TreeMap<Symbol, TreeMap<Symbol, State>> getStateTable() {
        return stateTable;
    }

    public TreeMap<Symbol, State> getSymbolState() {
        return symbolState;
    }

    public void setSymbolState(TreeMap<Symbol, State> symbolState) {
        this.symbolState = symbolState;
    }

    /**
     *
     * @param input get the input for example of the terminal
     * @return send the next state return, false not it is sending null
     */
    public State changeState(String input){
        Symbol symbol;
        State state;
        TreeMap<Symbol, State> evaluationMap = new TreeMap<>();

        //check input Symbol
        if(input.equals("a") || input.equals("b")){
            symbol = new Symbol(input);
            evaluationMap = (TreeMap<Symbol, State>)this.stateTable.get(symbol);
            if(evaluationMap == null){
                return null;
            }
            return evaluationMap.get(evaluationMap.firstKey());
        }
        return  null;
    }

    /**
     *
     * @param input proofs the entry sign and gives the OutputSymobl Object to the terminal
     * @param queueOutput passes the OutputSymbol to the BlockingQueue
     */
    public void outputSymbol(String input, BlockingQueue queueOutput){
        Symbol symbol;

        if(input.equals("a") || input.equals("b")) {
            TreeMap<Symbol, State> evaluationMap;
            symbol = new Symbol(input);
            Path path;

            evaluationMap = this.stateTable.get(symbol);// ago this (TreeMap<Symbol, State>)
            try{
                symbol = evaluationMap.firstKey();
                System.out.println("output Symbol: " + symbol.getInOut());
                queueOutput.put(symbol.getInOut());
            }
            catch(Exception e){
                System.out.println("Machine has no output Symbol. It is in an end or catch state");
               System.exit(5);
            }
        }
    }

    /**
     *
     * @param newState print the current State to terminal
     */
    public void outputNewState(State newState){
        System.out.println("New State: " + newState.getState());
    }
    @Override
    public int compareTo(Object o) {
        State state = (State) o;
        if (this.getState().equals(state.getState())) {
            return 0; // ago 1
        }
        return -1;
    }
}
