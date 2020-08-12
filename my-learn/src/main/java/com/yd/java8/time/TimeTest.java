package com.yd.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * Created by nick on 2018/2/1.
 *
 * @author nick
 * @date 2018/2/1
 */
public class TimeTest {

    @Test
    public void test1() throws InterruptedException {

        Instant now = Instant.now();

        Thread.sleep(300);

        Instant end = Instant.now();

        Duration duration = Duration.between(now, end);

        System.out.println(duration.toMillis());


    }

    @Test
    public void test2() throws InterruptedException {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getMonth());

        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay.toString());

        Year year = Year.now();
        System.out.println(year);


    }

    @Test
    public void test3() throws InterruptedException {
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        LocalDate next = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println(next);
    }

    @Test
    public void test4() throws InterruptedException {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        System.out.println(zonedDateTime.toLocalDateTime());
    }

    @Test
    public void test5() throws InterruptedException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
    }

    @Test
    public void test6() {

        System.out.println(LocalTime.now().getHour());

    }
}
