public class CheetosDispenseHandler extends SnackDispenseHandler {

    public CheetosDispenseHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName().equals("Cheetos")) {
            System.out.println("Dispensing a bag of Cheetos!");
        } else {
            System.out.println("System passed chain from Cheetos...");
            super.dispenseSnack(snack);
        }
    }
}
