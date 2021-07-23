package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;

    private String street;
    private String city;
    private String postcode;

    public Address() {
    }

    public Address(String street, String city, String postCode) {
        this.street = street;
        this.city = city;
        this.postcode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return " Address:" +
                "Street='" + street + '\'' +
                ", City='" + city + '\'' +
                ", PostCode='" + postcode;
    }
}
