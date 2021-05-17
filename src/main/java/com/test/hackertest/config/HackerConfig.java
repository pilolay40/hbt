package com.test.hackertest.config;

import lombok.Builder;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "com.hbg.detector")
@ConstructorBinding
@Builder
@Value
public class HackerConfig {
    private final int minutePeriodFailure;
    private final int maxFailure;
}
