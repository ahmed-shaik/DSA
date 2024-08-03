package Array.Easy;

public class MissingNumbers {
    public static int missingNumber(int[] nums) {
        // Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=i) {
                return i;
            }
        }
        return nums.length;
    }
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int actualSum = 0;
            
            for (int num : nums) {
                actualSum += num;
            }
    
            return n * (n + 1) / 2 - actualSum;
        }
    }
    public static void main(String[] args) {
        
    }
}
