package com.xztie.mathapi.queryprocessor;

import com.xztie.mathapi.utils.QueryProcessorUtils;

import java.util.List;

public class AvgQueryProcessor {
    public static String process(String numbersStr) {

        List<Integer> numbers = QueryProcessorUtils.parseNumbers(numbersStr);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int avg = sum/numbers.size();
        return String.format("avg: %d", avg);
    }
}
