package com.test.hackertest.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "com.hbg.detector")
@ConstructorBinding
@Value
public class HackerConfig {
    private final int minutePeriodFailure;
    private final int maxFailure;
}
