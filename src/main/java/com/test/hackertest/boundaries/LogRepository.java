package com.test.hackertest.boundaries;

import com.test.hackertest.model.InputLine;

import java.util.List;

public interface LogRepository {
    boolean exists(String id);

    List<InputLine> getById(String id);

    void save(InputLine inputLine);

    void removeById(String id);

    void removeAll();
}
