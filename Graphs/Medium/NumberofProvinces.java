package Graphs.Medium;

import java.util.ArrayList;

public class NumberofProvinces {
    class Solution {
        public int findCircleNum(int[][] arr) {
            int count = 0;
            int n = arr.length;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i][j] == 1) {
                        adj.get(i).add(j);
                        adj.get(j).add(i);
                    }
                }
            }
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    dfs(adj, vis, i);
                    count++;
                }
            }
            return count;
        }

        public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr) {
            vis[curr] = true;
            for (int el : adj.get(curr)) {
                if (!vis[el]) {
                    dfs(adj, vis, el);
                }
            }
        }
    }
}

class Solution {
    public int findCircleNum(int[][] arr) {
        int count = 0;
        int n = arr.length;

        // Visited array to track visited nodes
        boolean[] vis = new boolean[n];

        // Perform DFS for each unvisited node
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(arr, vis, i, n); // Call dfs for an unvisited node
                count++; // Increase the province count (connected component)
            }
        }

        return count;
    }

    // DFS function using the matrix
    public static void dfs(int[][] arr, boolean[] vis, int curr, int n) {
        vis[curr] = true; // Mark current node as visited
        // Explore all nodes that are directly connected to the current node
        for (int i = 0; i < n; i++) {
            // If arr[curr][i] == 1, it means there is a connection between `curr` and `i`
            // and `i` has not been visited yet.
            if (arr[curr][i] == 1 && !vis[i]) {
                dfs(arr, vis, i, n); // Recurse for the connected node `i`
            }
        }
    }
}

class Solution1 {
    public static void init(int n, int[] par, int[] rank) {
        for (int i = 0; i < n; i++) {
            par[i] = i; // Initially, each element is its own parent
            rank[i] = 0; // Initial rank is 0
        }
    }

    public static int find(int x, int[] par) {
        if (par[x] == x) {
            return x; // If x is its own parent, return x
        }
        return par[x] = find(par[x], par);
    }

    public static void union(int a, int b, int[] par, int[] rank) {
        int rootA = find(a, par);
        int rootB = find(b, par);
        if (rank[rootA] == rank[rootB]) {
            par[b] = rootA; // Make a the parent of b
            rank[rootA]++; // Increment the rank of a
        } else if (rank[rootA] < rank[rootB]) {
            par[rootA] = rootB; // Make b the parent of a
        } else {
            par[rootB] = rootA; // Make a the parent of b
        }
    }

    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int par[] = new int[n];
        int rank[] = new int[n];
        int count = 0;
        init(n, par, rank);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    union(i, j, par, rank);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (par[i] == i) {
                count++;
            }
        }
        return count;
    }
}
