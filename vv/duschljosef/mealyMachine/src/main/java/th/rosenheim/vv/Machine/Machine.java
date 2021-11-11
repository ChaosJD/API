package th.rosenheim.vv.Machine;

import th.rosenheim.vv.Helping.HelpingMethods;
import th.rosenheim.vv.serialization.Serializer;
import th.rosenheim.vv.serialization.StateList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;

public class Machine implements Runnable {

    private BlockingQueue<String> queueInput;
    private BlockingQueue<String> queueOutput;
    private String input;
    private final int INPUTLENGTH = 1;
    private State startState = new State("");
    private boolean folderOrTerminalEntrySign = false;
    private boolean folderBoolean = false;
    private Scanner entrySign;
    private String entrySignTerminal;


    public Machine(BlockingQueue<String> queueInput, BlockingQueue<String> queueOutput) {
        this.queueInput = queueInput;
        this.queueOutput = queueOutput;
        staticMachine();
    }

    /**
     * proves the input in terminal, switch to get the file of the input folder
     * or of the terminal
     */
    @Override
    public void run() {

        while (Thread.currentThread().isAlive()) {

            if (folderOrTerminalEntrySign == false) {
                entrySign = new Scanner(System.in);
                System.out.println("Do you want to set the entry sing over the input folder" +
                        " or over the terminal? ");
                        ;
                System.out.println("Please put f for folder or another character for terminal input ");
                System.out.println("then start with the entrysign");

                entrySignTerminal = entrySign.next();
            }

            try {
                if(entrySignTerminal.equals("f") == false){
                    entrySignTerminal = entrySign.next();
                }
                if (entrySignTerminal.equals("f") && !entrySignTerminal.isEmpty()) {
                    folderBoolean = true;
                }
            } catch (NullPointerException e) { }


            folderOrTerminalEntrySign = true;

            if (folderBoolean == true) {
                try {
                    input = queueInput.take();
                    HelpingMethods.threadSleep(10, Thread.currentThread());
                } catch (InterruptedException | NullPointerException e) {
                    //e.printStackTrace();
                    HelpingMethods.threadSleep(10, Thread.currentThread());
                    continue;
                }
            }

            try {
                if (!entrySignTerminal.isEmpty() && folderBoolean == false) {
                    input = entrySignTerminal;
                }
            } catch (NullPointerException e) { }

            try {
                if (!input.isEmpty() && input.length() == INPUTLENGTH) {
                    startState = startState.changeState(input);
                    if (startState == null) {
                        System.out.println("Sorry Bro. The caracter you entered in is not in the table." +
                                "Pleas start the Machine again");
                        System.exit(1);
                    }
                    startState.outputSymbol(input, queueOutput);
                    startState.outputNewState(startState);
                }

            } catch (NullPointerException e) { }
            HelpingMethods.threadSleep(10, Thread.currentThread());
        }
    }

    /**
     * Method to fill the static Machine
     */
    public void staticMachine() {

        //creating States
        State firstState = new State("first State");
        State secondState = new State("second State");
        State thirdState = new State("third State");

        //Input Symbols
        Symbol inputA = new Symbol("a");
        Symbol inputThree = new Symbol("b");

        //Output Symbols
        Symbol outputC = new Symbol("C");
        Symbol outputD = new Symbol("D");
        Symbol outputE = new Symbol("E");
        Symbol outputF = new Symbol("F");

        TreeMap<Symbol, State> outNextStateFirstStateInputA = new TreeMap<Symbol, State>();
        TreeMap<Symbol, State> outNextStateSecondStateInput = new TreeMap<Symbol, State>();
        // TreeMap<Symbol, State> ausfolgezustandDritterZustandEingabeA = new TreeMap<Symbol, State>();

        TreeMap<Symbol, State> outNextStateFirstStateInputB = new TreeMap<Symbol, State>();
        TreeMap<Symbol, State> outNextStateSecondStateInputB = new TreeMap<Symbol, State>();
        // TreeMap<Symbol, State> ausfolgezustandDritterZustandEingabeB = new TreeMap<Symbol, State>();

        //Fill Treemap in first State
        //inputSign: a
        outNextStateFirstStateInputA.put(outputC, secondState);
        firstState.setStateTable(inputA, outNextStateFirstStateInputA);

        //inputSign: b
        outNextStateFirstStateInputB.put(outputD, thirdState);
        firstState.setStateTable(inputThree, outNextStateFirstStateInputB);

        //Fill treemap in second State
        //inputSign: a
        outNextStateSecondStateInput.put(outputE, thirdState);
        secondState.setStateTable(inputA, outNextStateSecondStateInput);

        //inputSign: b
        outNextStateSecondStateInputB.put(outputF, firstState);
        secondState.setStateTable(inputThree, outNextStateSecondStateInputB);

        //Set first State as startstate
        startState = firstState;

        //Serializing of State in xml

        List<State> liststates = new ArrayList<>();
        liststates.add(firstState);
        liststates.add(secondState);
        liststates.add(thirdState);
        StateList stateList = new StateList(liststates);
         Serializer s = new Serializer();

        try (OutputStream out = new FileOutputStream("xml/Mealy_Machine.xml")) {
            s.xmlSerialize(stateList.getStateList(), out);
        }
       catch(IOException ex) {
            ex.printStackTrace();
            //fail();
        }
    }
}
