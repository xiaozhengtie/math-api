package com.xztie.mathapi.queryprocessor;

import org.junit.Assert;
import org.junit.Test;

public class MinQueryProcessorTest {
    @Test
    public void test() {
        Assert.assertEquals(
                "min 1 numbers: 1",
                MinQueryProcessor.process("1", "1, 2, 3, 4"));

        Assert.assertEquals(
                "min 2 numbers: -100,-4",
                MinQueryProcessor.process("2", "1, 2, 3, -4, -100"));
    }
}
