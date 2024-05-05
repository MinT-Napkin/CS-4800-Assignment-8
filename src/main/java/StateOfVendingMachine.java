public interface StateOfVendingMachine {
    void insertMoney(VendingMachine vendingMachine, double money);

    void selectSnack(VendingMachine vendingMachine, String snackName);

    void cancelSelection(VendingMachine vendingMachine);

    void dispenseSnack(VendingMachine vendingMachine);
}