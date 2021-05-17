package com.test.hackertest.converter;

import com.test.hackertest.DataForTest;
import com.test.hackertest.model.InputLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class InputLineConverterTest {

    @InjectMocks
    InputLineConverter inputLineConverter;


    @Test
    void should_convert_input_lines() {
        final InputLine inputLine = this.inputLineConverter.convert(DataForTest.INPUT_LINE);
        assertThat(inputLine).isNotNull();
        assertThat(inputLine.getIp()).isNotNull();
        assertThat(inputLine.getEpoch()).isNotNull();
        assertThat(inputLine.getActionSignin()).isNotNull();
        assertThat(inputLine.getUsername()).isNotNull();
    }

}