package Graphs.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    class Solution {
        static class Pair {
            int r, c;

            Pair(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        public int orangesRotting(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int freshOranges = 0;
            Queue<Pair> queue = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new Pair(i, j));
                    } else if (grid[i][j] == 1) {
                        freshOranges++;
                    }
                }
            }

            if (freshOranges == 0)
                return 0;

            int minutes = 0;
            int[] directions = { -1, 0, 1, 0, -1 };
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean rotted = false;

                for (int i = 0; i < size; i++) {
                    Pair p = queue.poll();
                    int r = p.r;
                    int c = p.c;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + directions[d];
                        int nc = c + directions[d + 1];

                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            queue.add(new Pair(nr, nc));
                            freshOranges--;
                            rotted = true;
                        }
                    }
                }

                if (rotted) {
                    minutes++;
                }
            }
            return freshOranges == 0 ? minutes : -1;
        }
    }

}
