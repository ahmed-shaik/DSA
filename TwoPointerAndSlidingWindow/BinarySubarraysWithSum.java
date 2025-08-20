package TwoPointerAndSlidingWindow;

public class BinarySubarraysWithSum {
    class Solution {
        private int countSubarraysWithSumAtMost(int[] nums, int target) {
            if (target < 0) {
                return 0;
            }

            int left = 0;
            int currentSum = 0;
            int count = 0;

            for (int right = 0; right < nums.length; right++) {
                currentSum += nums[right];

                while (currentSum > target) {
                    currentSum -= nums[left];
                    left++;
                }

                count += (right - left + 1);
            }

            return count;
        }

        public int numSubarraysWithSum(int[] nums, int goal) {
            int countAtMostGoal = countSubarraysWithSumAtMost(nums, goal);
            int countAtMostGoalMinus1 = countSubarraysWithSumAtMost(nums, goal - 1);

            return countAtMostGoal - countAtMostGoalMinus1;
        }
    }

}
