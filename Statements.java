

public class Statements {

    private int transID;
    private String debCred;
    private double amount;
    private int accNumber;

    public Statements(int transID, String debCred, double amount, int accNumber) {
        this.transID = transID;
        this.debCred = debCred;
        this.amount = amount;
        this.accNumber = accNumber;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public String getDebCred() {
        return debCred;
    }

    public void setDebCred(String debCred) {
        this.debCred = debCred;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public String toString() {
        return transID + " : " + debCred + " : $" + String.format("%.2f",amount);
    }

}