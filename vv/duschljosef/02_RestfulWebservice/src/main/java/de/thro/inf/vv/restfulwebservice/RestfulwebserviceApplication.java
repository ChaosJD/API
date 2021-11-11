package de.thro.inf.vv.restfulwebservice;

import de.thro.inf.vv.restfulwebservice.Class.Address;
import de.thro.inf.vv.restfulwebservice.Class.Customer;
import de.thro.inf.vv.restfulwebservice.CrudInterfaces.ICustomerManagement;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/09
 */
@SpringBootApplication
public class RestfulwebserviceApplication {




        public static void main(String... args) {
        SpringApplication.run(RestfulwebserviceApplication.class, args);
    }
}
