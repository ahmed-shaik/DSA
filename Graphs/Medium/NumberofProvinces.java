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
