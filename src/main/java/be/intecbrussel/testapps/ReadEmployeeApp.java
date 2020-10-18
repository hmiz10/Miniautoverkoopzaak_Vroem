package be.intecbrussel.testapps;

import be.intecbrussel.entities.EmployeeDao;
import be.intecbrussel.entities.EmployeeDaoJpaImpl;
import be.intecbrussel.model.Employee;

public class ReadEmployeeApp {
    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoJpaImpl();
        Employee employee = employeeDao.readEmployee(1143);
        System.out.println(employee);
    }
}
