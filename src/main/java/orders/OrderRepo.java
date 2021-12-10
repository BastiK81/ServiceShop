package main.orders;

import java.util.HashMap;
import java.util.Map;

public class OrderRepo {

    private int orderID = 0;

    private final Map<Integer, Order> orders = new HashMap<>();

    public Map<Integer, Order> getOrderList() {
        return this.orders;
    }

    public Order getOrder(int id) {
        return this.orders.get(id);
    }
    
    public Order addNewOrder() {
        orderID++;
        Order order = new Order(orderID, new HashMap<>());
        this.orders.put(order.getId(), order);
        return order;
    }
}
