package Graphs.Medium;

import java.util.*;

public class PathWithMinimumEffort {

    class Solution {
        static class Pair implements Comparable<Pair> {
            int i, j, wt;

            Pair(int i, int j, int wt) {
                this.i = i;
                this.j = j;
                this.wt = wt;
            }

            @Override
            public int compareTo(Pair p) {
                return this.wt - p.wt; // Min-heap based on weight
            }
        }

        public int minimumEffortPath(int[][] heights) {
            int n = heights.length, m = heights[0].length;

            // Priority queue to explore cells in order of the current maximum effort
            PriorityQueue<Pair> q = new PriorityQueue<>();
            q.add(new Pair(0, 0, 0)); // Start at the top-left corner with effort 0

            // Initialize the distance matrix
            int[][] dist = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = 0; // The effort at the start is 0

            // Directions for moving up, down, left, and right
            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int i = p.i, j = p.j, d = p.wt; // Current cell and the current "effort"

                // If we reach the bottom-right corner, return the current maximum effort
                if (i == n - 1 && j == m - 1) {
                    return d;
                }

                // Explore the 4 neighbors (up, down, left, right)
                for (int k = 0; k < 4; k++) {
                    int nr = i + dx[k], nc = j + dy[k];

                    // Check if the new position is within bounds
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        // Calculate the effort (absolute difference in height)
                        int newEffort = Math.abs(heights[nr][nc] - heights[i][j]);

                        // The total effort is the maximum effort along the path to this point
                        int maxEffort = Math.max(d, newEffort);

                        // If we found a better (lower) maximum effort for the new cell
                        if (maxEffort < dist[nr][nc]) {
                            dist[nr][nc] = maxEffort;
                            q.add(new Pair(nr, nc, maxEffort));
                        }
                    }
                }
            }

            return -1; // If no path exists (which shouldn't happen as there's always a path in the
                       // grid)
        }

        // public static void main(String[] args) {
        // Solution sol = new Solution();
        // int[][] heights = {
        // { 1, 2, 3 },
        // { 3, 8, 4 },
        // { 5, 3, 5 }
        // };

        // System.out.println(sol.minimumEffortPath(heights)); // Output: 1
        // }
    }

}
