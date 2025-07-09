package DynamicProgramming.Medium;

public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            return lca(text1.length() - 1, text2.length() - 1, text1, text2);
        }

        public static int lca(int i1, int i2, String s1, String s2) {
            if (i1 < 0 || i2 < 0) {
                return 0;
            }
            if (s1.charAt(i1) == s2.charAt(i2)) {
                return 1 + lca(i1 - 1, i2 - 1, s1, s2);
            }
            return Math.max(lca(i1 - 1, i2, s1, s2), lca(i1, i2 - 1, s1, s2));
        }
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return lca(m - 1, n - 1, text1, text2, dp);
    }

    public static int lca(int i1, int i2, String s1, String s2, int dp[][]) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }
        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] = 1 + lca(i1 - 1, i2 - 1, s1, s2, dp);
        }
        return dp[i1][i2] = Math.max(lca(i1 - 1, i2, s1, s2, dp), lca(i1, i2 - 1, s1, s2, dp));
    }
}

class Solut1ion {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i1 = 1; i1 <= m; i1++) {
            for (int i2 = 1; i2 <= n; i2++) {
                if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                } else {
                    dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

class Sol2ution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 0;
        }
        for (int i1 = 1; i1 <= m; i1++) {
            int temp[] = new int[n + 1];
            for (int i2 = 1; i2 <= n; i2++) {
                if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
                    temp[i2] = 1 + dp[i2 - 1];
                } else {
                    temp[i2] = Math.max(dp[i2], temp[i2 - 1]);
                }
            }
            dp = temp;
        }
        return dp[n];
    }
}
