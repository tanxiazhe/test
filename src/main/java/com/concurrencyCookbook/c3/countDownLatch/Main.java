package com.concurrencyCookbook.c3.countDownLatch;

public class Main {

    public static void main(String[] args) {
        Videoconference videoconference = new Videoconference(10);

//        Thread threadConference = new Thread(videoconference);
//        threadConference.start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(videoconference, "Participant " + i);
            Thread t = new Thread(participant);
            t.start();

            Thread threadConference2 = new Thread(videoconference);
            threadConference2.start();

        }
    }

}
