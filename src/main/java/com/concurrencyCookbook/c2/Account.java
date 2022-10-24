package com.concurrencyCookbook.c2;

public class Account {
    private static double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        Account.balance = balance;
    }

    public synchronized void addAmount(double amount) {
        double tmp = balance;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp += amount;

        balance = tmp;
    }

    public synchronized void subtractAmount(double amount) {
        double tmp = balance;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp -= amount;

        balance = tmp;
    }
}
