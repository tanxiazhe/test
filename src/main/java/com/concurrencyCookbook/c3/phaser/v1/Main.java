package com.concurrencyCookbook.c3.phaser.v1;

import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        FileSearch system = new FileSearch("C:\\Windows", "cfg", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "cfg", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "cfg", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();

        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Terminated: " + phaser.isTerminated());
    }

}
