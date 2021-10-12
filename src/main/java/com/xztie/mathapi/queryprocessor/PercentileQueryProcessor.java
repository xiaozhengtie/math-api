package com.xztie.mathapi.queryprocessor;

import com.xztie.mathapi.utils.QueryProcessorUtils;

import java.util.Collections;
import java.util.List;

public class PercentileQueryProcessor {
    public static String process(String percentileStr, String numbersStr) {
        int percentile = Integer.parseInt(percentileStr);
        List<Integer> numbers = QueryProcessorUtils.parseNumbers(numbersStr);
        Collections.sort(numbers);
        int size = numbers.size();

        int index = (int) Math.ceil(percentile * size * 1.0 / 100) - 1;
        if (index < 0) {
            index =0;
        }
        return String.format("%sth percentile: %d", percentileStr, numbers.get(index));
    }
}
