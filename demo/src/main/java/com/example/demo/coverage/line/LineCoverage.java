package com.example.demo.coverage.line;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineCoverage {
    @GetMapping
    public void foo() {
        System.out.println("hello");
    }
}
