package com.concurrencyCookbook.c2;

public class Main2 {

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        TicketOffice1 office1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(office1);

        TicketOffice2 office2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(office2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
            System.out.printf("Room 1 Vacancies :%d\n", cinema.getVacaniesCinema1());
            System.out.printf("Room 2 Vacancies :%d\n", cinema.getVacaniesCinema2());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
