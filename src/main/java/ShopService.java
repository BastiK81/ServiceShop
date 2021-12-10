
import orders.Order;
import orders.OrderRepo;
import products.Product;
import products.ProductRepo;

public class ShopService {

    private OrderRepo orderRepo;
    private ProductRepo productRepo;

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public boolean addProduct(String name) {
        return productRepo.addProduct(name);
    }

    public Product getProductById(int id) {
        return productRepo.getProduct(id);
    }

    public String getAllProducts() {
        StringBuilder stringBuilder = new StringBuilder("Product List:\n");
        for (Product product:productRepo.getProductList().values()
             ) {
            stringBuilder.append(product.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Order addNewOrder() {
        return orderRepo.addNewOrder();
    }

    public Order getOrderById(int id) {
        return orderRepo.getOrder(id);
    }

    public String getAllOrders() {
        StringBuilder stringBuilder = new StringBuilder("Order List:\n");
        for (Order order:orderRepo.getOrderList().values()
        ) {
            stringBuilder.append(order.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void addProductToOrder (Order order, Product product) {
        order.addProduct(product);
    }

    public boolean hasProducts() {
        return this.productRepo.getProductList().size() > 0;
    }

    public boolean hasOrders() {
        return this.orderRepo.getOrderList().size() > 0;
    }

    public String getOrderToString(Order order) {
        return this.orderRepo.getOrder(order.getId()).toString();
    }
}
