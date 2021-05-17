package com.test.calculator;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeCalculator {

    public Long calculateDifferenceInMinutes(final String firstTimeStamp, final String secondTimeStamp) {
        final ZonedDateTime zonedDateTime = ZonedDateTime.parse(firstTimeStamp, DateTimeFormatter.RFC_1123_DATE_TIME);
        final ZonedDateTime zonedDateTime1 = ZonedDateTime.parse(secondTimeStamp, DateTimeFormatter.RFC_1123_DATE_TIME);
        return Math.abs(Duration.between(zonedDateTime, zonedDateTime1).toMinutes());
    }
}
