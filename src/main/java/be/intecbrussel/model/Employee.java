package be.intecbrussel.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private int officeCode;
    private int reportsTo;
    private String jobTitle;

    public Employee (){}

    public Employee(int employeeNumber, String lastName, String firstName, String extension, String email, int officeCode, int reportsTo, String jobTitle) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
        this.employeeNumber = employeeNumber;
    }


    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(int officeCode) {
        this.officeCode = officeCode;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension=" + extension +
                ", email='" + email + '\'' +
                ", officeCode=" + officeCode +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber == employee.employeeNumber &&
                officeCode == employee.officeCode &&
                reportsTo == employee.reportsTo &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(extension, employee.extension) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(jobTitle, employee.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
    }
}
