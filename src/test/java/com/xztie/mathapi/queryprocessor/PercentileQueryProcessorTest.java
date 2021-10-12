package com.xztie.mathapi.queryprocessor;

import org.junit.Assert;
import org.junit.Test;

public class PercentileQueryProcessorTest {
    @Test
    public void test() {
        // follow examples at https://en.wikipedia.org/wiki/Percentile#The_nearest-rank_method
        Assert.assertEquals(
                "1th percentile: 1",
                PercentileQueryProcessor.process("1", "1, 2, 3, 4"));

        Assert.assertEquals(
                "5th percentile: 15",
                PercentileQueryProcessor.process("5", "15, 20, 35, 40, 50"));

        Assert.assertEquals(
                "30th percentile: 20",
                PercentileQueryProcessor.process("30", "15, 20, 35, 40, 50"));

        Assert.assertEquals(
                "40th percentile: 20",
                PercentileQueryProcessor.process("40", "15, 20, 35, 40, 50"));

        Assert.assertEquals(
                "50th percentile: 35",
                PercentileQueryProcessor.process("50", "15, 20, 35, 40, 50"));

        Assert.assertEquals(
                "100th percentile: 50",
                PercentileQueryProcessor.process("100", "15, 20, 35, 40, 50"));

        Assert.assertEquals(
                "25th percentile: 7",
                PercentileQueryProcessor.process("25", "3, 6, 7, 8, 8, 10, 13, 15, 16, 20"));

        Assert.assertEquals(
                "50th percentile: 8",
                PercentileQueryProcessor.process("50", "3, 6, 7, 8, 8, 10, 13, 15, 16, 20"));

        Assert.assertEquals(
                "75th percentile: 15",
                PercentileQueryProcessor.process("75", "3, 6, 7, 8, 8, 10, 13, 15, 16, 20"));

        Assert.assertEquals(
                "100th percentile: 20",
                PercentileQueryProcessor.process("100", "3, 6, 7, 8, 8, 10, 13, 15, 16, 20"));

        Assert.assertEquals(
                "25th percentile: 7",
                PercentileQueryProcessor.process("25", "3, 6, 7, 8, 8, 9, 10, 13, 15, 16, 20"));

        Assert.assertEquals(
                "50th percentile: 9",
                PercentileQueryProcessor.process("50", "3, 6, 7, 8, 8, 9, 10, 13, 15, 16, 20"));

        Assert.assertEquals(
                "75th percentile: 15",
                PercentileQueryProcessor.process("75", "3, 6, 7, 8, 8, 9, 10, 13, 15, 16, 20"));

        Assert.assertEquals(
                "100th percentile: 20",
                PercentileQueryProcessor.process("100", "3, 6, 7, 8, 8, 9, 10, 13, 15, 16, 20"));


    }
}
