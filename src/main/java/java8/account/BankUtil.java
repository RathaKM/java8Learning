package java8.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class BankUtil {

    public static List<Account> getAccounts() {
        List<Account> accounts = Arrays.asList(new SavingsAccount("A", 2000, 500, Gender.FEMALE), new CheckingAccount("B", 4000, 5000, Gender.MALE), new SavingsAccount("C", 3000, 500, Gender.MALE), new CheckingAccount("D", 5000, 5000, Gender.FEMALE));
        return accounts;
    }

    //simple search criteria
    public static List<Account> searchAccountsWithBalance(List<Account> accounts, double balance) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (a.getBalance() >= balance) {
                System.out.println(a);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    //adding more search criteria
    public static List<Account>  searchAccountsWithBalanceRange(List<Account> accounts, double lowBal, double highBal) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (a.getBalance() >= lowBal && a.getBalance() <= highBal) {
                System.out.println(a);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    //with custom Functional interface
    public static List<Account> searchAccountsWithCustomFuncInterface(List<Account> accounts, TestAccount tester) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (tester.test(a)) {
                System.out.println(a);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    //with Java8 Functional interface for replacing TestAccount
    public static List<Account> searchAccountsWithJava8FuncInterface(List<Account> accounts, Predicate<Account> tester) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (tester.test(a)) {
                System.out.println(a);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    //with custom Functional interface for replacing Sysout
    public static List<Account> searchAccountsWithCustomFuncInterface(List<Account> accounts, Predicate<Account> tester, PrintAccount consumer) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (tester.test(a)) {
                consumer.accept(a);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    //with Java8 Functional interface for replacing Sysout
    public static List<Account> searchAccountsWithJava8FuncInterface(List<Account> accounts, Predicate<Account> tester, Consumer<Account> consumer) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (tester.test(a)) {
                consumer.accept(a);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    //with Java8 Functional interface for fetching and displaying specific details
    public static List<Account> searchAccountsWithCustomFuncInterface(List<Account> accounts, Predicate<Account> tester, FetchAccountInfo mapper, Consumer<String> consumer) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (tester.test(a)) {
                String data = mapper.apply(a);
                consumer.accept(data);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    //with Java8 Functional interface for fetching and displaying specific details
    public static List<Account> searchAccountsWithJava8FuncInterface(List<Account> accounts, Predicate<Account> tester, Function<Account, String> mapper, Consumer<String> consumer) {
        List<Account> searchedAccounts = new ArrayList<Account>();
        for (Account a : accounts) {
            if (tester.test(a)) {
                String data = mapper.apply(a);
                consumer.accept(data);
                searchedAccounts.add(a);
            }
        }
        System.out.println("------------------------------------");
        return searchedAccounts;
    }

    public static List<String> searchUsingStreams() {
        //using aggregate functions without referencing/using any functional interface directly
        System.out.println("using aggregate functions");
        List<String> searchedAccountNames = new ArrayList<String>();
        BankUtil.getAccounts().stream()
                .filter(a -> a.getBalance() >= 2000 && a.getBalance() <= 5000 && a.getGender() == Gender.MALE)
                .map(a -> a.getAccountName())
                .forEach(accName -> { System.out.println(accName); searchedAccountNames.add(accName);});
        return searchedAccountNames;
    }

    public static List<String> searchUsingStreamsInDeclarativeWay() {
        //in declarative or functional way
        //will be helpful if we want to duplicate/reuse again the same lambda expression
        List<String> searchedAccountNames = new ArrayList<String>();
        Predicate<Account> minBal = a -> a.getBalance() >= 2000;
        Predicate<Account> maxBal = a -> a.getBalance() <= 5000;
        Predicate<Account> gender = a -> a.getGender() == Gender.FEMALE;
        Function<Account, String> accName = a -> a.getAccountName();
        Consumer<String> printAccName = data -> { System.out.println(data); searchedAccountNames.add(data);};
        System.out.println("in declarative or functional way");

        BankUtil.getAccounts().stream()
                .filter(minBal)
                .filter(maxBal)
                .filter(gender)
                .map(accName)
                .forEach(printAccName);
        return searchedAccountNames;
    }

    public static List<String> searchUsingStreamsInDeclarativeAndGenericWay() {
        //in declarative or functional way
        //will be helpful if we want to duplicate/reuse again the same lambda expression
        //to avoid modifying Predicate for different value
        List<String> searchedAccountNames = new ArrayList<String>();
        Function<Double, Predicate<Account>> minBalance = miBal -> acc -> acc.getBalance() >= miBal;
        //if you want to reuse in the broader level then define this as a method and use it as method reference
        Function<Double, Predicate<Account>> maxBalance = maBal -> acc -> acc.getBalance() <= maBal;
        Predicate<Account> gender = a -> a.getGender() == Gender.FEMALE;
        Function<Account, String> acName = a -> a.getAccountName();
        Consumer<String> printAcName = data -> { System.out.println(data); searchedAccountNames.add(data);};
        System.out.println("in declarative or functional way with generic code");
        BankUtil.getAccounts().stream()
                .filter(minBalance.apply(2000.00))
                .filter(maxBalance.apply(5000.00))
                .filter(gender)
                .map(acName)
                .forEach(printAcName);

        return searchedAccountNames;
    }

}
