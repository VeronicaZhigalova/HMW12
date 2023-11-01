package org.coolorg.service;

import lombok.Data;


import org.coolorg.database.CustomerRepository;
import org.coolorg.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.mockito.Mockito;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@Data

public class CustomerServiceTest {

    private CustomerService customerService;


    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
    }


    @Test
    void testGetById() {
        int customerId = 10;
        Customer customer = new Customer(customerId, "Anna");

        when(customerRepository.getCustomerById(customerId)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerRepository.getCustomerById(customerId);
        assertTrue(result.isPresent());
    }


    @Test
    void testCreateCustomer() {

        Customer customer = new Customer(1, "John");

        when(customerRepository.getCustomerById(customer.getId())).thenReturn(Optional.empty());

        customerRepository.addCustomer(new Customer());
    }


    @Test
    void testRemoveCustomer() {

        Customer customer = new Customer();

        when(customerRepository.getCustomerById(customer.getId())).thenReturn(Optional.of(customer));

        customerRepository.removeCustomer(customer.getId());

    }
}




