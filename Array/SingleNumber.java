package Array;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        int i=0;
        while(i<nums.length-1) {
            if(nums[i]==nums[i+1]) {
                i+=2;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int unique=0;
            for(int i=0;i<nums.length;i++){
                unique=unique^nums[i];
            }
            return unique;
        }
    }
    public static void main(String[] args) {
        
    }
}
