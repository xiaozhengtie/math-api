package com.xztie.mathapi.queryprocessor;

import com.xztie.mathapi.utils.QueryProcessorUtils;

import java.util.List;
import java.util.PriorityQueue;

public class MinQueryProcessor {
    public static String process(String quantifierStr, String numbersStr) {
        int quantifier = Integer.parseInt(quantifierStr);
        List<Integer> numbers = QueryProcessorUtils.parseNumbers(numbersStr);
        PriorityQueue<Integer> pq = new PriorityQueue<>(numbers);

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < quantifier; i ++) {
            sb.append(pq.poll());
            if (i != quantifier-1) {
                sb.append(",");
            }
        }
        return String.format("min %d numbers: %s", quantifier, sb.toString());
    }
}
