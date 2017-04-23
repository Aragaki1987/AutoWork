package com.san.auto.util;

/**
 * Created by nguye on 3/25/2017.
 */
public class SystemUtil {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
