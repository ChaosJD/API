package th.rosenheim.vv.Machine;

import th.rosenheim.vv.Helping.HelpingMethods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
//import java.util.Comparator;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/11/13
 * bekommt Eingbe. Gibt Ausgabe
 */
@XmlRootElement(name="symbol")
@XmlAccessorType(XmlAccessType.FIELD)
public class Symbol implements Comparable {
    private String inOut;
    /**
     * default Constructor
     */
    public Symbol(){}

    /**
     * Constructor
     * @param inOut get string set in- and output symbol objects
     */
    public Symbol(String inOut) {
        if (!HelpingMethods.isNullOrEmptyString(inOut)) {
            this.inOut = inOut;
        }
    }

    /**
     *Getter & Setter methods
     */
    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    @Override
    public int compareTo(Object o) {
        Symbol symbol = (Symbol) o;

        if(this.getInOut().equals(symbol.getInOut())){
            return 0; // 0
        }
        return -1;
    }
}
