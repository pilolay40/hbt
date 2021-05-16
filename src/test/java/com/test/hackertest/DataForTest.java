package com.test.hackertest;

import com.test.hackertest.enumerated.ActionSignin;
import com.test.hackertest.model.InputLine;

public class DataForTest {
    public static final String IP_ADDRESS = "10.15.10.23";
    public static final String SEPARATOR = ",";
    public static final Long EPOCH = 1542110400L;
    public static final String USERNAME = "Will.Smith";
    public static String INPUT_LINE = IP_ADDRESS + SEPARATOR + EPOCH + SEPARATOR + ActionSignin.SIGNIN_FAILURE.name() + SEPARATOR + USERNAME;

    public static InputLine buildInputLine() {
        return InputLine.builder()
                .ip(IP_ADDRESS)
                .actionSignin(ActionSignin.SIGNIN_FAILURE)
                .username(USERNAME)
                .epoch(EPOCH)
                .build();
    }

    public static InputLine buildInputLineWithOutputIP() {
        return InputLine.builder()
                .actionSignin(ActionSignin.SIGNIN_FAILURE)
                .username(USERNAME)
                .epoch(EPOCH)
                .build();
    }
}
