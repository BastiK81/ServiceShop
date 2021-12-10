import java.util.Scanner;

public class InputManager {

    /* Willkommensnachricht
   neues Produkt anlegen , alle Produkte ausgeben, neue Order anlegen , Order ein Produkt hinzufügen
   , alle Order anzeigen , Exit
    */

    private Scanner scanner = new Scanner(System.in);
    private ShopService shopService;

    public InputManager(ShopService shopService) {
        this.shopService = shopService;
    }

    public void run() {
        System.out.println("Willkommen");
        boolean isActive = true;
        while (isActive) {
            System.out.println("0 - Exit");
            System.out.println("1 - neues Produkt anlegen");
            System.out.println("2 - alle Produkte anzeigen");
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
                    default:
                        System.out.println("i liegt nicht zwischen null und drei");
                        break;
                }
            }
        }
    }
}