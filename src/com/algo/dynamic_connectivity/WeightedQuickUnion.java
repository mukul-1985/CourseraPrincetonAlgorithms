package com.algo.dynamic_connectivity;

/**
 * Created by mukuljain on 3/4/2017.
 */
public class WeightedQuickUnion {
    private int[] id;
    private int[] height;

    public WeightedQuickUnion(int N){
        id = new int[N];
        height = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i; height[i] = 1;
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if(height[i] > height[j]){
            id[j] = i;
            height[i] += height[j];
        } else {
            id[i] = j;
            height[j] += height[i];
        }
    }

    private int root(int i){
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }

    private int roots(int i){
        if (i == id[i]) return i;
        return roots(id[i]);
    }
}
