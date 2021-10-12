package com.xztie.mathapi.queryprocessor;

import com.xztie.mathapi.utils.QueryProcessorUtils;

import java.util.Collections;
import java.util.List;

public class MedianQueryProcessor {
    public static String process(String numbersStr) {

        List<Integer> numbers = QueryProcessorUtils.parseNumbers(numbersStr);

        Collections.sort(numbers);
        int size = numbers.size();
        int median = 0;
        if (numbers.size() % 2 == 0) {
            // we have even numbers
            median = (numbers.get(size/2-1) + numbers.get(size/2))/2;
        } else {
            // we have odd numbers
            median = numbers.get((size-1)/2);
        }
        return String.format("median: %d", median);
    }
}
