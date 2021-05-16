package com.test.hackertest.converter;

import com.test.hackertest.enumerated.ActionSignin;
import com.test.hackertest.model.InputLine;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class InputLineConverter implements Converter<String, InputLine> {
    private static final Pattern PATTERN_REG = Pattern.compile(",");
    public static final int IP_POSITION = 0;
    public static final int EPOCH_POSITION = 1;
    public static final int ACTION_POSITION = 2;
    public static final int USERNAME_POSITION = 3;

    @Override
    public InputLine convert(final String source) {
        return this.buildInputLIne(source);
    }

    private InputLine buildInputLIne(final String source) {
        final String[] sources = source.split(PATTERN_REG.pattern());
        return InputLine.builder()
                .ip(sources[IP_POSITION])
                .epoch(Long.parseLong(sources[EPOCH_POSITION]))
                .actionSignin(ActionSignin.valueOf(sources[ACTION_POSITION]))
                .username(sources[USERNAME_POSITION])
                .build();
    }
}
