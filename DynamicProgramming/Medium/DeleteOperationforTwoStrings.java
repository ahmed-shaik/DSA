package DynamicProgramming.Medium;

public class DeleteOperationforTwoStrings {
    class Solution {
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

        public int minDistance(String w1, String w2) {
            return w1.length() + w2.length() - 2 * longestCommonSubsequence(w1, w2);
        }
    }
}
