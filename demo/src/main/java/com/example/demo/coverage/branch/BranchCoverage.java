package com.example.demo.coverage.branch;

import org.springframework.stereotype.Component;

@Component
public class BranchCoverage {
    public String foo(String value) {
        if ("first".equals(value)) {
            return "first";
        }

        if ("second".equals(value)) {
            return "second";
        }

        return "third";
    }
}
