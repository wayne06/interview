package com.wnzhong.ajavasebasic.eapi.bdatetime;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wayne
 */
public class Test1 {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
    }

    /**
     * 打印昨天的当前时刻
     */
    private static void test5() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        System.out.println(yesterday);
    }

    /**
     * 如何格式化日期
     */
    private static void test4() {
        // Java.text.DataFormat 的子类（如 SimpleDateFormat 类）中的 format(Date)方法可将日期格式化
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(format1.format(date1));

        // Java 8 中可以用 java.time.format.DateTimeFormatter 来格式化时间日期
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(formatter2));
    }

    /**
     * 获取某月的某一天
     */
    private static void test3() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, 0);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        String first = format.format(calendar1.getTime());
        System.out.println("----- first: " + first);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(calendar2.getTime());
        System.out.println("----- last : " + last);

        // Java 8
        LocalDate today = LocalDate.now();
        LocalDate firstDay = LocalDate.of(today.getYear(), today.getMonth(), 1);
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("----- firstDay: " + firstDay);
        System.out.println("----- lastDay : " + lastDay);
    }

    /**
     * 获取从 1970年1月1日0时0分0秒到现在的毫秒数
     */
    private static void test2() {
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());
    }

    /**
     * 获取年月日时分秒
     */
    private static void test1() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));  // 0 - 11
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        // Java 8
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());  // 1 - 12
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
    }

}
