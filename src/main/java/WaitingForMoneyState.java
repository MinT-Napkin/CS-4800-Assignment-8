class WaitingForMoneyState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("Snack already selected, please insert money to receive snack or cancel selection.");
    }

    public void insertMoney(VendingMachine vendingMachine, double money) {
        System.out.println("Inserted $" + money + "...");
        vendingMachine.setInsertedMoney(vendingMachine.getInsertedMoney() + money);

        double currentMoney = vendingMachine.getInsertedMoney();
        double snackPrice = vendingMachine.getSelectedSnackFromMap().getPrice();
        if (currentMoney >= vendingMachine.getSelectedSnackFromMap().getPrice()) {
            currentMoney -= snackPrice;
            if(currentMoney > 0)
            {
                System.out.println("Giving back leftover change of: $" + currentMoney +
                        " (Snack costs: $" + snackPrice + ")");
            }
            vendingMachine.setInsertedMoney(0);
            vendingMachine.setState(new DispensingSnackState());
        } else {
            System.out.println("$" + money + " was not enough for a "
                    + vendingMachine.getSelectedSnack() +
                    ", returning change... (Snack costs: $" + vendingMachine.getSelectedSnackFromMap().getPrice() + ")");
            vendingMachine.setInsertedMoney(0);
        }
    }

    public void cancelSelection(VendingMachine vendingMachine) {
        System.out.println("Cancelling snack selection.");
        vendingMachine.setState(new IdleState());
    }

    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please insert money first");
    }
}
