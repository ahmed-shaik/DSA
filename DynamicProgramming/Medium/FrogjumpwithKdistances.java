package DynamicProgramming.Medium;

public class FrogjumpwithKdistances {
    // recurscion
    class Solution {
        public int frogJump(int[] h, int k) {
            if (k == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            for (int i = k - 1; i >= 0; i--) {
                int jumpCost = frogJump(h, i) + Math.abs(h[k] - h[i]);
                max = Math.max(max, jumpCost);
            }
            return max;
        }
    }

    // Memoization
    class Solution1 {
        public int frogJump(int[] h, int k, int dp[]) {
            if (k == 0) {
                return 0;
            }
            if (dp[k] != -1) {
                return dp[k];
            }
            int max = Integer.MIN_VALUE;
            for (int i = k - 1; i >= 0; i--) {
                int jumpCost = frogJump(h, i, dp) + Math.abs(h[k] - h[i]);
                max = Math.max(max, jumpCost);
            }
            return dp[k] = max;
        }
    }

    // tabulation

    static int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }
}
