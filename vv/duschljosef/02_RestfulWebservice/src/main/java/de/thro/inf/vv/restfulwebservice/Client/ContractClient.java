package de.thro.inf.vv.restfulwebservice.Client;

import de.thro.inf.vv.restfulwebservice.Class.Contract;
import de.thro.inf.vv.restfulwebservice.Class.ContractOffer;
import de.thro.inf.vv.restfulwebservice.Proxy.ContractManagementProxy;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
public class ContractClient {

    public static void main(String[] args) {
        //create necessary objects
        final ContractManagementProxy cmp = new ContractManagementProxy();
        Contract contractNew = new Contract(ContractOffer.MOTORVEHICLEINSURANCE, 80);
        Contract contractUpdate = new Contract(ContractOffer.LIABILITY, 75);

        //work with the necessary objects
        cmp.listContracts().line();
        cmp.listContract(8).line();
        cmp.createContract(contractNew).line();
        cmp.updateContract(contractUpdate,7).line();
        cmp.deleteContract(9);
    }
}
