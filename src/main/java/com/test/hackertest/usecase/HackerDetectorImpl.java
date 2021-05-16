package com.test.hackertest.usecase;

import com.test.hackertest.boundaries.HackerDetector;
import com.test.hackertest.converter.InputLineConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@AllArgsConstructor
public class HackerDetectorImpl implements HackerDetector {
    private final InputLineConverter inputLineConverter;

    @Override
    public String parseLine(final String line) {
        if (ObjectUtils.isEmpty(line)) {
            return "";
        }
        return this.inputLineConverter.convert(line).getIp();
    }
}
