package com.concurrencyCookbook.c3.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARITICIPANT = 2000;

        MatrixMock matrixMock = new MatrixMock(ROWS, NUMBERS, SEARCH);

        Results results = new Results(ROWS);

        Grouper grouper = new Grouper(results);

        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        Searcher searchers[] = new Searcher[PARTICIPANTS];

        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i * LINES_PARITICIPANT, i * LINES_PARITICIPANT + LINES_PARITICIPANT, matrixMock,
                    results, SEARCH, barrier);
            Thread t = new Thread(searchers[i]);
            t.start();
        }

        System.out.println("Main: The Main thread has finished.");
    }

}
