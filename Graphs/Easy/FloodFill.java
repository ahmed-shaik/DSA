package Graphs.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    class Solution {
        static class Pair {
            int r, c;

            Pair(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color)
                return image;
            boolean vis[][] = new boolean[image.length][image[0].length];
            Queue<Pair> q = new LinkedList<>();
            int rows[] = { -1, 0, 1, 0 };
            int cols[] = { 0, 1, 0, -1 };
            int main = image[sr][sc];
            q.add(new Pair(sr, sc));
            image[sr][sc] = color;
            while (!q.isEmpty()) {
                Pair p = q.remove();
                vis[p.r][p.c] = true;
                for (int i = 0; i < rows.length; i++) {
                    int newRow = p.r + rows[i];
                    int newCol = p.c + cols[i];
                    if (newRow >= 0 && newRow < image.length &&
                            newCol >= 0 && newCol < image[0].length) {
                        if (!vis[newRow][newCol] && image[newRow][newCol] == main) {
                            image[newRow][newCol] = color;
                            vis[newRow][newCol] = true;
                            q.add(new Pair(newRow, newCol));
                        }
                    }
                }
            }

            return image;
        }
    }

}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Edge case: If the starting point already has the desired color, no fill is
        // needed
        if (image[sr][sc] == color)
            return image;

        int main = image[sr][sc]; // Store the original color
        dfs(image, sr, sc, color, main); // Call DFS to fill the image
        return image;
    }

    // DFS function to fill the connected area
    public void dfs(int[][] image, int r, int c, int color, int main) {
        // Base case: If the current cell is out of bounds or doesn't match the original
        // color
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != main) {
            return;
        }

        // Fill the current cell with the new color
        image[r][c] = color;

        // Call DFS on the 4 neighbors (up, down, left, right)
        dfs(image, r - 1, c, color, main); // Up
        dfs(image, r + 1, c, color, main); // Down
        dfs(image, r, c - 1, color, main); // Left
        dfs(image, r, c + 1, color, main); // Right
    }
}
