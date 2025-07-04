package DynamicProgramming.Medium;

public class MinimumPathSum {
    class Solution {
        public int minPathSum(int[][] arr) {
            int m = arr.length;
            int n = arr[0].length;
            int dp[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return minPath(m - 1, n - 1, arr, dp);
        }

        public static int minPath(int i, int j, int arr[][], int dp[][]) {
            if (i == 0 && j == 0) {
                return arr[i][j];
            } else if (dp[i][j] != -1) {
                return dp[i][j];
            }
            int minSum = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                minSum = Math.min(minSum, minPath(i - 1, j, arr, dp));
            }
            if (j - 1 >= 0) {
                minSum = Math.min(minSum, minPath(i, j - 1, arr, dp));
            }
            return dp[i][j] = arr[i][j] + minSum;
        }
    }

    class Solution1 {
        public int minPathSum(int[][] arr) {
            int m = arr.length;
            int n = arr[0].length;
            int dp[][] = new int[m][n];
            dp[0][0] = arr[0][0];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    int up = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        up = dp[i - 1][j] + arr[i][j];
                    }
                    int left = Integer.MAX_VALUE;
                    if (j - 1 >= 0) {
                        left = dp[i][j - 1] + arr[i][j];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    class Solution2 {
        public int minPathSum(int[][] arr) {
            int m = arr.length;
            int n = arr[0].length;
            int prev[] = new int[n];
            for (int i = 0; i < m; i++) {
                int curr[] = new int[n];
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        curr[0] = arr[0][0];
                    } else {
                        int up = Integer.MAX_VALUE;
                        if (i - 1 >= 0) {
                            up = prev[j] + arr[i][j];
                        }
                        int left = Integer.MAX_VALUE;
                        if (j - 1 >= 0) {
                            left = curr[j - 1] + arr[i][j];
                        }
                        curr[j] = Math.min(up, left);
                    }
                }
                prev = curr;
            }
            return prev[n - 1];
        }
    }
}
