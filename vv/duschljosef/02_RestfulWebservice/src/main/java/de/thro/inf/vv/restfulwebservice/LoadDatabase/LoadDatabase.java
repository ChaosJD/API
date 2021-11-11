package de.thro.inf.vv.restfulwebservice.LoadDatabase;

import de.thro.inf.vv.restfulwebservice.Class.Address;
import de.thro.inf.vv.restfulwebservice.Class.Contract;
import de.thro.inf.vv.restfulwebservice.Class.ContractOffer;
import de.thro.inf.vv.restfulwebservice.Class.Customer;
import de.thro.inf.vv.restfulwebservice.CrudInterfaces.IContractManagement;
import de.thro.inf.vv.restfulwebservice.CrudInterfaces.ICustomerManagement;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.tools.jar.CommandLine;

import java.util.Date;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
@Configuration
public class LoadDatabase{

    /**
     *                      fill the database
     * @param customerRepo  overigven Interface to communicate with the Server
     * @param contractRepo  same above
     * @return              runs with the SpringBootApplication
     */
    @Bean
    public CommandLineRunner initDatabaseCustomer(ICustomerManagement customerRepo, IContractManagement contractRepo) {
        return args -> {
            //delte Database
            customerRepo.deleteAll();


            //fill Database only with Customers
            Address firstAddress = new Address("SomeStreet", 83026, "Fürstätt");
            Address secondAddress = new Address("Wittelbachgerstreet", 83022, "Happing");
            Address thirdAddress = new Address("Goethestreet", 83085, "Unterfuerstätt");

            customerRepo.save(new Customer("Josef", "Duschl", new Date(13061989), firstAddress));
            customerRepo.save(new Customer("Max", "Mustermann", new Date(31021900), secondAddress));
            customerRepo.save(new Customer("Hilde", "Meier", new Date(1111949), thirdAddress));

            //fill Database with Contracts
            Contract contractLiability = new Contract(ContractOffer.LIABILITY, 50);
            Contract contractLegalProtection = new Contract(ContractOffer.LEGALPROTECTION, 54);
            Contract contractMotorVehicle = new Contract(ContractOffer.MOTORVEHICLEINSURANCE, 79);

            contractRepo.save(contractLiability);
            contractRepo.save(contractLegalProtection);
            contractRepo.save(contractMotorVehicle);

        };

    }
}
