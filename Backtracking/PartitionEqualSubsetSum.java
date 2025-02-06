package Backtracking;

public class PartitionEqualSubsetSum {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum=0;
            for(int i:nums) {
                sum+=i;
            }
            if(sum%2!=0) {
                return false;
            }
            boolean []used = new boolean[nums.length];
            return backtrack(0, 0, used, nums, sum/2);
        }
        public static boolean backtrack(int start, int currsum, boolean [] used, int[]nums, int tar) {
            if(currsum==tar) {
                return true;
            }
            for(int i=start; i<nums.length; i++) {
                if(!used[i] && currsum+nums[i]<=tar) {
                    used[i]=true;
                    if(backtrack(i+1, currsum+nums[i], used, nums, tar)) {
                        return true;
                    }
                    used[i]=false;
                }
            }
            return false;
        }
    }
}
