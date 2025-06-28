package Graphs.Medium;

public class NumberofOperationstoMakeNetworkConnected {
    class Solution {
        public int makeConnected(int n, int[][] arr) {
            if (arr.length < n - 1) {
                return -1;
            }
            int par[] = new int[n];
            int rank[] = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                rank[i] = 0;
            }
            for (int i = 0; i < arr.length; i++) {
                union(arr[i][0], arr[i][1], par, rank);
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (par[i] == i) {
                    c++;
                }
            }
            return c - 1;
        }

        public static int find(int x, int[] par) {
            if (par[x] == x) {
                return x;
            }
            return par[x] = find(par[x], par); // Path compression
        }

        public static void union(int a, int b, int[] par, int[] rank) {
            int rootA = find(a, par);
            int rootB = find(b, par);
            if (rootA != rootB) {
                // Union by rank
                if (rank[rootA] == rank[rootB]) {
                    par[rootB] = rootA;
                    rank[rootA]++;
                } else if (rank[rootA] < rank[rootB]) {
                    par[rootA] = rootB;
                } else {
                    par[rootB] = rootA;
                }
            }
        }
    }
}
