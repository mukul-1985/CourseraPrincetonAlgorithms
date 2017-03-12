package com.assignment;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mukuljain on 3/2/2017.
 */
public class Problem1Test {

    @Test
    public void testToString(){
        String expected = "Test";
        Problem1 problem1 = new Problem1(expected);
        Assert.assertEquals(expected, problem1.toString());
    }
}
