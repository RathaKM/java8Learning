package java8.account;

import java8.util.BankUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AccountTest {

    @Test
    public void testSearchAccountsWithBalance() {
        List<Account> accounts = BankUtil.getAccounts();
        List<Account> searchedAccounts = BankUtil.searchAccountsWithBalance(accounts, 1000);
        Assert.assertEquals(4, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithBalanceRange() {
        List<Account> accounts = BankUtil.getAccounts();
        List<Account> searchedAccounts = BankUtil.searchAccountsWithBalanceRange(accounts, 1000, 3000);
        Assert.assertEquals(2, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithCustomFuncInterface() {
        List<Account> accounts = BankUtil.getAccounts();
        //using Inner class
        class TestAccountImpl implements TestAccount {
            @Override
            public boolean test(Account a) {
                return (a.getBalance() >= 1000 && a.getBalance() <= 3000);
            }
        }
        List<Account> searchedAccounts = BankUtil.searchAccountsWithCustomFuncInterface(accounts, new TestAccountImpl());
        Assert.assertEquals(2, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithCustomFuncIntWithAnonymousClass() {
        List<Account> accounts = BankUtil.getAccounts();
        //using Anonymous Inner class
        List<Account> searchedAccounts = BankUtil.searchAccountsWithCustomFuncInterface(accounts, new TestAccount() {
            @Override
            public boolean test(Account a) {
                return (a.getBalance() >= 2000 && a.getBalance() <= 5000);
            }
        });
        Assert.assertEquals(4, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithJava8FuncInterface() {
        List<Account> accounts = BankUtil.getAccounts();
        //using Lambda
        List<Account> searchedAccounts = BankUtil.searchAccountsWithJava8FuncInterface(accounts, a -> a.getBalance() >= 2000 && a.getBalance() <= 5000 && a.getGender() == Gender.FEMALE);
        Assert.assertEquals(2, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithCustomFuncIntWithLambda() {
        List<Account> accounts = BankUtil.getAccounts();
        //using more Lambdas
        List<Account> searchedAccounts = BankUtil.searchAccountsWithCustomFuncInterface(accounts, a -> a.getBalance() >= 2000 && a.getBalance() <= 5000 && a.getGender() == Gender.MALE, a -> System.out.println(a));
        Assert.assertEquals(2, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithJava8FuncIntWithLambda() {
        List<Account> accounts = BankUtil.getAccounts();
        //using more Lambdas
        List<Account> searchedAccounts = BankUtil.searchAccountsWithJava8FuncInterface(accounts, a -> a.getBalance() >= 2000 && a.getBalance() <= 5000 && a.getGender() == Gender.MALE, a -> System.out.println(a));
        Assert.assertEquals(2, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithCustomFuncIntWithMoreLambda() {
        List<Account> accounts = BankUtil.getAccounts();
        //using more Lambdas
        List<Account> searchedAccounts = BankUtil.searchAccountsWithCustomFuncInterface(accounts, a -> a.getBalance() >= 2000 && a.getBalance() <= 5000 && a.getGender() == Gender.MALE, a -> a.getAccountName(), accName -> System.out.println(accName));
        Assert.assertEquals(2, searchedAccounts.size());
    }

    @Test
    public void testSearchAccountsWithJava8FuncIntWithMoreLambda() {
        List<Account> accounts = BankUtil.getAccounts();
        //using more Lambdas
        List<Account> searchedAccounts = BankUtil.searchAccountsWithJava8FuncInterface(accounts, a -> a.getBalance() >= 2000 && a.getBalance() <= 5000 && a.getGender() == Gender.MALE, a -> a.getAccountName(), accName -> System.out.println(accName));
        Assert.assertEquals(2, searchedAccounts.size());
    }

    @Test
    public void testSearchUsingStreams() {
        List<String> searchedAccounts = BankUtil.searchUsingStreams();
        Assert.assertEquals(2, searchedAccounts.size());
        Assert.assertEquals(Arrays.asList("B", "C"), searchedAccounts);
    }

    @Test
    public void testSearchUsingStreamsInDeclarativeWay() {
        List<String> searchedAccounts = BankUtil.searchUsingStreamsInDeclarativeWay();
        Assert.assertEquals(2, searchedAccounts.size());
        Assert.assertEquals(Arrays.asList("A", "D"), searchedAccounts);
    }

    @Test
    public void testSearchUsingStreamsInDeclarativeAndGenericWay() {
        List<String> searchedAccounts = BankUtil.searchUsingStreamsInDeclarativeAndGenericWay();
        Assert.assertEquals(2, searchedAccounts.size());
        Assert.assertEquals(Arrays.asList("A", "D"), searchedAccounts);
    }
}
