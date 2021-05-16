package com.test.hackertest.usecase;

import com.test.hackertest.config.HackerConfig;
import com.test.hackertest.model.InputLine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Component
@AllArgsConstructor
public class HackerPolicy {
    private final HackerConfig hackerConfig;

    public synchronized boolean hasTooManyFailedInput(final List<InputLine> inputLineList, final InputLine inputLine) {
        final Optional<InputLine> inputLineOptional = inputLineList.stream()
                .filter(line -> line.getEpoch() >= inputLine.getEpoch())
                .findFirst();
        if (inputLineOptional.isPresent() && this.apply(inputLine, inputLineOptional.get())) {
            return this.isManyIntent(inputLineList);
        }
        return false;
    }


    private synchronized boolean apply(final InputLine inputLine, final InputLine inputLineStore) {
        final LocalDateTime localDateTimeStore =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(inputLineStore.getEpoch()), TimeZone.getDefault().toZoneId());
        final LocalDateTime localDateTimeInputLine =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(inputLine.getEpoch()), TimeZone.getDefault().toZoneId());
        return localDateTimeStore.isBefore(localDateTimeInputLine) &&
                localDateTimeStore.plusMinutes(this.hackerConfig.getMinutePeriodFailure()).isAfter(localDateTimeInputLine);
    }

    private synchronized boolean isManyIntent(final List<InputLine> inputLineList) {
        return inputLineList.size() >= this.hackerConfig.getMaxFailure();
    }
}
