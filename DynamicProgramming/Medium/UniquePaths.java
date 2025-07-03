package DynamicProgramming.Medium;

public class UniquePaths {
    // memoization
    class Solution {
        public int uniquePaths(int m, int n) {
            int dp[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return unique(m - 1, n - 1, dp);
        }

        public int unique(int i, int j, int[][] dp) {
            if (i == 0 && j == 0) {
                return 1;
            } else if (i < 0 || j < 0) {
                return 0;
            } else if (dp[i][j] != -1) {
                return dp[i][j];
            }
            int up = unique(i - 1, j, dp);
            int left = unique(i, j - 1, dp);
            return dp[i][j] = up + left;
        }
    }
}

// tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int up = 0;
                if (i - 1 >= 0) {
                    up = dp[i - 1][j];
                }
                int down = 0;
                if (j - 1 >= 0) {
                    down = dp[i][j - 1];
                }
                dp[i][j] = up + down;
            }
        }
        return dp[m - 1][n - 1];
    }

    // space optimization
    class Solution1 {
        public int uniquePaths(int m, int n) {
            int dp[] = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 0;
            }
            for (int i = 0; i < m; i++) {
                int temp[] = new int[n];
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        temp[0] = 1;
                        continue;
                    }
                    int up = dp[j];
                    int left = 0;
                    if (j > 0) {
                        left = temp[j - 1];
                    }
                    temp[j] = up + left;
                }
                dp = temp;
            }
            return dp[n - 1];
        }
    }
}
