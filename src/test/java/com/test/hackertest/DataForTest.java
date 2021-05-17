package com.test.hackertest;

import com.test.hackertest.enumerated.ActionSignin;
import com.test.hackertest.model.InputLine;

import java.util.ArrayList;
import java.util.List;

public class DataForTest {
    public static final String IP_ADDRESS = "10.15.10.23";
    public static final String SEPARATOR = ",";
    public static final Long EPOCH = 1542110400L;
    public static final String USERNAME = "Will.Smith";
    public static String INPUT_LINE = IP_ADDRESS + SEPARATOR + EPOCH + SEPARATOR + ActionSignin.SIGNING_FAILURE.name() + SEPARATOR + USERNAME;

    public static InputLine buildInputLine() {
        return InputLine.builder()
                .ip(IP_ADDRESS)
                .actionSignin(ActionSignin.SIGNING_FAILURE)
                .username(USERNAME)
                .epoch(EPOCH)
                .build();
    }

    public static InputLine buildInputLineWithOutputIP() {
        return InputLine.builder()
                .ip("")
                .actionSignin(ActionSignin.SIGNING_FAILURE)
                .username(USERNAME)
                .epoch(EPOCH)
                .build();
    }

    public static InputLine buildInputLineDateNow() {
        return InputLine.builder()
                .ip(IP_ADDRESS)
                .actionSignin(ActionSignin.SIGNING_FAILURE)
                .username(USERNAME)
                .epoch(new java.util.Date().getTime())
                .build();
    }

    public static List<InputLine> buildInputLineWithFailsLogin() {
        final List<InputLine> inputLines = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            inputLines.add(buildInputLine());
        }
        return inputLines;
    }
}
