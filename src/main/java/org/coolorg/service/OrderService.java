package org.coolorg.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.coolorg.database.OrderRepository;
import org.coolorg.database.ProductRepository;
import org.coolorg.model.Customer;
import org.coolorg.model.Order;
import org.coolorg.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Data
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final CustomerService customerService;


    /**
     * Получить заказ по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор заказа.
     * @return {@link Optional}, содержащий заказ, если найден, или пустой {@link Optional}, если не найден.
     */
    public Optional<Order> getOrderById(int id) {
        Optional<Order> order = orderRepository.getOrderById(id);
        return order;
    }


    /**
     * Получить список заказов, связанных с конкретным клиентом.
     *
     * @param customerId Уникальный идентификатор клиента.
     * @return Список заказов, связанных с клиентом.
     */
    public List<Order> getOrdersByCustomer(int customerId) {
        Optional<Customer> order = customerService.getById(customerId);
        if (order.isPresent()) {
            return orderRepository.getOrdersByCustomer(customerId);
        }

        return new ArrayList<>();
    }




    /**
     * Рассчитать общую стоимость всех заказов для конкретного клиента.
     *
     * @param customerId Уникальный идентификатор клиента.
     * @return Общая стоимость всех заказов для клиента.
     */
    public double getTotalPriceForCustomer(int customerId) {
        List<Order> orders = orderRepository.getOrdersByCustomer(customerId);
        double totalPrice = 0.0;
        for (Order order : orders) {
            Optional<Product> product = productRepository.getProductById(order.getProductId());
            if (product.isPresent()) {
                totalPrice += product.get().getPrice();
            }
        }
        return totalPrice;

    }

    /**
     * Создать новый заказ и добавить его в репозиторий.
     *
     * @param order Заказ, который нужно создать и добавить.
     * @throws IllegalArgumentException Если заказ уже существует в репозитории.
     */
    public void createOrder(Order order) {
        if (getOrderById(order.getId()).isPresent()) {
            throw new IllegalArgumentException("Order with the same id already exists.");
        }
        orderRepository.addOrder(order);
    }

    /**
     * Удалить заказ по его уникальному идентификатору.
     *
     * @param orderId Уникальный идентификатор заказа, который нужно удалить.
     * @throws IllegalArgumentException Если заказ с указанным идентификатором не существует в репозитории.
     */
    public void removeOrder(int orderId) {
        Optional<Order> order = getOrderById(orderId);
        if (order.isEmpty()) {
            throw new IllegalArgumentException("Order with id " + orderId + " does not exist.");
        }
        orderRepository.removeOrder(order.get().getId());

    }
}
