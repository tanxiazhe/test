package com.concurrencyCookbook.c1;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {

    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (deque.size() == 0) {
            return;
        }
        delete = false;

        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            System.out.printf("difference %d\n", difference);
            if (difference > 1000) {
                System.out.printf("cleaner: %s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > 1000);

        if (delete) {
            System.out.printf("cleaner: size of the queue %d\n", deque.size());
        }
    }

    public static void main(String[] args) {

        Deque<Event> deque = new ArrayDeque<Event>();
        WriterTask writerTask = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }

}
