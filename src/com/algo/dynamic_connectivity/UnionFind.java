package com.algo.dynamic_connectivity;

import java.util.Scanner;

/**
 * Created by mukuljain on 3/2/2017.
 */
public class UnionFind {
    // this is from the first lesson first video
    // this just signifies data-type with specification of methods wot solve this problem.

    private int[] arr;

    public UnionFind(int N){
        arr = new int[N];
    }

    public boolean connected(int p, int q){

        return false;
    }

    public void union(int p, int q){
        arr[p] = q;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        UnionFind unionFind = new UnionFind(N);

        while (scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!unionFind.connected(p, q)){
                unionFind.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
