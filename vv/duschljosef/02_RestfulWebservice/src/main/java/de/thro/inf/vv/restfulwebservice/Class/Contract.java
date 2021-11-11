package de.thro.inf.vv.restfulwebservice.Class;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/09
 */
@Entity
public class Contract {

    @Version
    private long version;
//
//    enum contractualOffer{
//        LIABILITY, LEGALPROTECTION,
//        MOTORVEHICLEINSURANCE
//    }

    @Id
    @GeneratedValue
    private long id;

    private ContractOffer contractualOffer;
    //private long contractNumber;
    private int annualSubscription;

    public Contract(ContractOffer contractualOffer,int annualSubscription){ //long contractNumber
        this.contractualOffer = contractualOffer;
        //this.contractNumber = contractNumber;
        this.annualSubscription = annualSubscription;
    }

    public Contract() {
    }

    public ContractOffer getContractualOffer() {
        return contractualOffer;
    }

    public void setContractualOffer(ContractOffer contractualOffer) {
        this.contractualOffer = contractualOffer;
    }

    /**
     * getter/setter
     */

    public long getId() {
        return id;
    }

    public int getAnnualSubscription() {
        return annualSubscription;
    }

    public void setAnnualSubscription(int annualSubscription) {
        this.annualSubscription = annualSubscription;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "version=" + version +
                ", id=" + id +
                ", contractualOffer=" + contractualOffer +
                ", annualSubscription=" + annualSubscription +
                '}';
    }
}
