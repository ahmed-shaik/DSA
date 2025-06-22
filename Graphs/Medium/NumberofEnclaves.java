package Graphs.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofEnclaves {
    class Solution {
        static class Pair {
            int first, second;

            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        public int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            Queue<Pair> q = new LinkedList<>();
            boolean[][] vis = new boolean[n][m];

            // Add boundary land cells to queue and mark visited
            for (int i = 0; i < n; i++) {
                if (grid[i][0] == 1) {
                    q.add(new Pair(i, 0));
                    vis[i][0] = true;
                }
                if (grid[i][m - 1] == 1) {
                    q.add(new Pair(i, m - 1));
                    vis[i][m - 1] = true;
                }
            }

            for (int j = 0; j < m; j++) {
                if (grid[0][j] == 1) {
                    q.add(new Pair(0, j));
                    vis[0][j] = true;
                }
                if (grid[n - 1][j] == 1) {
                    q.add(new Pair(n - 1, j));
                    vis[n - 1][j] = true;
                }
            }

            int[] delrow = { -1, 0, 1, 0 };
            int[] delcol = { 0, 1, 0, -1 };

            while (!q.isEmpty()) {
                Pair p = q.remove();
                int row = p.first;
                int col = p.second;

                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && !vis[i][j]) {
                        cnt++;
                    }
                }
            }

            return cnt;
        }
    }
}
