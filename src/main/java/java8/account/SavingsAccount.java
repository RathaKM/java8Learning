package java8.account;


public class SavingsAccount extends Account {
    private double minimumBalance;

    public SavingsAccount(String accName, double bal, double minBal, Gender gender) {
        super(accName, bal, gender);
        minimumBalance = minBal;
    }

    @Override
    public void withdraw(double amt) throws Exception {
        if (balance - amt < minimumBalance) {
            throw new Exception("Insufficient Fund Exception");
        }
    }
}
