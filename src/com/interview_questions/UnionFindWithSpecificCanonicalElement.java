package com.interview_questions;

/**
 * Created by mukuljain on 3/4/2017.
 */
public class UnionFindWithSpecificCanonicalElement {

    /*
     * Union-find with specific canonical element. Add a method find()
     * to the union-find data type so that find(i) returns the largest
     * element in the connected component containing i. The operations,
     * union(), connected(), and find() should all take logarithmic time or better.
     *
     * For example, if one of the connected components is {1,2,6,9}, then
     * the find() method should return 9 for each of the four elements in
     * the connected components.
     */

    private int[] id;
    private int[] height;

    public UnionFindWithSpecificCanonicalElement(int N){
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

            // this does the path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public int find(int i){
        for (int n = id.length - 1; n >= 0; n--){
            if (connected(i, n)){
                return n;
            }
        }
        return 0;
    }
}
