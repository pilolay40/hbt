package com.test.hackertest.repository;

import com.test.hackertest.boundaries.LogRepository;
import com.test.hackertest.model.InputLine;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class HackerDetectorRepository implements LogRepository {
    private final Map<Integer, InputLine> store = new ConcurrentHashMap();
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    public boolean exists(final String id) {
        return this.store.values().stream()
                .filter(inputLines -> inputLines.getIp().equalsIgnoreCase(id))
                .count() > 0;

    }

    @Override
    public List<InputLine> getById(final String id) {
        return this.store.values().stream()
                .filter(inputLines -> inputLines.getIp().equalsIgnoreCase(id))
                .collect(Collectors.toList());
    }

    @Override
    public void save(final InputLine inputLine) {
        this.store.put(this.atomicInteger.incrementAndGet(), inputLine);
    }

    @Override
    public void removeById(final String id) {
        this.store.entrySet()
                .removeIf(integerInputLineEntry -> integerInputLineEntry.getValue().getIp().equalsIgnoreCase(id));

    }

    @Override
    public void removeAll() {
        this.store.clear();
    }

}
