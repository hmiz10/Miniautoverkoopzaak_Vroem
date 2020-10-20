package be.intecbrussel.entities;

import be.intecbrussel.model.Office;
import be.intecbrussel.model.Order;

public interface OrderDao {
        void createOrder(Order order);
        Order readOrder(int orderNumber);
        void updateOrder(Order order);
        void deleteOrder(Order order);
}
