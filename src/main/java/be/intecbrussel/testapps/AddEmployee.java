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
        EmployeeDao  employeeDao = new EmployeeDaoJpaImpl();
        Employee employee = new Employee(9000, "Coek", "Mark", "x145255", "coek@hotmail.com", 1, 1002, "java developer");
        employeeDao.createEmployee(employee);
    }
}
