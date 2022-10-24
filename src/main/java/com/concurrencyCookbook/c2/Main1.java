package com.concurrencyCookbook.c2;

public class Main1 {

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        Account account2 = new Account();
        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account2);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account : Initial Balance :%f\n", account.getBalance());

        companyThread.start();
        bankThread.start();
        System.out.println("main");
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance :%f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
