package be.intecbrussel.testapps;

import be.intecbrussel.entities.EmployeeDao;
import be.intecbrussel.entities.EmployeeDaoJpaImpl;
import be.intecbrussel.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee("Coek", "Mark", 145255, "coek@hotmail.com", 63, 1023, "java developer");
        EmployeeDao  employeeDao = new EmployeeDaoJpaImpl();
        employeeDao.createEmployee(employee);
    }
}
