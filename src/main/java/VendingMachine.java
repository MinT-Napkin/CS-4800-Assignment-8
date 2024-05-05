import java.util.Map;

public class VendingMachine {
    private Map<String, Snack> snacks;
    private StateOfVendingMachine state;
    private String selectedSnack;
    private double insertedMoney;
    private static SnackDispenseHandler chain =
            new CokeDispenseHandler(
                    new PepsiDispenseHandler(
                            new CheetosDispenseHandler(
                                    new DoritosDispenseHandler(
                                            new KitKatDispenseHandler(
                                                    new SnickersDispenseHandler(null)
                                            )
                                    ))));
    private StringBuilder outputBuffer = new StringBuilder(); // purely for testing purposes

    public VendingMachine(Map<String, Snack> snacks) {
        this.snacks = snacks;
        this.state = new IdleState();
    }

    public Map<String, Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(Map<String, Snack> snacks) {
        this.snacks = snacks;
    }

    public StateOfVendingMachine getState() {
        return state;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public String getSelectedSnack() {
        return selectedSnack;
    }

    public Snack getSelectedSnackFromMap() {
        Snack snack = snacks.get(selectedSnack);
        return snack;
    }

    public void setSelectedSnack(String selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public void setInsertedMoney(double insertedMoney) {
        this.insertedMoney = insertedMoney;
    }

    public static SnackDispenseHandler getSnackChain() {
        return chain;
    }

    public void insertMoney(double money) {
        state.insertMoney(this, money);
    }

    public void selectSnack(String snackName) {
        state.selectSnack(this, snackName);
    }

    public void cancelSelection() {
        state.cancelSelection(this);
    }

    public void dispenseSnack() {
        state.dispenseSnack(this);
    }

    private void appendToOutput(String message) {
        outputBuffer.append(message).append("\n");
    }

    public String getOutput() {
        return outputBuffer.toString();
    }
}
