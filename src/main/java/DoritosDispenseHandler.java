public class DoritosDispenseHandler extends SnackDispenseHandler {

    public DoritosDispenseHandler(SnackDispenseHandler next)
    {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName().equals("Doritos")) {
            System.out.println("Dispensing a Doritos Bag!");
        } else {
            System.out.println("System passed chain from Doritos...");
            super.dispenseSnack(snack);
        }
    }
}
