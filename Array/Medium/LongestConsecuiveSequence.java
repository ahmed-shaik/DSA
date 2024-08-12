package Array.Medium;

import java.util.Arrays;

/**
 * LongestConsecuiveSequence
 */
public class LongestConsecuiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int con = 1, max=1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] == nums[i]) {
                continue;
            } else if (nums[i+1] - nums[i] == 1) {
                con++;
                max = Math.max(max, con);
            } else {
                con = 1;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        
    }
}