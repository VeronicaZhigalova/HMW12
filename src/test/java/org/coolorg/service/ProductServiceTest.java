package org.coolorg.service;

import lombok.Data;


import org.coolorg.database.ProductRepository;

import org.coolorg.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@Data
public class ProductServiceTest {

    private ProductService productService;

    @Mock
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

        Product product = new Product(1, "Alice", 15);

        when(productRepository.getProductById(product.getId())).thenReturn(Optional.empty());

        productService.createProduct(product);
    }

    @Test
    void testCreateProductFound() {
        Product product = new Product(1, "Product 1", 2.78);

        when(productRepository.getProductById(product.getId())).thenReturn(Optional.of(product));

        assertThrows(IllegalArgumentException.class, () -> {
            productService.createProduct(product);
        });
    }

    @Test
    void testRemoveProduct() {
        Product product = new Product();

        when(productRepository.getProductById(product.getId())).thenReturn(Optional.of(product));

        productService.removeProduct(product.getId());
    }

    @Test
    void testRemoveProductIsNotFound() {
        Product product = new Product(1, "San", 80);

        when(productRepository.getProductById(product.getId())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            productService.removeProduct(product.getId());
        });
    }
}
