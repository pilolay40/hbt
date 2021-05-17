package com.test.hackertest.usecase;

import com.test.hackertest.boundaries.LogRepository;
import com.test.hackertest.model.InputLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.test.hackertest.DataForTest.buildInputLine;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LogInputTest {

    @InjectMocks
    LogInput logInput;
    @Mock
    private LogRepository logRepository;
    @Mock
    private HackerPolicy hackerPolicy;

    @Test
    void hasTooManyFailedInput() {

        final InputLine inputLine = buildInputLine();
        final List<InputLine> inputLines = List.of(inputLine);
        given(this.logRepository.getById(inputLine.getIp())).willReturn(inputLines);
        given(this.hackerPolicy.hasTooManyFailedInput(inputLines, inputLine)).willReturn(true);
        final boolean manyFailedInput = this.logInput.hasTooManyFailedInput(buildInputLine());
        // Then
        assertThat(manyFailedInput, is(true));
    }
}