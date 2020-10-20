package be.intecbrussel.entities;

import be.intecbrussel.model.Order;
import be.intecbrussel.model.OrderDetail;
import be.intecbrussel.model.Payment;

public interface OrderDetailDao {

    void createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(int orderNumber);
    void updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(OrderDetail orderDetail);
}
