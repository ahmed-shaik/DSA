package DynamicProgramming.Hard;

public class DistinctSubsequences {
    class Solution {
        public int numDistinct(String s, String t) {
            int n = s.length(), m = t.length();
            int dp[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = -1;
                }
            }
            return count(n - 1, m - 1, s, t, dp);
        }

        public static int count(int i, int j, String s, String t, int dp[][]) {
            if (j < 0) {
                return 1;
            }
            if (i < 0) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (s.charAt(i) == t.charAt(j)) {
                return dp[i][j] = count(i - 1, j - 1, s, t, dp) + count(i - 1, j, s, t, dp);
            } else {
                return dp[i][j] = count(i - 1, j, s, t, dp);
            }
        }
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}

class Soluti1on {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int dp[] = new int[m + 1];
        for (int j = 0; j <= m; j++) {
            dp[j] = 0;
        }
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int temp[] = new int[m + 1];
            temp[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    temp[j] = dp[j - 1] + dp[j];
                } else {
                    temp[j] = dp[j];
                }
            }
            dp = temp;
        }
        return dp[m];
    }
}