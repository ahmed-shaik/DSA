package DynamicProgramming.Easy;

public class ClimbingStairs {
    // memoiztion
    class Solution {
        public int climbStairs(int n) {
            int dp[] = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i] = -1;
            }
            return helper(n, dp);
        }

        public static int helper(int n, int[] dp) {
            if (n <= 1) {
                return 1;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        }
    }

    // tabulation
    class Solution1 {
        public int climbStairs(int n) {
            int dp[] = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    // optimized
    class Solution2 {
        public int climbStairs(int n) {
            int p0 = 1;
            int p1 = 1;
            for (int i = 2; i <= n; i++) {
                int c = p0 + p1;
                p0 = p1;
                p1 = c;
            }
            return p1;
        }
    }
}
