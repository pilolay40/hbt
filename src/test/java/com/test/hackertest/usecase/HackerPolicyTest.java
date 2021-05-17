package com.test.hackertest.usecase;

import com.test.hackertest.config.HackerConfig;
import com.test.hackertest.model.InputLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.test.hackertest.DataForTest.buildInputLine;
import static com.test.hackertest.DataForTest.buildInputLineDateNow;
import static com.test.hackertest.DataForTest.buildInputLineWithFailsLogin;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class HackerPolicyTest {
    private HackerPolicy hackerPolicy;

    @BeforeEach
    void setUp() {
        this.hackerPolicy = new HackerPolicy(HackerConfig.builder()
                .maxFailure(1)
                .minutePeriodFailure(5)
                .build());
    }

    @Test
    void should_return_false_hacker_policy() {
        final InputLine inputLine = buildInputLine();
        final List<InputLine> inputLines = List.of(inputLine);
        final boolean manyFailedInput = this.hackerPolicy.hasTooManyFailedInput(inputLines, inputLine);
        assertThat(manyFailedInput, is(false));
    }

    @Test
    void should_return_true_hacker_policy_manyFailed() {
        final InputLine inputLine = buildInputLineDateNow();
        final List<InputLine> inputLines = buildInputLineWithFailsLogin();
        final boolean manyFailedInput = this.hackerPolicy.hasTooManyFailedInput(inputLines, inputLine);
        assertThat(manyFailedInput, is(true));
    }
}