package Array;

/**
 * RemoveDuplicate
 */

 //two pointers apporach
public class RemoveDuplicate {
    public static int removeDuplicates(int nums[]) {
        int i=1; 
        for(int j=1; j<nums.length; j++) {
            if(nums[i-1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        
    }
}