package com.example.demo.coverage.banch;

import com.example.demo.coverage.branch.BranchCoverage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BranchCoverageTest {
    @InjectMocks
    private BranchCoverage branchCoverage;

    @Test
    public void 브랜치_테스트() {
        assertEquals("first", 첫_번째_조건을_통과한다());
        assertEquals("second", 두_번째_조건을_통과한다());
        assertEquals("third", 조건을_통과하지_않는다());
    }

    public String 첫_번째_조건을_통과한다() {
        return branchCoverage.foo("first");
    }

    public String 두_번째_조건을_통과한다() {
        return branchCoverage.foo("second");
    }

    public String 조건을_통과하지_않는다() {
        return branchCoverage.foo("third");
    }
}
