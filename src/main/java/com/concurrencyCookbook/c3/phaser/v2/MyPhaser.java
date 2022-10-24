package com.concurrencyCookbook.c3.phaser.v2;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
        case 0:
            return studentsArrived();
        case 1:
            return finishFirstExercise();
        case 2:
            return finiseSecondExercise();
        case 3:
            return finishExam();
        default:
            return true;
        }
    }

    private boolean studentsArrived() {
        System.out.println("Phaser : The exam are going to start. ");
        System.out.printf("Phaser: The Students are ready. We have %d students.\n", getRegisteredParties());

        return false;
    }

    private boolean finishFirstExercise() {
        System.out.println("Phaser : All the students have finished the first exercies. It's time for the second one");

        return false;
    }

    private boolean finiseSecondExercise() {
        System.out.println("Phaser : All the students have finished the second exercies. It's time for the third one");
        return false;
    }

    private boolean finishExam() {
        System.out.println("Phaser : All the students have finished the exam. Thank you for your time.");

        return true;
    }
}
