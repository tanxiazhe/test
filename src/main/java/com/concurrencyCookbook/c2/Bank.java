package com.concurrencyCookbook.c2;

public class Bank implements Runnable {

    private Account account;

    public Bank(Account account) {
        super();
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }

}
