public class DispensingSnackState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("Already dispensing a snack");
    }

    public void insertMoney(VendingMachine vendingMachine, double money) {
        System.out.println("Already dispensing a snack");
    }

    public void cancelSelection(VendingMachine vendingMachine) {
        System.out.println("Already dispensing a snack");
    }

    public void dispenseSnack(VendingMachine vendingMachine) {
        Snack snack = vendingMachine.getSnacks().get(vendingMachine.getSelectedSnack());
        if (snack.getQuantity() > 0) {
            snack.setQuantity(snack.getQuantity()-1);
            VendingMachine.getSnackChain().dispenseSnack(snack);
        }
        vendingMachine.setState(new IdleState());
    }
}