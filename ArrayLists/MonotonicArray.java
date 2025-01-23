package ArrayLists;

public class MonotonicArray {
    class Solution {
        public boolean isMonotonic(int[] nums) {
            if(nums.length==1 || nums.length==0)
                return true;
            boolean flag=false;
            for(int i=0; i<nums.length-1; i++) {
                if(nums[i]<=nums[i+1]) {
                    flag=true;
                } else {
                    flag=false;
                    break;
                }
            }
            if(flag) return flag;
            flag=false;
            for(int i=0; i<nums.length-1; i++) {
                if(nums[i]>=nums[i+1]) {
                    flag=true;
                } else {
                    flag=false;
                    break;
                }
            }
            return flag;
        }
    }
}
