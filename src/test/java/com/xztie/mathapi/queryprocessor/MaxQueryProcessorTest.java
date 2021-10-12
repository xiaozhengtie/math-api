package com.xztie.mathapi.queryprocessor;

import org.junit.Assert;
import org.junit.Test;

public class MaxQueryProcessorTest {
    @Test
    public void test() {
        Assert.assertEquals(
                "max 1 numbers: 4",
                MaxQueryProcessor.process("1", "1, 2, 3, 4"));

        Assert.assertEquals(
                "max 2 numbers: 3,2",
                MaxQueryProcessor.process("2", "1, 2, 3, -4, -100"));
    }
}
