package com.test.hackertest.usecase;

import com.test.hackertest.boundaries.LogRepository;
import com.test.hackertest.model.InputLine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.test.hackertest.enumerated.ActionSignin.SIGNING_SUCCESS;

@AllArgsConstructor
@Component
public class LogInput {
    private final LogRepository logRepository;
    private final HackerPolicy hackerPolicy;

    public boolean hasTooManyFailedInput(final InputLine inputLine) {
        
        if (SIGNING_SUCCESS == inputLine.getActionSignin()) {
            this.logRepository.removeById(inputLine.getIp());
            return false;
        }

        synchronized (this) {
            this.logRepository.save(inputLine);
            return this.hackerPolicy.hasTooManyFailedInput(this.logRepository.getById(inputLine.getIp()), inputLine);
        }

    }

}
