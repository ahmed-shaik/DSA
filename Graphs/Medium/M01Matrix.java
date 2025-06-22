package Graphs.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class M01Matrix {
    class Solution {
        // this sol TLE
        static class Pair {
            int r;
            int c;

            Pair(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        public int[][] updateMatrix(int[][] mat) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1) {
                        mat[i][j] = countUsingBfs(mat, new Pair(i, j));
                    }
                }
            }
            return mat;
        }

        public static int countUsingBfs(int[][] mat, Pair p) {
            boolean[][] vis = new boolean[mat.length][mat[0].length];
            Queue<Pair> q = new LinkedList<>();
            vis[p.r][p.c] = true;
            q.add(p);
            int[] row = { -1, 0, 1, 0 };
            int[] col = { 0, 1, 0, -1 };
            int count = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                count++;
                for (int i = 0; i < size; i++) {
                    Pair pr = q.remove();
                    int r = pr.r;
                    int c = pr.c;
                    for (int j = 0; j < row.length; j++) {
                        int nr = r + row[j];
                        int nc = c + col[j];
                        if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && !vis[nr][nc]) {
                            if (mat[nr][nc] == 0) {
                                return count;
                            } else {
                                vis[nr][nc] = true;
                                q.add(new Pair(nr, nc));
                            }
                        }
                    }
                }
            }
            return count;
        }
    }

    class Solution1 {
        static class Pair {
            int r;
            int c;

            Pair(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        public int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;

            // Queue for BFS
            Queue<Pair> q = new LinkedList<>();

            // Initialize the distance matrix with a large value
            int[][] dist = new int[rows][cols];

            // Initialize the dist matrix and add all `0` cells to the queue
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 0) {
                        dist[i][j] = 0; // Distance of a `0` cell to itself is 0
                        q.offer(new Pair(i, j)); // Add this `0` cell to the queue
                    } else {
                        dist[i][j] = Integer.MAX_VALUE; // All `1` cells are initially far from `0`
                    }
                }
            }

            // Directions for 4 possible moves (up, right, down, left)
            int[] row = { -1, 0, 1, 0 };
            int[] col = { 0, 1, 0, -1 };

            // Perform BFS
            while (!q.isEmpty()) {
                Pair p = q.poll(); // Get the current cell from the queue
                int r = p.r;
                int c = p.c;

                // Explore 4 possible directions
                for (int i = 0; i < 4; i++) {
                    int nr = r + row[i]; // New row index after move
                    int nc = c + col[i]; // New column index after move

                    // Check if the new position is valid
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        // If we find a smaller distance, update it and add to the queue
                        if (dist[nr][nc] > dist[r][c] + 1) {
                            dist[nr][nc] = dist[r][c] + 1; // Update the distance
                            q.offer(new Pair(nr, nc)); // Add the new cell to the queue
                        }
                    }
                }
            }

            return dist; // Return the updated distance matrix
        }
    }

}
