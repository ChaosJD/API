package de.thro.inf.vv.restfulwebservice.Class;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/09
 */

@Entity
public class Customer {

    @Version
    private long version;

    @OneToMany(cascade = CascadeType.ALL)
    @Autowired
    private List<Contract> contractList;

    @Id
    @GeneratedValue()
    private long customerNumber;
    private String firstName;
    private String secondName;
    private Date birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @Autowired
    private Address address;

    public Customer(String firstName, String secondName, Date birthday, Address address, List<Contract> contractList){
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.address = address;
        this.contractList = contractList;
    }

    public Customer(String firstName, String secondName, Date birthday, Address address){
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.address = address;
    }

    public Customer() {
    }

    /**
     * getter/setter
     */
    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "contractList=" + contractList +
                ", customerNumber=" + customerNumber +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}
