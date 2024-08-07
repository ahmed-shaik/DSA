package Array.Medium;

/**
 * RearanArrayElementsbySign
 */
public class RearanArrayElementsbySign {
    public int[] rearrangeArray(int[] nums) {
        int e=0,o=1;
        int arr[] = new int [nums.length];
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) {
                arr[e] = nums[i];
                e+=2;
            } else {
                arr[o] = nums[i];
                o+=2;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        
    }
}