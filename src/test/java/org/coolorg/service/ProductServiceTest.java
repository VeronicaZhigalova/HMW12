package org.coolorg.service;

import lombok.Data;


import org.coolorg.database.ProductRepository;
import org.coolorg.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.mockito.Mockito;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@Data

public class ProductServiceTest {

    private ProductService productService;

    private ProductRepository productRepository;


    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void testGetById() {
        int productId = 20;
        Product product = new Product(productId, "Lisa", 40);

        when(productRepository.getProductById(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productRepository.getProductById(productId);
        assertTrue(result.isPresent());
    }

    @Test
    void testCreateProduct() {
        Product product = new Product(15, "John", 50);

        when(productRepository.getProductById(product.getId())).thenReturn(Optional.empty());

        productRepository.addProduct(new Product());
    }

    @Test
    void testRemoveProduct() {
        Product product = new Product();

        when(productRepository.getProductById(product.getId())).thenReturn(Optional.of(product));

        productRepository.removeProduct(product.getId());
    }
}
