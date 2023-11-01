package org.coolorg.service;

import lombok.Data;


import org.coolorg.database.CustomerRepository;
import org.coolorg.database.OrderRepository;
import org.coolorg.database.ProductRepository;
import org.coolorg.model.Order;
import org.coolorg.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.mockito.Mock;

import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;

import static org.mockito.Mockito.when;

@Data
public class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(orderRepository, productRepository, customerRepository);
    }


    @Test
    void testGetOrderById() {
        int orderId = 1;
        Order order = new Order(5, 30, 34);

        when(orderRepository.getOrderById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.getOrderById(orderId);
        assertTrue(result.isPresent());

    }

    @Test
    void testGetOrdersByCustomer() {
        int customerId = 1;
        List<Order> expectedOrders = List.of(new Order(678, 356, 780));

        when(orderRepository.getOrdersByCustomer(customerId)).thenReturn(expectedOrders);

        List<Order> result = orderService.getOrdersByCustomer(customerId);
        assertEquals(expectedOrders, result);

    }

    @Test
    void testGetTotalPriceForCustomer() {
        int customerId = 1;
        double expectedTotalPrice = 1400.0;
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, customerId, 1));
        orders.add(new Order(2, customerId, 2));

        when(orderRepository.getOrdersByCustomer(customerId)).thenReturn(orders);
        when(productRepository.getProductById(anyInt())).thenAnswer(invocation -> {
            int id = invocation.getArgument(0);
            if (id == 1) {
                return Optional.of(new Product(1, "1", 500));
            } else {
                return Optional.of(new Product(2, "2", 900));
            }
        });


        double result = orderService.getTotalPriceForCustomer(customerId);

        assertEquals(expectedTotalPrice, result, 0.001);
    }


    @Test
    void testCreateOrder() {
        Order order = new Order(700, 450, 50);

        when(orderRepository.getOrderById(order.getId())).thenReturn(Optional.empty());

        orderRepository.addOrder(new Order());
    }

    @Test
    void testRemoveOrder() {

        Order order = new Order();

        when(orderRepository.getOrderById(order.getId())).thenReturn(Optional.of(order));

        orderRepository.removeOrder(order.getId());
    }
}

