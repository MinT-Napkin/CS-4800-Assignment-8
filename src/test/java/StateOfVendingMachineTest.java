import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StateOfVendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() {
        Map<String, Snack> snacks = new HashMap<>();
        snacks.put("Coke", new Snack("Coke", 1.50, 2));
        snacks.put("Pepsi", new Snack("Pepsi", 1.25, 2));
        snacks.put("Cheetos", new Snack("Cheetos", 2.00, 2));
        snacks.put("Doritos", new Snack("Doritos", 1.75, 2));
        snacks.put("KitKat", new Snack("KitKat", 1.00, 2));
        snacks.put("Snickers", new Snack("Snickers", 1.50, 2));
        vendingMachine = new VendingMachine(snacks);
    }


    @Test
    public void testIdleState() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(5);
        vendingMachine.dispenseSnack();

        assertTrue(vendingMachine.getState() instanceof IdleState);
    }

    @Test
    public void testWaitingForMoneyState() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(0.5);

        assertTrue(vendingMachine.getState() instanceof WaitingForMoneyState);
    }

    @Test
    public void testDispensingSnackState() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(5);

        assertTrue(vendingMachine.getState() instanceof DispensingSnackState);
    }
}