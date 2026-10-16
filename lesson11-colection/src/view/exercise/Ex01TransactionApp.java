package view.exercise;

import java.util.List;

import bean.Trader;
import bean.Transaction;

public class Ex01TransactionApp {

    public static void main(String[] args) {

        List<Transaction> transactions = getTransactions();

        System.out.println("--- ___ * START * ___ ---");

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).

        // 2. Find all transactions have value greater than 300 and sort them by trader’s city

        // 3. What are all the unique cities where the traders work?

        // 4. Find all traders from Cambridge and sort them by name desc.

        // 5. Return a string of all traders’ names sorted alphabetically.

        // 6. Are any traders based in Milan?

        // 7. Count the number of traders in Milan.

        // 8. Print all transactions’ values from the traders living in Cambridge.

        // 9. What’s the highest value of all the transactions?

        // 10. Find the transaction with the smallest value.

        System.out.println("--- ___ * FINISH * ___ ---");
    }

    public static List<Transaction> getTransactions() {
        // traders
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        // transactions
        List<Transaction> transactions = List.of(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }

}