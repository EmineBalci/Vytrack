package com.Vytrack.utilities;

public class StaticWait {

    public static void staticWait(int seconds){

        try {

            Thread.sleep(seconds*1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Thread hata");
        }
    }
}
