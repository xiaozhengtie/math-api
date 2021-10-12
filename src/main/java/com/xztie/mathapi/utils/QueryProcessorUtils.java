package com.xztie.mathapi.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessorUtils {
    public static List<Integer> parseNumbers(String numbers) {
        List<String> stringList = Arrays.asList(
                numbers.replaceAll(" ", "").split(","));
        List<Integer> intList = stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return intList;
    }
}
