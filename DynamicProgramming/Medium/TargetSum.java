package DynamicProgramming.Medium;

public class TargetSum {

    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (target > sum || target < -sum) {
                return 0;
            }
            int offset = sum;
            int[] dp = new int[2 * sum + 1];
            dp[offset] = 1;
            for (int num : nums) {
                int[] nextDP = new int[2 * sum + 1];
                for (int i = -sum; i <= sum; i++) {
                    if (dp[i + offset] > 0) {
                        nextDP[i + num + offset] += dp[i + offset];
                        nextDP[i - num + offset] += dp[i + offset];
                    }
                }
                dp = nextDP;
            }
            return dp[target + offset];
        }
    }

}