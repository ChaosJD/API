package de.thro.inf.vv.restfulwebservice;

import de.thro.inf.vv.restfulwebservice.CrudInterfaces.IContractManagement;
import de.thro.inf.vv.restfulwebservice.Class.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
@RestController
public class ContractController {

    @Autowired
    private IContractManagement contractRepo;

    /**
     *          test, if ContractController works
     * @return a String to test the ContractManagement class
     */
    @RequestMapping("/contract/test")
    public String restOutput(){
        return "This is a test of the ContractManagement!";
    }

    /**
     *          list specific contract
     * @param id search in the Database for this overgiben Customer
     * @return gives back the Contract with the Http Statusn Code 200
     */
    @GetMapping("/contract/{id}")
    public ResponseEntity<Contract> findCustomer(@PathVariable("id")Long id){
        return new ResponseEntity<>(contractRepo.findById(id).get(), HttpStatus.OK);
    }

    /**
     *          list all contract
     * @return  all the contracts in a List
     */
    @GetMapping(value = "/contracts")
    List<Contract> findCustomers(){
        Iterable<Contract> iterator = contractRepo.findAll();
        List<Contract> result = new ArrayList<>();
        for (Contract c : iterator){
            result.add(c);
        }
        return result;
    }

    /**
     *          add new contract to database
     * @param c saves the new contract of the Request Body
     * @param ucBuilder Extension of HttpEntity that adds a HttpStatus status code.
     * @return Create a new HttpEntity with the given headers and status code, and no body.
     */
    @PostMapping(value="/contract/")
    public ResponseEntity<Void> newContract (@RequestBody Contract c, UriComponentsBuilder ucBuilder){
        contractRepo.save(c);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}")
                .buildAndExpand(c.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     *          delete specific contract
     * @param   id overgiven value to change the certainly contract
     * @param   contractNew change the annualSubscritpon, ContractOffer
     * @return  Create a new HttpEntity with the given headers and status code, and no body. Status Code 200*/
    @PutMapping(value="/contract/{id}")
    public ResponseEntity<Contract> changeConctract(@PathVariable long id, @RequestBody Contract contractNew){
        Contract oldContract = contractRepo.findById(id).get();
        oldContract.setAnnualSubscription(contractNew.getAnnualSubscription());
        oldContract.setContractualOffer(contractNew.getContractualOffer());
        contractRepo.save(oldContract);;
        return new ResponseEntity<Contract> (oldContract, HttpStatus.OK);
    }

    /**
     *          delete specific contract
     * @param   id overgiven id to delete the certain contract
     * @return  Response Status Code 200
     */
    @DeleteMapping("/contract/{id}")
    ResponseEntity<Contract> deleteContract(@PathVariable Long id){
        Contract contract = contractRepo.findById(id).get();
        if(contract != null){
            contractRepo.delete(contract);
        }
        return new ResponseEntity<Contract> (contract, HttpStatus.OK);
    }
}
