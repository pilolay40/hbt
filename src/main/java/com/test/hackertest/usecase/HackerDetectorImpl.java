package com.test.hackertest.usecase;

import com.test.hackertest.boundaries.HackerDetector;
import org.springframework.util.ObjectUtils;

public class HackerDetectorImpl implements HackerDetector {

    @Override
    public String parseLine(final String line) {
        if (ObjectUtils.isEmpty(line)) {
            return "";
        }

        return line.split(",")[0];
    }
}
