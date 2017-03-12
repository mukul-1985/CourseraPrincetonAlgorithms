package com.algo.dynamic_connectivity;

import java.util.Scanner;

/**
 * Created by mukuljain on 3/2/2017.
 * this algorithm has complexity of n^2.
 * this is a very slow algorithm because it's complexity is quadratic.
 */
public class QuickFind {
    private int[] id;

    public QuickFind(int N){
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pid = id[p];
        //int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid)
                id[i] = id[q];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        QuickFind quickFind = new QuickFind(N);

        while (scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!quickFind.connected(p, q)){
                quickFind.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
