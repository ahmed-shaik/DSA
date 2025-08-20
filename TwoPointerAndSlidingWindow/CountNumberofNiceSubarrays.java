package TwoPointerAndSlidingWindow;

public class CountNumberofNiceSubarrays {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int countAtMostGoal = helper(nums, k);
            int countAtMostGoalMinus1 = helper(nums, k - 1);
            return countAtMostGoal - countAtMostGoalMinus1;
        }

        public static int helper(int[] nums, int k) {
            if (k < 0) {
                return 0;
            }
            int left = 0;
            int currentSum = 0;
            int count = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] % 2 == 1) {
                    currentSum++;
                }
                while (currentSum > k) {
                    if (nums[left] % 2 == 1) {
                        currentSum--;
                    }
                    left++;
                }
                count += (right - left + 1);
            }
            return count;
        }
    }

}
