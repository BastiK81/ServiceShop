package products;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {

    private int productId = 0;

    private Map<Integer, Product> products = new HashMap<>();

    public Product getProduct(int key) {
        return products.get(key);
    }

    public boolean addProduct(String name) {
//       List<Product> filter = products.values().stream().filter(product -> product.getName().equalsIgnoreCase(name)).toList(); //Streamfilter für die Map zum testen/probieren
        for (Product product : products.values()
        ) {
            if (product.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        productId++;
        Product product = new Product(productId, name);
        products.put(product.getId(), product);
        return true;
    }

    public Map<Integer, Product> getProductList() {
        return products;
    }

}
