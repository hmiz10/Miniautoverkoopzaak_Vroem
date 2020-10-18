package be.intecbrussel.entities;

import be.intecbrussel.model.Customer;
import be.intecbrussel.model.Employee;

public interface EmployeeDao {
    void createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    Employee readEmployee(String employeeName);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
