package DynamicProgramming.Medium;

public class MinimumFallingPathSum {
    class Solution {
        public static void dpFill(int matrix[][], int dp[][]) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
        }

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int dp[][] = new int[n][n];
            dpFill(matrix, dp);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, tri(0, i, matrix, dp));
                dpFill(matrix, dp);
            }
            return min;
        }

        public static int tri(int i, int j, int[][] matrix, int[][] dp) {
            if (i == matrix.length - 1) {
                return matrix[i][j];
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            int dl = Integer.MAX_VALUE;
            if (j - 1 >= 0) {
                dl = matrix[i][j] + tri(i + 1, j - 1, matrix, dp);
            }
            int d = matrix[i][j] + tri(i + 1, j, matrix, dp);
            int dr = Integer.MAX_VALUE;
            if (j + 1 <= matrix.length - 1) {
                dr = matrix[i][j] + tri(i + 1, j + 1, matrix, dp);
            }
            return dp[i][j] = Math.min(d, Math.min(dl, dr));
        }
    }

    class Solutio1n {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, dfs(n - 1, j, matrix, dp));
            }

            return min;
        }

        public static int dfs(int i, int j, int[][] matrix, int[][] dp) {
            if (i == 0) {
                return matrix[i][j];
            }

            if (dp[i][j] != -1) {
                return dp[i][j];
            }

            int ul = Integer.MAX_VALUE;
            int u = dfs(i - 1, j, matrix, dp);
            int ur = Integer.MAX_VALUE;

            if (j > 0) {
                ul = dfs(i - 1, j - 1, matrix, dp);
            }
            if (j < matrix.length - 1) {
                ur = dfs(i - 1, j + 1, matrix, dp);
            }

            return dp[i][j] = matrix[i][j] + Math.min(u, Math.min(ul, ur));
        }
    }

}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int left = Integer.MAX_VALUE;
                if (j > 0) {
                    left = dp[i - 1][j - 1];
                }
                int right = Integer.MAX_VALUE;
                if (j < n - 1) {
                    right = dp[i - 1][j + 1];
                }
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
        }
        min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;

    }

    class Solution2 {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[] dp = new int[n];
            for (int i = 0; i < matrix.length; i++) {
                dp[i] = matrix[0][i];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                int temp[] = new int[n];
                for (int j = 0; j < n; j++) {
                    int up = dp[j];
                    int left = Integer.MAX_VALUE;
                    if (j > 0) {
                        left = dp[j - 1];
                    }
                    int right = Integer.MAX_VALUE;
                    if (j < n - 1) {
                        right = dp[j + 1];
                    }
                    temp[j] = matrix[i][j] + Math.min(up, Math.min(left, right));
                }
                dp = temp;
            }
            min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, dp[j]);
            }
            return min;

        }
    }

}
