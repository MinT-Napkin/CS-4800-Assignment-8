import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnackDispenserHandlerTest {

    @Test
    public void testCheetosDispenseHandler() {
        testDispenseHandler(new CheetosDispenseHandler(null), "Cheetos", "Dispensing a bag of Cheetos!");
    }

    @Test
    public void testCokeDispenseHandler() {
        testDispenseHandler(new CokeDispenseHandler(null), "Coke", "Dispensing a nice Coke!");
    }

    @Test
    public void testDoritosDispenseHandler() {
        testDispenseHandler(new DoritosDispenseHandler(null), "Doritos", "Dispensing a Doritos Bag!");
    }

    @Test
    public void testKitKatDispenseHandler() {
        testDispenseHandler(new KitKatDispenseHandler(null), "KitKat", "Dispensing a KitKat bar!");
    }

    @Test
    public void testPepsiDispenseHandler() {
        testDispenseHandler(new PepsiDispenseHandler(null), "Pepsi", "Dispensing a fizzy Pepsi!");
    }

    @Test
    public void testSnickersDispenseHandler() {
        testDispenseHandler(new SnickersDispenseHandler(null), "Snickers", "Dispensing a Snickers bar, you're not you without a Snickers!");
    }

    private void testDispenseHandler(SnackDispenseHandler handler, String snackName, String expectedOutput) {
        Snack snack = new Snack(snackName, 1.00, 5);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        handler.dispenseSnack(snack);

        String actualOutput = outContent.toString().replaceAll("\\r\\n", "\n");
        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n");
        assertEquals(expectedOutput + "\n", actualOutput);
        System.setOut(System.out);
    }
}