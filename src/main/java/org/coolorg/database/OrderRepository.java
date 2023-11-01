package org.coolorg.database;

import org.coolorg.model.Order;
import org.coolorg.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public OrderRepository() {

    }

    public OrderRepository(OrderService orderService) {
        // some test data
        orders.add(new Order(1, 1, 1));
        orders.add(new Order(2, 1, 2));
        orders.add(new Order(3, 2, 3));
        orders.add(new Order(4, 2, 2));
        orders.add(new Order(5, 2, 1));
        orders.add(new Order(6, 9, 4));
        orders.add(new Order(7, 4, 5));
    }

    public Optional<Order> getOrderById(int orderId) {
        return orders.stream().filter(order -> order.getId() == orderId).findFirst();
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        return orders.stream().filter(order -> order.getCustomerId() == customerId).toList();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getId() == orderId);
    }
}
