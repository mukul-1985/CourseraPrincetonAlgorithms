package com.algo.dynamic_connectivity;

import com.algo.dynamic_connectivity.QuickFind;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mukuljain on 3/2/2017.
 */
public class QuickFindTest {
    private QuickFind quickFind;

    @Before
    public void init(){
        quickFind = new QuickFind(10);
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        quickFind.union(1, 2);
        quickFind.union(1, 3);
    }

    @Test
    public void testConnected(){
        Assert.assertTrue(quickFind.connected(1, 8));
        Assert.assertFalse("test", quickFind.connected(5, 6));
    }
}
