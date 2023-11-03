package org.coolorg.service;


import org.coolorg.database.CustomerRepository;

import org.coolorg.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;


import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {


    @Mock
    private CustomerRepository customerRepository;


    private CustomerService customerService;

    @BeforeEach
    void setUp() {
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

        customerService.createCustomer(customer);
    }


    @Test
    void testRemoveCustomer() {

        Customer customer = new Customer();

        when(customerRepository.getCustomerById(customer.getId())).thenReturn(Optional.of(customer));

        customerService.removeCustomer(customer.getId());

    }
}




