import orders.Order;

import java.util.Scanner;

public class InputManager {

    /* Willkommensnachricht
   neues Produkt anlegen , alle Produkte ausgeben, neue Order anlegen , Order ein Produkt hinzufügen
   , alle Order anzeigen , Exit
    */

    private Scanner scanner = new Scanner(System.in);
    private ShopService shopService;
    private Order order;

    public InputManager(ShopService shopService) {
        this.shopService = shopService;
    }

    public void run() {
        System.out.println("Willkommen");
        boolean isActive = true;
        while (isActive) {
            System.out.println("0 - Exit");
            System.out.println("1 - Neues Produkt anlegen");
            System.out.println("2 - Alle Produkte anzeigen");
            System.out.println("3 - Neue Order anlegen");
            System.out.println("4 - Produkt zu Order hinzufügen");

            String input = scanner.next();
            if (input.length() == 1) {
                int inputNumber = 0;
                try {
                    inputNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("falsches Format " + e);
                }

                switch (inputNumber) {
                    case 0:
                        System.out.println("Programm wird beendet");
                        isActive = false;
                        break;
                    case 1:
                        System.out.println("Produkt wird angelegt bitte Namen angeben");
                        String inputName = scanner.next();
                        if(shopService.addProduct(inputName)){
                            System.out.println("Produkt wurde angelegt");
                        } else {
                            System.out.println("Produkt schon vorhanden!");
                        }

//                      break; //absichtlicher fallthrough
                    case 2:
                        System.out.println(shopService.getAllProducts());
                        break;
                    case 3:
                        this.order = shopService.addNewOrder();
                        System.out.println("Order " + order.getId() + " angelegt");
                    case 4:
                        System.out.println(shopService.getAllProducts());
                        System.out.print("Produkt Nummer eingeben: ");
                        String productID = scanner.next();
                        int productNumber = 0;
                        try {
                            productNumber = Integer.parseInt(productID);
                        } catch (NumberFormatException e) {
                            System.out.println("Falsches Format " + e);
                        }

                        shopService.addProductToOrder(this.order, shopService.getProductById(productNumber));

                    default:
                        System.out.println("i liegt nicht zwischen null und drei");
                        break;
                }
            }
        }
    }
}