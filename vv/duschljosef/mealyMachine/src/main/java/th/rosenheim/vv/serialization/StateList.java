package th.rosenheim.vv.serialization;

import th.rosenheim.vv.Machine.State;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name="Mealy_Machine")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateList {

    private List<State> stateList;

    public StateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public StateList(){}

    /**
     * Getter&Setter
     */
    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }



}
