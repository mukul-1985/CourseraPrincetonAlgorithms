package com.assignment.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by mukuljain on 3/11/2017.
 */
public class Percolation {

    // this is the percolation problem from coursera.
    private int n, topIndex, bottomIndex;
    private int[] openId;

    private WeightedQuickUnionUF wqupc;

    public Percolation(int n) {// create n-by-n grid, with all sites blocked

        if(n <= 0) {
            throw new IllegalArgumentException("N must be larger than 0.");
        }
        this.n = n;
        openId = new int[n*n];
        wqupc = new WeightedQuickUnionUF(n*n + 2);
        topIndex = n * n;
        bottomIndex = n * n + 1;
    }

    public void open(int row, int col) {// open site (row, col) if it is not open already
        int index = getIndex(row, col);
        openId[index] = 1;
        if ( row == 1) {
            wqupc.union(index, topIndex);
        }

        if (row == n) {
            wqupc.union(index, bottomIndex);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            wqupc.union(index, getIndex(row - 1, col));
        }

        if (row < n && isOpen(row + 1, col)) {
            wqupc.union(index, getIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            wqupc.union(index, getIndex(row, col - 1));
        }

        if (col < n && isOpen(row, col + 1)) {
            wqupc.union(index, getIndex(row, col + 1));
        }
    }

    public boolean isOpen(int row, int col){// is site (row, col) open?
        return openId[getIndex(row, col)] == 1;
    }

    public boolean isFull(int row, int col){// is site (row, col) full?
        return wqupc.connected(topIndex, getIndex(row, col));
    }

    public int numberOfOpenSites(){// number of open sites
        int count = 0;
        for (int i : openId){
            if (i == 1) count++;
        }
        return count;
    }

    public boolean percolates(){// does the system percolate?
        return wqupc.connected(topIndex, bottomIndex);
    }

    private int getIndex(int row, int col){
        return n * (row - 1) + (col - 1);
    }
}
