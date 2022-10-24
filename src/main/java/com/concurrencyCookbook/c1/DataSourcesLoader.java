package com.concurrencyCookbook.c1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Beginning data sources loading : %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("The fileClock has been interrupted.");
        }
        System.out.printf("Data sources loading has finished: %s\n", new Date());
    }

}
