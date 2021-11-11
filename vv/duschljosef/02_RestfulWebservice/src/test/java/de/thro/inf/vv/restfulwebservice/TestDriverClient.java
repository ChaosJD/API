package de.thro.inf.vv.restfulwebservice;

import de.thro.inf.vv.restfulwebservice.Class.Address;
import de.thro.inf.vv.restfulwebservice.Class.Contract;
import de.thro.inf.vv.restfulwebservice.Class.ContractOffer;
import de.thro.inf.vv.restfulwebservice.Class.Customer;
import de.thro.inf.vv.restfulwebservice.Proxy.IConstMeth;
import org.junit.Test;

import org.springframework.http.*;

import java.util.Date;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
public class TestDriverClient implements IConstMeth {

    /**
     * Please restart the the SpringApplicaton before using it.
     */

    /**
     * Delete Test for customer
     */
    @Test
    public void deleteCustomer() {
        final long ID = 1;
        ResponseEntity<Map> responseEntity = restTemplate
                .exchange(REST_SERVICE_URI+ "/customer/{id}",
                        HttpMethod.DELETE, null, Map.class, ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getHeaders().getContentType(), is(MediaType.APPLICATION_JSON));
    }

    /**
     * new Customer Test
     */
    @Test
    public void createCustomer() {
        Address address = new Address("Landhausstraße", 15362, "Neuenhagen" );
        Customer customer = new Customer("Simone", "Schultheiss", new Date(31122000), address);
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/customer/",customer, Map.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }

    /**
     * Test for changing values
     */
    @Test
    public void changeCustomer(){
        String ID = "1";
        Address address = new Address("Pohlstrasse", 38690, "Vienenburg");
        Customer customer = new Customer("Juliane", "Lehmann", new Date(25021984), address);

        HttpEntity<Customer> entity = new HttpEntity<Customer>(customer);
        ResponseEntity<Map> responseEntity1 = restTemplate.exchange(REST_SERVICE_URI + "/customer/" + ID, HttpMethod.PUT, entity, Map.class);

       assertThat(responseEntity1.getStatusCode(),is(HttpStatus.OK));
    }

    /**
     * delete test for contract
     */
    @Test
    public void deleteConctracts(){
        final long ID = 7;
        ResponseEntity<Map> responseEntity = restTemplate
                .exchange(REST_SERVICE_URI+ "/contract/{id}",
                        HttpMethod.DELETE, null, Map.class, ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    /**
     * new contract test
     */
    @Test
    public void createContract(){
        Contract contract = new Contract(ContractOffer.MOTORVEHICLEINSURANCE, 5000);
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/contract/",contract, Map.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }

    /**
     * change value test for contract
     */
    @Test
    public void changeContract(){
        String ID = "8";
        Contract contract = new Contract(ContractOffer.LEGALPROTECTION, 8000);
        HttpEntity<Contract> entity = new HttpEntity<Contract>(contract);
        ResponseEntity<Map> responseEntity1 = restTemplate.exchange(REST_SERVICE_URI + "/contract/" + ID, HttpMethod.PUT, entity, Map.class);
        assertThat(responseEntity1.getStatusCode(),is(HttpStatus.OK));
    }

}
