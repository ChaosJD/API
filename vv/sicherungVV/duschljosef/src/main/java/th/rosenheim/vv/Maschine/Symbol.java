package th.rosenheim.vv.Maschine;

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
        if (!Definitionen.isNullOrEmpty(einAus)) {
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
