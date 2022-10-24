package com.concurrencyCookbook.c2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Pricesinfo {

    private double price1;
    private double price2;

    private ReadWriteLock lock;

    public Pricesinfo() {
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

    public void setPrices(double price1, double price2) {
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        lock.writeLock().unlock();
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

}
