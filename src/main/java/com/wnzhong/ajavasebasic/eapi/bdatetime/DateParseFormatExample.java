package com.wnzhong.ajavasebasic.eapi.bdatetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wayne
 */
public class DateParseFormatExample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("Default format of LocalDate=" + date);
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::yyyy")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Default format of LocalDateTime=" + dateTime);
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::yyyy HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        System.out.println("Default format of Instant=" + timestamp);

        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48", DateTimeFormatter.ofPattern("d::MMM::yyyy HH::mm::ss"));
        System.out.println("Default format after parsing = " + dt);
    }

}
