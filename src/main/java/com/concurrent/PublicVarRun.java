package com.concurrent;

public class PublicVarRun extends Thread {

    PublicVar publicVar;

    public PublicVarRun(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    public void run() {
        publicVar.setValue("B", "BB");
    }

    public static void main(String[] args) {
        PublicVar publicVar = new PublicVar();
        PublicVarRun a = new PublicVarRun(publicVar);
        a.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        publicVar.getValue();

    }
}
