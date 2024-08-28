package Array.Easy;

import java.util.Arrays;

/**
 * Majorityelement
 */
public class Majorityelement {
    //sorting
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    
    //boyer moores voting algorithm
    
    public int majorityElement(int[] nums) {
        int el=0, count=1;
        for(int i=1; i<nums.length; i++) {
            if(nums[el] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if(count==0) {
                el=i;
                count=1;
            }
        }
        return nums[el];
    }
    public static void main(String[] args) {
        
    }
}