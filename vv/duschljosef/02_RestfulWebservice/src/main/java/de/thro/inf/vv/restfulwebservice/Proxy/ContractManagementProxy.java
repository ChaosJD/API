package de.thro.inf.vv.restfulwebservice.Proxy;

import de.thro.inf.vv.restfulwebservice.Class.Contract;
import de.thro.inf.vv.restfulwebservice.Class.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
public class ContractManagementProxy implements IConstMeth {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *          List all contracts
     * @return  this class. to chain the Methods togehter.
     */
    public ContractManagementProxy listContracts(){
        List<LinkedHashMap<String, Object>> contracts = restTemplate
                .getForObject(REST_SERVICE_URI+"/contracts/", List.class);
        if(contracts!=null){
            contracts.forEach(element -> {
                System.out.print("\nContract: id = "+element.get("id") +
                        "\nContractual Offer = "+ element.get("contractualOffer") +
                        "\nannualSubscription= " + element.get("annualSubscription"));
            });
        }
        else{
            System.out.println("\nNo Contracts\n");
        }
        return this;
    }

    /**
     *          List specific contract
     * @param   id search for the specific contract
     * @return  this class. to chain the Methods togehter.
     */
    public ContractManagementProxy listContract(long id){
        if(id!=0){
            logger.info("\ngetContract\n");
            System.out.println( restTemplate.getForObject(REST_SERVICE_URI + "/contract/" + id, Customer.class));
        }
        System.out.println("\nNo Contract found\n");
        return this;
    }

    /**
     *        change a specific Contract
     * @param contract, are the new values
     * @param id, the specific identifier
     * @return this class, chain the Methods togehter.
     */
    public ContractManagementProxy updateContract(Contract contract, long id){
        restTemplate.put(REST_SERVICE_URI+"/contract/" + id, contract);
        logger.info("\nupdating\n");
        return this;
    }

    /**
     *          delte specific Contract
     * @param   id delte specific contract
     * @return  this class. to chain the Methods togehter.
     */
    public ContractManagementProxy deleteContract(long id){
        logger.info("\ndeleting\n");
        restTemplate.delete(REST_SERVICE_URI+ "/contract/" + id);
        return this;
    }

    /**
     *          add a new contract to database
     * @param   contract add new Contract to database
     * @return  this class. to chain the Methods togehter.
     */
    public ContractManagementProxy createContract(Contract contract){
        logger.info("\ncreateContract\n");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/contract/", contract, Customer.class);
        logger.info("\nLocation: " + uri.toASCIIString()+"\n");
        return this;
    }
}
