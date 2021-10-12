package com.xztie.mathapi.queryprocessor;

import com.xztie.mathapi.utils.QueryProcessorUtils;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class MaxQueryProcessor {
    public static String process(String quantifierStr, String numbersStr) {
        int quantifier = Integer.parseInt(quantifierStr);
        List<Integer> numbers = QueryProcessorUtils.parseNumbers(numbersStr);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                numbers.size(),
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return b - a;
                    }
                });
        for (int number : numbers) {
            pq.add(number);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < quantifier; i ++) {
            sb.append(pq.poll());
            if (i != quantifier-1) {
                sb.append(",");
            }
        }
        return String.format("max %d numbers: %s", quantifier, sb.toString());
    }
}
