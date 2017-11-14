package com.yd.web;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Created by nick on 2017/9/26.
 */
public class TestJodaTime {

    public static void main(String[] args) {
        DateTime startDateTime = new DateTime("2017-10-11");
        DateTime endDateTime = new DateTime("2017-10-14");
        int diffDayNum = Days.daysBetween(startDateTime, endDateTime).getDays();
        System.out.println("args = [" + diffDayNum + "]");
    }

}
