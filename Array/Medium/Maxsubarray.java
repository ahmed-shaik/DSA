package Array.Medium;

public class Maxsubarray { 
    
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cs=0;
        for(int i=0; i<nums.length; i++) {
            cs+=nums[i];
            if(cs<0) {
                cs=0;
            }
            max = Math.max(max, cs);
        }
        return max;
    }
    public static void main(String[] args) {
        
    }
}
