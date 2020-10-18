package be.intecbrussel.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private double phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private int postalCode;
    private String country;
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee salesRepEmployeeNumber;
    private BigDecimal creditLimit;

    public Customer() {}

    public Customer(String customerName, String contactLastName, String contactFirstName, double phone, String addressLine1, String addressLine2, String city, String state, int postalCode, String country, BigDecimal creditLimit) {
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.creditLimit = creditLimit;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public Employee getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Employee salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", phone=" + phone +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                ", salesRepEmployeeNumber=" + salesRepEmployeeNumber +
                ", creditLimit=" + creditLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerNumber == customer.customerNumber &&
                Double.compare(customer.phone, phone) == 0 &&
                postalCode == customer.postalCode &&
                salesRepEmployeeNumber == customer.salesRepEmployeeNumber &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(contactLastName, customer.contactLastName) &&
                Objects.equals(contactFirstName, customer.contactFirstName) &&
                Objects.equals(addressLine1, customer.addressLine1) &&
                Objects.equals(addressLine2, customer.addressLine2) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(state, customer.state) &&
                Objects.equals(country, customer.country) &&
                Objects.equals(creditLimit, customer.creditLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
    }
}
