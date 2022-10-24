package com.concurrencyCookbook.c1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Calculator implements Runnable {

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // System.out.println("run");
        for (int i = 1; i < 10; i++) {
            System.out.printf("id:%d,name:%s, priority:%s,status:%s, %d * %d = %d\n", Thread.currentThread().getId(),
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority(), Thread.currentThread().getState(), number, i, number * i);
        }
    }

    public static void main(String[] args) {
        // for (int i = 1; i < 10; i++) {
        // Calculator calculator = new Calculator(i);
        // Thread thread = new Thread(calculator);
        // System.out.printf("new ，id:%d,name:%s, priority:%s,status:%s,\n", Thread.currentThread().getId(),
        // Thread.currentThread().getName(),
        // Thread.currentThread().getPriority(), Thread.currentThread().getState());
        // thread.start();
        // }
        // System.out.printf("id:%d,name:%s, priority:%s,status:%s,\n", Thread.currentThread().getId(),
        // Thread.currentThread().getName(),
        // Thread.currentThread().getPriority(), Thread.currentThread().getState());

        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread  " + i);
        }

        try (FileWriter fileWriter = new FileWriter("log.txt");
                PrintWriter pw = new PrintWriter(fileWriter)) {
            for (int i = 0; i < 10; i++) {
                pw.println("Main : status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                    }
                }

                finish = true;

                for (int i = 0; i < 10; i++) {
                    finish = finish & (threads[i].getState() == State.TERMINATED);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
        pw.printf("Main : Id %d - %s \n", thread.getId(), thread.getName());
        pw.printf("Main : Priority %d \n", thread.getPriority());
        pw.printf("Main : Old state: %s \n", state);
        pw.printf("Main : New State: %s \n", thread.getState());
        pw.println("Main : ****************************");
    }

}
