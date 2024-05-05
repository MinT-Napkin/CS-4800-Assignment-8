public class IdleState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine vendingMachine, String snackName) {

        vendingMachine.setSelectedSnack(snackName);

        if(vendingMachine.getSelectedSnackFromMap().getQuantity() > 0)
        {
            vendingMachine.setState(new WaitingForMoneyState());
        }
        else {
            System.out.println(snackName + " out of stock. Please choose another snack!");
            vendingMachine.setSelectedSnack(null);
        }
    }

    public void insertMoney(VendingMachine vendingMachine, double money) {
        System.out.println("Please select a snack first!");
    }

    public void cancelSelection(VendingMachine vendingMachine) {
        System.out.println("Please select a snack first!");
    }

    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please select a snack first!");
    }
}
