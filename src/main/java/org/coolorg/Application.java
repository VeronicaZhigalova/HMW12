package org.coolorg;

import org.coolorg.database.CustomerRepository;
import org.coolorg.database.OrderRepository;
import org.coolorg.database.ProductRepository;
import org.coolorg.model.Customer;
import org.coolorg.model.Order;
import org.coolorg.model.Product;
import org.coolorg.service.CustomerService;
import org.coolorg.service.OrderService;
import org.coolorg.service.ProductService;


public class Application {

    public static void main(String[] args) {


        CustomerRepository customerRepository = new CustomerRepository(new Customer());
        OrderRepository orderRepository = new OrderRepository();
        ProductRepository productRepository = new ProductRepository();

        CustomerService customerService = new CustomerService(customerRepository);
        OrderService orderService = new OrderService(orderRepository, productRepository, customerRepository);
        ProductService productService = new ProductService(productRepository);

        customerService.getById(1);
        customerService.createCustomer(new Customer(15, "John"));
        customerService.removeCustomer(2);

        orderService.getOrderById(8);
        orderService.getOrdersByCustomer(5);
        orderService.getTotalPriceForCustomer(2);
        orderService.createOrder(new Order(15, 25, 80));
        orderService.removeOrder(8);

        productService.getById(6);
        productService.createProduct(new Product(90, "Lisa", 30));
        productService.removeProduct(7);

    }
}
