import orders.Order;

import java.util.Scanner;

public class InputManager {

    /* Willkommensnachricht
   neues Produkt anlegen , alle Produkte ausgeben, neue Order anlegen , Order ein Produkt hinzufügen
   , alle Order anzeigen , Exit
    */

    private Scanner scanner = new Scanner(System.in);
    private ShopService shopService;
    private Order order = null;
    private boolean isActive = true;

    public InputManager(ShopService shopService) {
        this.shopService = shopService;
    }

    public void run() {
        System.out.println("Willkommen");
        while (isActive) {
            consolenLog();
        }
    }

    private void consolenLog() {
        printMain();
        String input = scanner.next();
        int inputNumber = checkInputToInteger(input);
        if (input.length() == 1 || (inputNumber > 5) || (inputNumber < 1)) {
            return;
        }
        switch (inputNumber) {
            case 0:
                endInput();
                break;
            case 1:
                addNewProduct();
//                      break; //absichtlicher fallthrough
            case 2:
                System.out.println(shopService.getAllProducts());
                break;
            case 3:
                this.order = shopService.addNewOrder();
                System.out.println("Order " + order.getId() + " angelegt");
            case 4:
                if (!shopService.hasProducts() || !shopService.hasOrders()) {
                    System.out.println("Keine Produkte vorhanden");
                    break;
                }
                if (this.order == null) {
                    System.out.println("Bitte Order angeben");
                    String orderId = scanner.next();
                    int orderNumber = 0;
                    try {
                        orderNumber = Integer.parseInt(orderId);
                    } catch (NumberFormatException e) {
                        System.out.println("Falsches Format " + e);
                    }
                    this.order = shopService.getOrderById(orderNumber);
                }
                System.out.println(shopService.getOrderToString(this.order));
                System.out.println(shopService.getAllProducts());
                System.out.print("Produkt Nummer eingeben: ");
                int productNumber = checkInputToInteger(scanner.next());
                if (productNumber == 0 ){
                    break;
                }
                shopService.addProductToOrder(this.order, shopService.getProductById(productNumber));
                this.order = null;
            case 5:
                System.out.println(shopService.getAllOrders());
                break;
            default:
                System.out.println("i liegt nicht zwischen null und drei");
                break;
        }
    }

    private void addNewProduct() {
        boolean weiter = true;
        while (weiter) {
            System.out.println("Produkt wird angelegt bitte Namen angeben");
            String inputName = this.scanner.next();
            if(shopService.addProduct(inputName)){
                System.out.println("Produkt wurde angelegt");
            } else {
                System.out.println("Produkt schon vorhanden!");
            }
            System.out.println("Weitere Produkte anlegen?");
            System.out.println("1 = Ja, sons nein");
            if (!(checkInputToInteger(scanner.next()) == 1)) {
                weiter = false;
            }
        }

    }

    private void endInput() {
        System.out.println("Programm wird beendet");
        this.isActive = false;
    }

    private void printMain() {
        System.out.println("0 - Exit");
        System.out.println("1 - Neues Produkt anlegen");
        System.out.println("2 - Alle Produkte anzeigen");
        System.out.println("3 - Neue Order anlegen");
        System.out.println("4 - Produkt zu Order hinzufügen");
        System.out.println("5 - Alle Orders anzeigen");
    }

    public int checkInputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}