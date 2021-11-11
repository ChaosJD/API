package de.thro.inf.vv.restfulwebservice.Proxy;

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
public class CustomerManagementProxy implements IConstMeth {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *          List all Customers
     * @return  this class. to chain the Methods togehter.
     */
    public CustomerManagementProxy listCustomers(){
        List<LinkedHashMap<String, Object>> customers = restTemplate
                .getForObject(REST_SERVICE_URI+"/customers", List.class);
        if(customers!=null){
            customers.forEach(element -> {
                System.out.print("Customer: id = "+element.get("customerNumber") +
                        "\nFirst Name = "+ element.get("firstName") +
                        "\nSecond Name = " + element.get("secondName")+
                        "\nBirthday = " + element.get("birthday"));
            });
        }
        else{
            System.out.println("No Customers");
        }
        return this;
    }

    /**
     *          List specific Customer
     * @param   id
     * @return  this class. to chain the Methods togehter.
     */
    public CustomerManagementProxy listCustomer(long id){
        if(id!=0){
            logger.info("\ngetCustomer\n");
            System.out.println( restTemplate.getForObject(REST_SERVICE_URI + "/customer/" + id, Customer.class));
        }
        System.out.println("No Customer found");
        return this;
    }

    /**
     *                  change firstName, secondName
     * @param customer  takeover the fistName, secondName of this object
     * @return          this class. to chain the Methods togehter.
     */
    public CustomerManagementProxy updateCustomer(Customer customer, long id){
        restTemplate.put(REST_SERVICE_URI+"/customer/" + id, customer);
        logger.info("\nupdating\n");
        return this;
    }

    /**
     *              Delete available customer
     * @param id    delete the specific customer
     * @return      this class. to chain the Methods togehter.
     */
    public CustomerManagementProxy deleteCustomer(long id){
        logger.info("\ndeleting\n");
        restTemplate.delete(REST_SERVICE_URI+ "/customer/" + id);
        return this;
    }

    /**
     *          Create new Customer
     * @param   customer
     * @return  this class. to chain the Methods togehter.
     */
    public CustomerManagementProxy createCustomer(Customer customer){
        logger.info("\ncreateCustomer\n");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/customer/", customer, Customer.class);
        logger.info("\nLocation: " + uri.toASCIIString()+"\n");
        return this;
    }
}
