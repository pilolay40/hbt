package com.test.hackertest.usecase;

import com.test.hackertest.boundaries.HackerDetector;
import com.test.hackertest.converter.InputLineConverter;
import com.test.hackertest.model.InputLine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@AllArgsConstructor
public class HackerDetectorImpl implements HackerDetector {
    private final InputLineConverter inputLineConverter;
    private final LogInput logInput;

    @Override
    public String parseLine(final String line) {
        if (ObjectUtils.isEmpty(line)) {
            return "";
        }
        return this.findIpFailed(line);
    }

    private String findIpFailed(final String line) {
        final InputLine inputLine = this.inputLineConverter.convert(line);
        if (this.logInput.hasTooManyFailedInput(inputLine)) {
            return inputLine.getIp();
        }

        return "";
    }
}
