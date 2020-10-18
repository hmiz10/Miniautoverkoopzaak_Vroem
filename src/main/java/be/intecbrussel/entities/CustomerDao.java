package be.intecbrussel.entities;

import be.intecbrussel.model.Customer;

public interface CustomerDao {
    void createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
    Customer readCustomer(String customerName);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
