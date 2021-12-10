package main.products;

import main.orders.Order;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo {

    private int productId = 0;

    private Map<Integer, Product> products = new HashMap<>();

    public Product getProduct(int key) {
        return products.get(key);
    }

    public Product addProduct(String name) {
        productId++;
        Product product = new Product(productId, name);
        products.put(product.getId(), product);
        return product;
    }

    public Map<Integer, Product> getProductList() {
        return products;
    }

}
