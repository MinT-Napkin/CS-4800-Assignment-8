public class SnickersDispenseHandler extends SnackDispenseHandler {

    public SnickersDispenseHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName().equals("Snickers")) {
            System.out.println("Dispensing a Snickers bar, you're not you without a Snickers!");
        } else {
            System.out.println("System passed chain from Snickers...");
            super.dispenseSnack(snack);
        }
    }
}

