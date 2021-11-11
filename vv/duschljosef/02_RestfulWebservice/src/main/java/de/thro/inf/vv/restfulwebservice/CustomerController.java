package de.thro.inf.vv.restfulwebservice;

import de.thro.inf.vv.restfulwebservice.CrudInterfaces.IContractManagement;
import de.thro.inf.vv.restfulwebservice.CrudInterfaces.ICustomerManagement;
import de.thro.inf.vv.restfulwebservice.Class.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
@RestController
public class CustomerController {

    @Autowired
    private ICustomerManagement customerRepo;
    /**
     *          test if customerController works
     * @return  String, if Customer Controller work
     */
    @RequestMapping("/test")
    public String restOutput(){
        return "This is a test of the CustomerManagement";
    }

    /**
     *              find specific customer
     * @param       id find the certainly customer with this valu
     * @return      returns the body and the status Code 200
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable("id")Long id){
        return new ResponseEntity<>(customerRepo.findById(id).get(), HttpStatus.OK);
    }



    /**
     *          find all customers
     * @return  all customers in the database
     */
    @GetMapping(value = "/customers")
    List<Customer> findCustomers(){
        Iterable<Customer> iterator = customerRepo.findAll();
        List<Customer> result = new ArrayList<>();
        for (Customer c : iterator){
            result.add(c);
        }
        return result;
    }

    /**
     *                      save new costumers in database
     * @param c             save the new Customer
     * @param ucBuilder     bild the certainly uri
     * @return              StatusCode 201, Create a new HttpEntity with the given headers and status code, and no body.
     */
    @PostMapping(value="/customer/")
    public ResponseEntity<Void> newCustomer (@RequestBody Customer c, UriComponentsBuilder ucBuilder){
        customerRepo.save(c);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}")
        .buildAndExpand(c.getCustomerNumber()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * 
     * @param id              overgiven to find the certainly customer
     * @param customerNew     body of the response
     * @return                new ResponseEntity with the given body and status code, and no headers, statuc code 200
     */
    @PutMapping(value="/customer/{id}")
    public ResponseEntity<Customer> changeCustomer(@PathVariable long id, @RequestBody Customer customerNew){
        Customer oldCustomer = customerRepo.findById(id).get();
        oldCustomer.setFirstName(customerNew.getFirstName());
        oldCustomer.setSecondName(customerNew.getSecondName());
        customerRepo.save(oldCustomer);
        return new ResponseEntity<Customer> (oldCustomer, HttpStatus.OK);
    }

    /**
     *          delete specific customer
     * @param   id overgiven id to delete
     * @return Status Code 204
     */
    @DeleteMapping("/customer/{id}")
    ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Customer customer = customerRepo.findById(id).get();
        if(customer != null){
            customerRepo.delete(customer);
        }
        return new ResponseEntity<Customer> (customer, HttpStatus.OK);
    }
}