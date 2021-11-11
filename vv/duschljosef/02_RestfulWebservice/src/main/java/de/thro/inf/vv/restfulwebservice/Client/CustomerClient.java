package de.thro.inf.vv.restfulwebservice.Client;

import de.thro.inf.vv.restfulwebservice.Class.Address;
import de.thro.inf.vv.restfulwebservice.Class.Customer;
import de.thro.inf.vv.restfulwebservice.Proxy.CustomerManagementProxy;

import java.util.Date;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
public class CustomerClient {
    public static void main(String[] args) {
        //create necessary objects
        final CustomerManagementProxy cmp = new CustomerManagementProxy();

        final Customer customerJohn = new Customer("John", "Doe", new Date(551545), new Address("Maxmillerstraße", 78956, "Buxdehude"));
        final Address address = new Address("Eichendorffstr", 88097 ,"Eriskirch");
        final Date date = new Date(new Date().getTime());
        final Customer customerJonas = new Customer("Jonas", "Hoffmann",date, address );

        //work with the necessary objects
        cmp.listCustomers().line();
        cmp.listCustomer(1).line();
        cmp.createCustomer(customerJohn).line();
        cmp.updateCustomer(customerJonas,1).line();
        cmp.deleteCustomer(1).line();
        cmp.listCustomers().line();
    }
}
