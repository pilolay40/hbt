package com.test;

import com.test.hackertest.boundaries.HackerDetector;
import com.test.hackertest.enumerated.ActionSignin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ConfigurationPropertiesScan
public class HackerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(HackerApplication.class, args);
    }

    public static final String IP_ADDRESS = "10.15.10.23";
    public static final String SEPARATOR = ",";
    public static final Long EPOCH = 1621173641443L;
    public static final String USERNAME = "Will.Smith";
    public static String INPUT_LINE = IP_ADDRESS + SEPARATOR + EPOCH + SEPARATOR + ActionSignin.SIGNING_FAILURE.name() + SEPARATOR + USERNAME;
    @Autowired
    HackerDetector hackerDetector;

    @PostConstruct
    public void initialize() {
        this.hackerDetector.parseLine(INPUT_LINE);
        this.hackerDetector.parseLine(INPUT_LINE);
        this.hackerDetector.parseLine(INPUT_LINE);
        this.hackerDetector.parseLine(INPUT_LINE);
        this.hackerDetector.parseLine(INPUT_LINE);
        this.hackerDetector.parseLine(INPUT_LINE);
    }

}
