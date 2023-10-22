package org.coolorg.database;

import org.coolorg.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Product 1", 2.78));
        products.add(new Product(2, "Product 2", 5.50));
        products.add(new Product(3, "Product 3", 1));
        products.add(new Product(4, "Product 4", 3.0));
        products.add(new Product(5, "Product 5", 100));
        products.add(new Product(6, "Product 6", 54.32));
        products.add(new Product(7, "Product 7", 16));
        products.add(new Product(8, "Product 8", 19));
        products.add(new Product(9, "Product 9", 6));
        products.add(new Product(10, "Product 10", 7));
    }

    public Optional<Product> getProductById(int productId) {
        return products.stream().filter(product -> product.getId() == productId).findFirst();
    }

    public Optional<Product> getProductByName(String name) {
        return products.stream().filter(product -> product.getName().equals(name)).findFirst();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }
}
