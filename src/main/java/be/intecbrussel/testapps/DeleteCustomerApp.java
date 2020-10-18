package be.intecbrussel.testapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCustomerApp {

    public static void main(String[] args) {
        String connectionString = "jdbc:mysql://localhost:3306/classicmodelsdb?serverTimezone=UTC";
        String username = "root";
        String password = "root";

        try(Connection connection = DriverManager.getConnection(connectionString, username, password)){
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM customers WHERE FIRSTNAME LIKE '%Jeff%'");
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
