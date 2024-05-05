public class KitKatDispenseHandler extends SnackDispenseHandler {

    public KitKatDispenseHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName().equals("KitKat")) {
            System.out.println("Dispensing a KitKat bar!");
        } else {
            System.out.println("System passed chain from KitKat...");
            super.dispenseSnack(snack);
        }
    }
}

