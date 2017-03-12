package com.algo.dynamic_connectivity;

/**
 * Created by mukuljain on 3/4/2017.
 */
public class QuickUnion {
    private int[] id;

    public QuickUnion(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    private int root(int i){
        if (i == id[i]) return i;
        return root(id[i]);
    }

    /*private int root(int i){
        while ( i != id[i]) i = id[i];
        return i;
    }*/
}
