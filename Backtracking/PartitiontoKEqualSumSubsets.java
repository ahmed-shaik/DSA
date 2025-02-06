package Backtracking;
import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        reverse(nums);
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, 0, used, k, 0, target);
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private boolean backtrack(int[] nums, int start, boolean[] used, int remainingSubsets, int currentSum, int target) {
        if (remainingSubsets == 1) {
            return true;
        }
        if (currentSum == target) {
            return backtrack(nums, 0, used, remainingSubsets - 1, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && currentSum + nums[i] <= target) {
                used[i] = true;
                if (backtrack(nums, i + 1, used, remainingSubsets, currentSum + nums[i], target)) {
                    return true;
                }
                used[i] = false;
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return false;
    }
}