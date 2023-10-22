package org.coolorg.database;

import org.coolorg.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        // some test data
        customers.add(new Customer(1, "Bob"));
        customers.add(new Customer(2, "Alice"));
        customers.add(new Customer(4, "Michael"));
        customers.add(new Customer(5, "John"));
        customers.add(new Customer(9, "Mary"));
        customers.add(new Customer(10, "Kate"));
    }

    public Optional<Customer> getCustomerById(int customerId) {
        return customers.stream().filter(customer -> customer.getId() == customerId).findFirst();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(int customerId) {
        customers.removeIf(customer -> customer.getId() == customerId);
    }

}
