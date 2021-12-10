import orders.Order;
import orders.OrderRepo;
import org.junit.jupiter.api.Test;
import products.ProductRepo;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void testAddProductTrue() {
        ShopService service = new ShopService(new OrderRepo(), new ProductRepo());
        service.addProduct("Bier");
        assertEquals("Bier", service.getProductById(1).getName());
    }

    @Test
    void getProductById() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void addNewOrder() {
    }

    @Test
    void getOrderById() {
    }

    @Test
    void getAllOrders() {
    }

    @Test
    void addProductToOrder() {
    }
}