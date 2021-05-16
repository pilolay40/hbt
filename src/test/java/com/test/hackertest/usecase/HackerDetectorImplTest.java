package com.test.hackertest.usecase;

import com.test.hackertest.converter.InputLineConverter;
import com.test.hackertest.model.InputLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.test.hackertest.DataForTest.INPUT_LINE;
import static com.test.hackertest.DataForTest.buildInputLine;
import static com.test.hackertest.DataForTest.buildInputLineWithOutputIP;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class HackerDetectorImplTest {


    @Mock
    private InputLineConverter inputLineConverter;
    @InjectMocks
    HackerDetectorImpl hackerDetector;

    @Test
    void should_return_ipaddress() {
        // Given
        final String log = INPUT_LINE;
        final InputLine inputLine = buildInputLine();
        given(this.inputLineConverter.convert(log)).willReturn(buildInputLine());

        //When
        final String ipAddress = this.hackerDetector.parseLine(log);

        // Then
        assertThat(ipAddress, is(inputLine.getIp()));
    }

    @Test
    void should_return_empty_ipaddress() {
        // Given
        final String log = INPUT_LINE;
        final InputLine inputLine = buildInputLineWithOutputIP();
        given(this.inputLineConverter.convert(log)).willReturn(buildInputLineWithOutputIP());
        //When
        final String ipAddress = this.hackerDetector.parseLine(INPUT_LINE);

        // Then
        assertThat(ipAddress, is(inputLine.getIp()));
    }
}