package com.algo.dynamic_connectivity;

import com.algo.dynamic_connectivity.WeightedQuickUnion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mukuljain on 3/4/2017.
 */
public class WeightedQuickUnionTest {
    WeightedQuickUnion weightedQuickUnion;

    @Before
    public void init(){
        weightedQuickUnion = new WeightedQuickUnion(10);
        weightedQuickUnion.union(4, 3);
        weightedQuickUnion.union(3, 8);
        weightedQuickUnion.union(6, 5);
        weightedQuickUnion.union(9, 4);
        weightedQuickUnion.union(2, 1);
        weightedQuickUnion.union(5, 0);
        weightedQuickUnion.union(7, 2);
        weightedQuickUnion.union(6, 1);
        weightedQuickUnion.union(7, 3);
    }

    @Test
    public void testConnected(){
        Assert.assertTrue(weightedQuickUnion.connected(8, 9));
        Assert.assertTrue(weightedQuickUnion.connected(7, 1));
        Assert.assertTrue(weightedQuickUnion.connected(2, 6));
        Assert.assertTrue(weightedQuickUnion.connected(4, 1));
        Assert.assertTrue(weightedQuickUnion.connected(4, 0));
        Assert.assertTrue(weightedQuickUnion.connected(0, 7));
    }
}
