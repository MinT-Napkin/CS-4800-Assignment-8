import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

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
    public void testInsertMoneyReturningChange() {
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(2.00);
        assertEquals(0.00, vendingMachine.getInsertedMoney());
    }

    @Test
    public void testSelectSnack() {
        vendingMachine.selectSnack("Coke");
        assertEquals("Coke", vendingMachine.getSelectedSnack());
    }

    @Test
    public void testCancelSelection() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.cancelSelection();
        assertNull(vendingMachine.getSelectedSnack());
    }

    @Test
    public void testDispenseSnack() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        assertEquals(3, vendingMachine.getSnacks().get("Coke").getQuantity());
    }

    @Test
    public void testGetSelectedSnackFromMap() {
        vendingMachine.setSelectedSnack("Coke");
        assertEquals("Coke", vendingMachine.getSelectedSnackFromMap().getName());
    }
}
