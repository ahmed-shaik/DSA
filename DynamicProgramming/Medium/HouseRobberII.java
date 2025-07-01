package DynamicProgramming.Medium;

public class HouseRobberII {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int one = nums[0];
            nums[0] = 0;
            int haa = rob2(nums);
            nums[0] = one;
            nums[nums.length - 1] = 0;
            int ha = rob2(nums);
            return Math.max(ha, haa);
        }

        public int rob2(int[] nums) {
            int prev2 = nums[0];
            int prev1 = Math.max(prev2, nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int pick = prev2 + nums[i];
                int nopick = prev1;
                int max = Math.max(pick, nopick);
                prev2 = prev1;
                prev1 = max;
            }
            return prev1;
        }
    }
}
