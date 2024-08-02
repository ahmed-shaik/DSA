package Array;

public class Applyoperationstoanarrays {
    public static int [] Applyoperationstoanarray(int [] nums) {
        int i=0;
        for(int j=0; j<nums.length; j++) {
            if(nums[j]==nums[j+1]) {
                nums[j]*=2;
                nums[j+1]=0;
            }
        }
        for(int j=0; j<nums.length; j++) {
            if(nums[j] != 0) {
                nums[i] = nums[j];
            }
        }
        for(int k=i; k<nums.length; k++) {
            nums[k]=0;
        }
        return nums;
    }
    public static void main(String[] args) {
        
    }
}
