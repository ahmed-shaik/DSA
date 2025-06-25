package Graphs.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    class Solution {
        static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
        static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
                return -1;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { 0, 0 });
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            int steps = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                steps++;
                for (int i = 0; i < size; i++) {
                    int[] curr = queue.poll();
                    int x = curr[0];
                    int y = curr[1];
                    if (x == n - 1 && y == n - 1) {
                        return steps;
                    }
                    for (int dir = 0; dir < 8; dir++) {
                        int newX = x + dx[dir];
                        int newY = y + dy[dir];
                        if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0
                                && !visited[newX][newY]) {
                            visited[newX][newY] = true;
                            queue.offer(new int[] { newX, newY });
                        }
                    }
                }
            }
            return -1;
        }

    }
}
