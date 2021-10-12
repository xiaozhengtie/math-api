package com.xztie.mathapi.queryprocessor;

import org.junit.Assert;
import org.junit.Test;

public class AvgQueryProcessorTest {
    @Test
    public void test() {
        Assert.assertEquals(
                "avg: 2",
                AvgQueryProcessor.process("1, 2, 3, 4"));

        Assert.assertEquals(
                "avg: -19",
                AvgQueryProcessor.process("1, 2, 3, -4, -100"));
    }
}
