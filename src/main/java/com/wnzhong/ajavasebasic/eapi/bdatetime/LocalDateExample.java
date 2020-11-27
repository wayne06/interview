package com.wnzhong.ajavasebasic.eapi.bdatetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * @author wayne
 */
public class LocalDateExample {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Current Date= " + today);

        LocalDate firstDay_2020 = LocalDate.of(2020, Month.JANUARY, 1);
        System.out.println("Specific Date= " + firstDay_2020);

        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST= " + todayKolkata);

        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= " + dateFromBase);

        LocalDate hundredDay2020 = LocalDate.ofYearDay(2020, 100);
        System.out.println("100th day of 2020= " + hundredDay2020);
    }

}
