package com.assignment.percolation;

import com.algo.dynamic_connectivity.WeightedQuickUnionPathCompression;

/**
 * Created by mukuljain on 3/11/2017.
 */
public class Percolation {

    private int n, top_index, bottom_index;
    private int[] open_id;

    private WeightedQuickUnionPathCompression wqupc;

    public Percolation(int n){// create n-by-n grid, with all sites blocked

        if(n <= 0){
            throw new IllegalArgumentException();
        }
        this.n = n;
        open_id = new int[n*n];
        wqupc = new WeightedQuickUnionPathCompression(n*n + 2);
        top_index = n * n;
        bottom_index = n * n + 1;
    }

    public void open(int row, int col){// open site (row, col) if it is not open already
        int index = getIndex(row, col);
        open_id[index] = 1;
        if ( row == 1) {
            wqupc.union(index, top_index);
        }

        if (row == n){
            wqupc.union(index, bottom_index);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            wqupc.union(index, getIndex(row - 1, col));
        }

        if (row < n && isOpen(row + 1, col)) {
            wqupc.union(index, getIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)){
            wqupc.union(index, getIndex(row, col - 1));
        }

        if (col < n && isOpen(row, col + 1)){
            wqupc.union(index, getIndex(row, col + 1));
        }
    }

    public boolean isOpen(int row, int col){// is site (row, col) open?
        return open_id[getIndex(row, col)] == 1;
    }

    public boolean isFull(int row, int col){// is site (row, col) full?
        return wqupc.connected(top_index, getIndex(row, col));
    }

    public int numberOfOpenSites(){// number of open sites
        int count = 0;
        for (int i : open_id){
            if (i == 1) count++;
        }
        return count;
    }

    public boolean percolates(){// does the system percolate?
        return wqupc.connected(top_index, bottom_index);
    }

    public int getIndex(int row, int col){
        return n * (row - 1) + (col - 1);
    }
}
