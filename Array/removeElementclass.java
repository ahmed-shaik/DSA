package Array;
//two pointers

public class removeElementclass {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0; j<nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        
    }
}
