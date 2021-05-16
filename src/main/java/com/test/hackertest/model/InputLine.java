package com.test.hackertest.model;

import com.test.hackertest.enumerated.ActionSignin;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InputLine {
    private String ip;
    private Long epoch;
    private ActionSignin actionSignin;
    private String username;
}
