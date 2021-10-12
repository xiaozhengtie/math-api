package com.xztie.mathapi.queryprocessor;

import org.junit.Assert;
import org.junit.Test;

public class MedianQueryProcessorTest {
    @Test
    public void test() {
        Assert.assertEquals(
                "median: 2",
                MedianQueryProcessor.process("1, 2, 3, 4"));

        Assert.assertEquals(
                "median: 1",
                MedianQueryProcessor.process("1, 2, 3, -4, -100"));
    }
}
