package be.intecbrussel.entities;

import be.intecbrussel.model.Order;
import be.intecbrussel.model.Payment;

public interface PaymentDao {
    void createPayment(Payment payment);
    Payment readPayment(int customerNumber);
    void updatePayment(Payment payment);
    void deletePayment(Payment payment);
}
