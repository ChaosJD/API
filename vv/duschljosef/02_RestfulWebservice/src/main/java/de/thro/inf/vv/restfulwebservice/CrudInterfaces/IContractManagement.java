package de.thro.inf.vv.restfulwebservice.CrudInterfaces;

import de.thro.inf.vv.restfulwebservice.Class.Contract;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
public interface IContractManagement extends CrudRepository<Contract, Long> {

}
