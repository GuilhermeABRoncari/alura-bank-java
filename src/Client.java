public class Client {
    private String name;
    private String accountType;
    private double Amount;

    public Client(String name, String accountType, double Amount) {
        this.name = name;
        this.accountType = accountType;
        this.Amount = Amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        this.Amount = amount;
    }
}
