package th.rosenheim.vv.serialization;

import com.sun.xml.internal.txw2.annotation.XmlElement;
import th.rosenheim.vv.Machine.Symbol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="Symbol")
@XmlAccessorType(XmlAccessType.FIELD)
public class SymbolList {

    private List<Symbol> symbolList;

    /**
     * Getter/Setter
     */
    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    public void setSymbolList(List<Symbol> symbolList) {
        this.symbolList = symbolList;
    }

}
