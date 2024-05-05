public class CokeDispenseHandler extends SnackDispenseHandler {
    public CokeDispenseHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName().equals("Coke")) {
            System.out.println("Dispensing a nice Coke!");
        } else {
            System.out.println("System passed chain from Coke...");
            super.dispenseSnack(snack);
        }
    }
}
