package org.example.consts;

public class Time {
    public static final int SECONDS_IN_MINUTE = 60;
    public static final int SECONDS_IN_HOURS = 3600;
    public static final int HOURS_IN_DAY = 24;
    public static final int DAY_IN_WEEK = 7;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int MINUTE_IN_HOURS = SECONDS_IN_MINUTE * MINUTES_IN_HOUR;
    public static final int SECONDS_IN_DAYS = (SECONDS_IN_HOURS * HOURS_IN_DAY) / 3;
    public static final int MINUTES_IN_DAYS = MINUTE_IN_HOURS * HOURS_IN_DAY;
}
