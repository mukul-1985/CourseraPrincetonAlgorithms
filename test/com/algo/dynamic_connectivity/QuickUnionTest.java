package com.algo.dynamic_connectivity;

import com.algo.dynamic_connectivity.QuickUnion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mukuljain on 3/4/2017.
 */
public class QuickUnionTest {

    QuickUnion quickUnion;
    @Before
    public void init(){
        quickUnion = new QuickUnion(10);
        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);
        quickUnion.union(5, 0);
        quickUnion.union(7, 2);
        quickUnion.union(6, 1);
        quickUnion.union(7, 3);
    }

    @Test
    public void testConnected(){
        Assert.assertTrue(quickUnion.connected(8, 9));
        //Assert.assertFalse(quickUnion.connected(5, 4));
    }
}
