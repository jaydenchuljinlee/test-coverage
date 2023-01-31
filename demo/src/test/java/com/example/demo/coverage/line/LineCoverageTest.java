package com.example.demo.coverage.line;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LineCoverageTest {

    @InjectMocks
    private LineCoverage lineCoverage;

    @Test
    public void 라인_테스트() {
        lineCoverage.foo();
    }
}
