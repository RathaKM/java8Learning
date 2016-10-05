package java8.account;

public class CheckingAccount extends Account {
    private double creditLimit;

    public CheckingAccount(String accName, double bal, double creditLimit, Gender gender) {
        super(accName, bal, gender);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amt) throws Exception {
        if (balance + creditLimit - amt >= 0) {
            throw new Exception("Insufficient Fund Exception");
        }
    }
}
