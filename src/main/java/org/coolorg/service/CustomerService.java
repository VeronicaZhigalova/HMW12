package org.coolorg.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.coolorg.database.CustomerRepository;
import org.coolorg.model.Customer;

import java.util.Optional;

@RequiredArgsConstructor
@Data

public class CustomerService {


    private final CustomerRepository customerRepository;


    /**
     * Получить клиента по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента.
     * @return {@link Optional}, содержащий клиента, если найден, или пустой {@link Optional}, если не найден.
     */
    public Optional<Customer> getById(int id) {
        Optional<Customer> customer = customerRepository.getCustomerById(id);
        return customer;
    }

    /**
     * Создать нового клиента и добавить его в репозиторий.
     *
     * @param customer Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором уже существует в репозитории.
     */
    public void createCustomer(Customer customer) {
        if (getById(customer.getId()).isPresent()) {
            throw new IllegalArgumentException("Customer with the same id already exists.");
        }
        customerRepository.addCustomer(customer);
    }


    /**
     * Удалить клиента по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента, которого нужно удалить.
     * @throws IllegalArgumentException Если клиент с указанным идентификатором не существует в репозитории.
     */
    public void removeCustomer(int id) {
        Optional<Customer> customer = getById(id);
        if (customer.isEmpty()) {
            throw new IllegalArgumentException("Customer with id " + id + " does not exist.");
        }
        customerRepository.removeCustomer(customer.get().getId());
    }
}






