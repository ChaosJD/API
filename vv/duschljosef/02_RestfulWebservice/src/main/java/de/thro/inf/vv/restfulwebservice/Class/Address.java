package de.thro.inf.vv.restfulwebservice.Class;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/09
 */

//@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
public class Address {
//    @OneToOne
//    @PrimaryKeyJoinColumn
//    private Customer customer;

    @Version
    private long version;

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private int postCode;
    private String placeOfResidence;

    public Address( String street, int postCode, String placeOfResidence){
        this.street = street;
        this.postCode = postCode;
        this.placeOfResidence = placeOfResidence;
    }

    public Address() {
    }

    /**
     * getter/setter
     */
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    @Override
    public String toString() {
        return "Address{" +
                "version=" + version +
                ", id=" + id +
                ", street='" + street + '\'' +
                ", postCode=" + postCode +
                ", placeOfResidence='" + placeOfResidence + '\'' +
                '}';
    }
}
