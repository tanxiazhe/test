package com.concurrencyCookbook.c1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Beginning network sources loading : %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("The NetworkConnectionsLoader has been interrupted.");
        }
        System.out.printf("Data network loading has finished: %s\n", new Date());
    }

    public static void main(String[] args) {

        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        NetworkConnectionsLoader connectionsLoader = new NetworkConnectionsLoader();
        Thread thread = new Thread(dataSourcesLoader, "DataSourceThread");

        Thread thread2 = new Thread(connectionsLoader, "NetWorkConnectionLoader");

        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.printf("Main : Configuration has been loadedL %s\n", new Date());

    }

}
