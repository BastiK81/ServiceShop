import orders.OrderRepo;
import org.junit.jupiter.api.Test;
import products.ProductRepo;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {

    @Test
    void testCheckInputToIntegerWithNumberTrue() {
        InputManager inputManager = new InputManager(new ShopService(new OrderRepo(), new ProductRepo()));
        assertEquals(1, inputManager.checkInputToInteger("1"));
    }

    @Test
    void testCheckInputToIntegerWhitTextTrue() {
        InputManager inputManager = new InputManager(new ShopService(new OrderRepo(), new ProductRepo()));
        assertEquals(0, inputManager.checkInputToInteger("asdasd"));
    }

    @Test
    void testCheckInputToIntegerWithNumberFalse() {
        InputManager inputManager = new InputManager(new ShopService(new OrderRepo(), new ProductRepo()));
        assertNotEquals(2, inputManager.checkInputToInteger("1"));
    }

    @Test
    void testCheckInputToIntegerWhitTextFalse() {
        InputManager inputManager = new InputManager(new ShopService(new OrderRepo(), new ProductRepo()));
        assertNotEquals(1, inputManager.checkInputToInteger("asdasd"));
    }

}