package com.concurrencyCookbook.c1;

public class MyThreadGroup extends ThreadGroup {

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s haas thrown an Exception \n", t.getId());
        e.printStackTrace(System.out);

        System.out.printf("Terminating the rest of the Threads \n");
        interrupt();
        super.uncaughtException(t, e);
    }
}
