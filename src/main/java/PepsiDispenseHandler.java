public class PepsiDispenseHandler extends SnackDispenseHandler {

    public PepsiDispenseHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName().equals("Pepsi")) {
            System.out.println("Dispensing a fizzy Pepsi!");
        } else {
            System.out.println("System passed chain from Pepsi...");
            super.dispenseSnack(snack);
        }
    }
}
