package main.orders;

import main.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private final int id;
    private Map<Integer, Product> products = new HashMap<>();

    public Order(int id, Map<Integer, Product> products) {
        this.id = id;
        this.products = products;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void addProduct (Product product){
        products.put(product.getId(),product);
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
