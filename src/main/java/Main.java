
import orders.Order;
import orders.OrderRepo;
import products.Product;
import products.ProductRepo;

public class Main {

    public static void main(String[] args) {
        ShopService shopService = new ShopService(new OrderRepo(), new ProductRepo());
//        Product product = shopService.addProduct("Bier");
//        shopService.addProduct("Bier");
//
//        System.out.println(shopService.getAllProducts());
//
//        Order order = shopService.addNewOrder();
//        shopService.addProductToOrder(order, product);
//        shopService.addProductToOrder(order, product);
//        System.out.println(shopService.getAllOrders());

        InputManager inputManagerMain = new InputManager(shopService);
        inputManagerMain.run();

    }
}
