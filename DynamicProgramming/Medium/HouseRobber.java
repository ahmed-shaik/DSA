package DynamicProgramming.Medium;

public class HouseRobber {
    // memoization
    class Solution {
        public int rob(int[] nums) {
            int dp[] = new int[nums.length + 1];
            for (int i = 0; i <= nums.length; i++) {
                dp[i] = -1;
            }
            return helper(nums, 0, dp);
        }

        public static int helper(int[] nums, int i, int[] dp) {
            if (i >= nums.length) {
                return 0;
            }
            if (dp[i] != -1) {
                return dp[i];
            }
            int o = helper(nums, i + 2, dp) + nums[i];
            int e = helper(nums, i + 1, dp);
            return dp[i] = Math.max(o, e);
        }
    }

    // tabulation
    class Solution1 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int dp[] = new int[nums.length + 1];
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int pick = dp[i - 2] + nums[i];
                int nopick = dp[i - 1];
                dp[i] = Math.max(pick, nopick);
            }
            return dp[nums.length - 1];
        }

        // optimization
        class Solution {
            public int rob(int[] nums) {
                if (nums.length == 0) {
                    return 0;
                }
                if (nums.length == 1) {
                    return nums[0];
                }
                int dp[] = new int[nums.length + 1];
                dp[0] = nums[0];
                dp[1] = Math.max(dp[0], nums[1]);
                for (int i = 2; i < nums.length; i++) {
                    int pick = Integer.MIN_VALUE;
                    pick = dp[i - 2] + nums[i];
                    int nopick = dp[i - 1];
                    dp[i] = Math.max(pick, nopick);
                }
                return dp[nums.length - 1];
            }
        }
    }
}
