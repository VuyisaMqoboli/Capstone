package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/* Pizzeria.java
   Entity for the Customer
   Author: Keenan Meyer (220194920)
   Date: 30th March 2023
*/
@Entity
public class Customer implements Serializable{
    @Id
    protected Integer customerID;
    protected String customerName;
    protected String customerSurname;
    protected String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    //@ManyToMany(cascade = CascadeType.ALL)
    protected Address address;


    protected Customer(){
    }

    public Customer(Integer customerID,String customerName,String customerSurname,String phoneNumber,Address address){
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    protected Customer(Builder builder){
        this.customerID = builder.customerID;
        this.customerName = builder.customerName;
        this.customerSurname = builder.customerSurname;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }


    public static class Builder {
        private Integer customerID;
        private String customerName;
        private String customerSurname;
        private String phoneNumber;
        private Address address;

        public Builder setCustomerID(Integer customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerSurname(String customerSurname) {
            this.customerSurname = customerSurname;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(Address address){
            this.address = address;
            return this;
        }

        public Builder copy(za.ac.cput.domain.Customer t) {
            this.customerID = t.customerID;
            this.customerName = t.customerName;
            this.customerSurname = t.customerSurname;
            this.phoneNumber = t.phoneNumber;
            this.address = t.address;
            return this;
        }
        public za.ac.cput.domain.Customer build() {
            return new za.ac.cput.domain.Customer(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID) && Objects.equals(customerName, customer.customerName) && Objects.equals(customerSurname, customer.customerSurname) && Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, customerName, customerSurname, phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
