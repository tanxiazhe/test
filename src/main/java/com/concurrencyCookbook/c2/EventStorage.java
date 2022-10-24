package com.concurrencyCookbook.c2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {

    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        storage = new LinkedList<Date>();
    }

    public synchronized void set() {
        while (this.maxSize == storage.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ((LinkedList<Date>) storage).offer(new Date());
        System.out.printf("Set: %d\n", storage.size());

        notifyAll();
    }

    public synchronized void get() {
        while (0 == storage.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ((LinkedList<Date>) storage).poll();
        System.out.printf("Get: %d\n", storage.size());

        notifyAll();
    }
}
