package Array;

public class MoveZeroes {
    //two pointers approach
    public void moveZeroes(int[] nums) {
        int i=0;
        for(int j=0; j<nums.length; j++) {
            if(nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for(int k=i; k<nums.length; k++) {
            nums[k]=0;
        }
    }
    public static void main(String[] args) {
        
    }
}
