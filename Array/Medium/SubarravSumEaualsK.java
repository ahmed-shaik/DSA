package Array.Medium;

public class SubarravSumEaualsK {
    public int subarraySum(int[] nums, int k) {
        int c=0;
        if(nums.length==1 && k==nums[0])
            return nums[0];
        int prefixsum[] = new int[nums.length];
        prefixsum[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            prefixsum[i] = nums[i] + prefixsum[i-1];
        }
        for(int i=0; i<nums.length; i++) {
            for(int j=1; j<nums.length; j++) {
                int cs = i==0 ? prefixsum[j] : prefixsum[j] - prefixsum[i-1];
                if(cs==k) 
                    c++;
            }
        }
        return c;
    }    public static void main(String[] args) {
        
    }
}
