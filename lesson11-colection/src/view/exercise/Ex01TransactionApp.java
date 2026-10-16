package view.exercise;

import static java.util.Comparator.*;
import static utils.CollectionUtil.*;

import java.util.*;
import java.util.function.Predicate;

import bean.Trader;
import bean.Transaction;

public class Ex01TransactionApp {

    public static void main(String[] args) {

        List<Transaction> transactions = getTransactions();

        System.out.println("--- ___ * START * ___ ---");

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
        var transactionsIn2011 = new ArrayList<Transaction>();

        for(Transaction t : transactions) {
            if (t.getYear() == 2011) {
                transactionsIn2011.add(t);
            }
        }

        transactionsIn2011.sort(comparing(Transaction::getValue));
        generate("1. Find all transactions in the year 2011 and value ASC ", transactionsIn2011);

        // 2. Find all transactions have value greater than 300 and sort them by trader’s city
        var transactionsGreater300 = new ArrayList<Transaction>();

        for(Transaction t : transactions) {
            if (t.getValue() > 300) {
                transactionsGreater300.add(t);
            }
        }

        transactionsGreater300.sort(comparing(t -> t.getTrader().getCity()));
        generate("2. Find all transactions have value greater than 300 and sort them by trader’s city ", transactionsGreater300);

        // 3. What are all the unique cities where the traders work?
        var uniqueCities = new HashSet<String>();
        for (Transaction transaction : transactions) {
            uniqueCities.add(transaction.getTrader().getCity());
        }
        generate("3. Unique cities where traders work", uniqueCities);


        // 4. Find all traders from Cambridge and sort them by name desc.
        List<Trader> tradersInCambridge = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if ("Cambridge".equals(transaction.getTrader().getCity())) {
                tradersInCambridge.add(transaction.getTrader());
            }
        }

        tradersInCambridge.sort(comparing(Trader::getName, reverseOrder()));
        generate("4. Traders in Cambridge sorted by name (desc)", tradersInCambridge);

        // 5. Return a string of all traders’ names sorted alphabetically.
        Set<String> traderNames = new TreeSet<>();
        for (Transaction t : transactions) {
            traderNames.add(t.getTrader().getName());
        }
        String sortedNamesStr = String.join(", ", traderNames);
        generate("5. All traders’ names sorted alphabetically", sortedNamesStr);

        // 6. Are any traders based in Milan?
        boolean anyInMilan = false;
        for (Transaction t : transactions) {
            if ("Milan".equals(t.getTrader().getCity())) {
                anyInMilan = true;
                break;
            }
        }
        generate("6. Are any traders based in Milan?", anyInMilan);

        // 7. Count the number of traders in Milan.
        Set<Trader> milanTraders = new HashSet<>();
        for (Transaction t : transactions) {
            if ("Milan".equals(t.getTrader().getCity())) {
                milanTraders.add(t.getTrader());
            }
        }
        generate("7. Number of traders in Milan", milanTraders.size());

        // 8. Print all transactions’ values from the traders living in Cambridge.
        List<Integer> cambridgeValues = new ArrayList<>();
        for (Transaction t : transactions) {
            if ("Cambridge".equals(t.getTrader().getCity())) {
                cambridgeValues.add(t.getValue());
            }
        }
        generate("8. Transactions' values from traders living in Cambridge", cambridgeValues);

        // 9. What’s the highest value of all the transactions?
        int highestValue = Integer.MIN_VALUE;
        if (!transactions.isEmpty()) {
            highestValue = transactions.get(0).getValue();
            for (Transaction t : transactions) {
                if (t.getValue() > highestValue) {
                    highestValue = t.getValue();
                }
            }
        }
        generate("9. Highest value of all transactions", highestValue);

        // 10. Find the transaction with the smallest value.
        Transaction smallestTransaction = null;
        if (!transactions.isEmpty()) {
            smallestTransaction = transactions.get(0);
            for (Transaction t : transactions) {
                if (t.getValue() < smallestTransaction.getValue()) {
                    smallestTransaction = t;
                }
            }
        }
        generate("10. Transaction with the smallest value", smallestTransaction);

        System.out.println("--- ___ * FINISH * ___ ---");
    }

    private static List<Transaction> getTransactions() {
        // traders
        Trader raoul = new Trader("Raoul", "Barca");
        Trader mario = new Trader("Mario", "Cambridge");
        Trader alan = new Trader("Alan", "Atlentic");
        Trader brian = new Trader("Brian", "Roma");

        // transactions
        List<Transaction> transactions = new ArrayList<>(List.of(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        ));
        return transactions;
    }

}