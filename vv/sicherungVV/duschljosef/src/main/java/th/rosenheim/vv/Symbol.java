package th.rosenheim.vv;
import th.rosenheim.fehlerabfragen.*;

import static th.rosenheim.fehlerabfragen.Definitions.FALSE;
import static th.rosenheim.fehlerabfragen.Definitions.TRUE;


/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/11/13
 * bekommt Eingbe. Gibt Ausgabe
 */
public class Symbol{


    private String einAus;

    /**
     *
     * @param einAus bekommt Zeichenkette. Ist einAusgabe?
     */
    public Symbol(String einAus) {
        if (!Definitions.isNullOrEmpty(einAus)) {
           this.einAus = einAus;
        }
    }

    /**
     *Getter & Setter
     */
    public String getEinAusgabe() {
        return einAus;
    }

    public void setEinAus(String einAus) {
        this.einAus = einAus;
    }

}
