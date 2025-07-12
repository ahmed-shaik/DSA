package DynamicProgramming.Hard;

public class ShortestCommonSupersequence {
    class Solution {
        public String shortestCommonSupersequence(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int i = 0; i <= m; i++) {
                dp[0][i] = 0;
            }
            for (int ind1 = 1; ind1 <= n; ind1++) {
                for (int ind2 = 1; ind2 <= m; ind2++) {
                    if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    } else {
                        dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            int i = n, j = m;
            while (i > 0 && j > 0) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ans.append(s1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    ans.append(s1.charAt(i - 1));
                    i--;
                } else {
                    ans.append(s2.charAt(j - 1));
                    j--;
                }
            }
            while (i > 0) {
                ans.append(s1.charAt(i - 1));
                i--;
            }
            while (j > 0) {
                ans.append(s2.charAt(j - 1));
                j--;
            }
            return ans.reverse().toString();
        }
    }

}