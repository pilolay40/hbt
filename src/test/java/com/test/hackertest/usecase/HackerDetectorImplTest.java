package com.test.hackertest.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class HackerDetectorImplTest {

    private final String IP_ADDRESS = "10.15.10.23";
    @InjectMocks
    HackerDetectorImpl hackerDetector;

    @Test
    void should_return_ipaddress() {
        // Given
        final String inputLine = this.IP_ADDRESS + ",1542110400,SIGNIN_FAILURE,Will.Smith";

        //When
        final String ipAddress = this.hackerDetector.parseLine(inputLine);

        // Then
        assertThat(ipAddress, is(this.IP_ADDRESS));
    }

    @Test
    void should_return_empty_ipaddress() {
        // Given
        final String inputLine = ",1542110400,SIGNIN_FAILURE,Will.Smith";

        //When
        final String ipAddress = this.hackerDetector.parseLine(inputLine);

        // Then
        assertThat(ipAddress, is(emptyString()));
    }
}