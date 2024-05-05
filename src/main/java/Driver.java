import java.util.HashMap;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        Map<String, Snack> snacks = new HashMap<>();
        // all snacks have quantity of 2
        snacks.put("Coke", new Snack("Coke", 1.50, 2));
        snacks.put("Pepsi", new Snack("Pepsi", 1.25, 2));
        snacks.put("Cheetos", new Snack("Cheetos", 2.00, 2));
        snacks.put("Doritos", new Snack("Doritos", 1.75, 2));
        snacks.put("KitKat", new Snack("KitKat", 1.00, 2));
        snacks.put("Snickers", new Snack("Snickers", 1.50, 2));

        VendingMachine vendingMachine = new VendingMachine(snacks);

        System.out.println("\nGetting a Coke:");
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2);
        vendingMachine.dispenseSnack();

        System.out.println("\nGetting a Pepsi:");
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(2);
        vendingMachine.dispenseSnack();

        System.out.println("\nGetting a bag of Cheetos:");
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        System.out.println("\nGetting a bag of Doritos:");
        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        System.out.println("\nGetting a bar of KitKat:");
        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        System.out.println("\nGetting a bar of Snickers:");
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        System.out.println("\nGetting a bar of Cheetos without enough money:");
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.00);
        vendingMachine.cancelSelection();

        System.out.println("\nGetting a bar of Snickers until it hits zero quantity:");
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(100.00);
        vendingMachine.dispenseSnack();
        vendingMachine.selectSnack("Snickers"); // out of stock here

    }
}
