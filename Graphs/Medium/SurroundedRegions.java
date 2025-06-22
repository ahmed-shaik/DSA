package Graphs.Medium;

public class SurroundedRegions {
    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0)
                return;

            int n = board.length;
            int m = board[0].length;
            boolean[][] vis = new boolean[n][m];

            for (int j = 0; j < m; j++) {
                if (board[0][j] == 'O' && !vis[0][j]) {
                    dfs(board, vis, 0, j);
                }
                if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                    dfs(board, vis, n - 1, j);
                }
            }

            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O' && !vis[i][0]) {
                    dfs(board, vis, i, 0);
                }
                if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                    dfs(board, vis, i, m - 1);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O' && !vis[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public static void dfs(char[][] board, boolean[][] vis, int r, int c) {
            int n = board.length;
            int m = board[0].length;
            if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != 'O' || vis[r][c])
                return;
            vis[r][c] = true;
            dfs(board, vis, r - 1, c);
            dfs(board, vis, r + 1, c);
            dfs(board, vis, r, c - 1);
            dfs(board, vis, r, c + 1);
        }
    }

}
