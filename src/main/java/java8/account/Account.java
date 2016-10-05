package java8.account;

public abstract class Account {
    protected String accountName;
    protected double balance;
    protected Gender gender;

    public Account(String accName, double bal, Gender gender) {
        accountName = accName;
        balance = bal;
        this.gender = gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public abstract void withdraw(double amount) throws Exception;

    public void deposit(double amount) {
        balance = balance + amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", gender=" + gender +
                '}';
    }
}
