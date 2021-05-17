package com.test.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.format.DateTimeParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TimeCalculatorTest {

    @InjectMocks
    TimeCalculator timeCalculator;

    @Test
    void should_calculate_difference_InMinutes() {
        final String firstDate = "Thu, 21 Dec 2000 16:01:07 +0200";
        final String secondDate = "Thu, 21 Dec 2000 16:05:07 +0200";
        final Long aLong = this.timeCalculator.calculateDifferenceInMinutes(firstDate, secondDate);
        assertThat(aLong, is(4L));
    }

    @Test
    void should_thrown_exception_format_date_error() {
        final String firstDate = "Thu, 21 Dec 2000 16:01a:07 +0200";
        final String secondDate = "Thu, 21 Dec 2000 16:05:07 +0200";
        assertThrows(DateTimeParseException.class, () -> this.timeCalculator.calculateDifferenceInMinutes(firstDate, secondDate));
    }
}