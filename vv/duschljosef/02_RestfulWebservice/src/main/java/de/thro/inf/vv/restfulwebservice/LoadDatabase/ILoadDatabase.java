package de.thro.inf.vv.restfulwebservice.LoadDatabase;

import de.thro.inf.vv.restfulwebservice.Class.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import de.thro.inf.vv.restfulwebservice.Class.Address;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;



public interface ILoadDatabase extends JpaRepository<Customer, Long> {
}
