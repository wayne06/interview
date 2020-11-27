package com.wnzhong.ajavasebasic.eapi.bdatetime;

import java.time.Duration;
import java.time.Instant;

/**
 * @author wayne
 */
public class InstantExample {

    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("Current timestamp= " + timestamp);

        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific time= " + specificTime);

        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
    }

}
