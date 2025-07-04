package DynamicProgramming.Medium;

public class UniquePathsII {
    class Solution {
        public int uniquePathsWithObstacles(int[][] arr) {
            int dp[][] = new int[arr.length][arr[0].length];
            if (arr[0][0] == 1) {
                return 0;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 1) {
                        dp[i][j] = -2;
                    } else {
                        dp[i][j] = -1;
                    }
                }
            }
            return count(arr.length - 1, arr[0].length - 1, dp);
        }

        public static int count(int i, int j, int[][] dp) {
            if (i == 0 && j == 0) {
                return 1;
            } else if (i < 0 || j < 0) {
                return 0;
            } else if (dp[i][j] == -2) {
                return 0;
            } else if (dp[i][j] != -1) {
                return dp[i][j];
            }
            int up = count(i - 1, j, dp);
            int down = count(i, j - 1, dp);
            return dp[i][j] = up + down;
        }
    }

    class Solution1 {
        public int uniquePathsWithObstacles(int[][] arr) {
            int dp[] = new int[arr[0].length];
            if (arr[0][0] == 1) {
                return 0;
            }
            for (int i = 0; i < arr.length; i++) {
                int temp[] = new int[arr[0].length];
                for (int j = 0; j < arr[0].length; j++) {
                    if (i == 0 && j == 0) {
                        temp[j] = 1;
                        continue;
                    }
                    if (arr[i][j] == 1) {
                        temp[j] = 0;
                        continue;
                    }
                    int up = dp[j];
                    int left = 0;
                    if (j - 1 >= 0) {
                        left = temp[j - 1];
                    }
                    temp[j] = up + left;
                }
                dp = temp;
            }
            return dp[arr[0].length - 1];
        }
    }
}
