package ArrayLists;

public class MostFrequentNumberFollowingKeyInanArray {
    class Solution {
        public int mostFrequent(int[] nums, int key) {
            int arr[] = new int[1001], res=0;
            for(int i=0; i<nums.length-1; i++) {
                if(nums[i]==key && ++arr[nums[i+1]]>arr[res]) {
                    res = nums[i+1];
                }
            }
            return res;
        }
    }
}
