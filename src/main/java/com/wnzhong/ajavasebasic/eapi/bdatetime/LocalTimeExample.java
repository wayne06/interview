package com.wnzhong.ajavasebasic.eapi.bdatetime;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @author wayne
 */
public class LocalTimeExample {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Current Time= " + now);

        LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
        System.out.println("Specific Time of Day= " + specificTime);

        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST= " + timeKolkata);

        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th sencond time= " + specificSecondTime);
    }

}
