package de.thro.inf.vv.restfulwebservice.CrudInterfaces;

import de.thro.inf.vv.restfulwebservice.Class.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
public interface ICustomerManagement extends CrudRepository<Customer, Long> {


}
