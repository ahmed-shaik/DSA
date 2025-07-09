package DynamicProgramming.Medium;

//same aas lcs
public class LongestPalindromicSubsequence {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            String s2 = new String(new StringBuilder(s).reverse());
            int m = s.length();
            int n = s2.length();
            int dp[] = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i] = 0;
            }
            for (int i1 = 1; i1 <= m; i1++) {
                int temp[] = new int[n + 1];
                for (int i2 = 1; i2 <= n; i2++) {
                    if (s.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
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
}
