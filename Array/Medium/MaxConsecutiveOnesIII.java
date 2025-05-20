package Array.Medium;

public class MaxConsecutiveOnesIII {
    class Solution1 {
        public int longestOnes(int[] nums, int k) {
            int l = 0, r = 0, maxlen = 0, z = 0;
            while (r < nums.length) {
                if (nums[r] == 0) {
                    z++;
                }
                while (z > k) {
                    if (nums[l] == 0) {
                        z--;
                    }
                    l++;
                }
                int len = r - l + 1;
                maxlen = Math.max(len, maxlen);
                r++;
            }
            return maxlen;
        }
    }

    class Solution {
        public int longestOnes(int[] nums, int k) {
            int l = 0, r = 0, maxlen = 0, z = 0;

            while (r < nums.length) {
                if (nums[r] == 0) {
                    z++;
                }
                if (z > k) {
                    if (nums[l] == 0) {
                        z--;
                    }
                    l++;
                }
                int len = r - l + 1;
                maxlen = Math.max(maxlen, len);
                r++;
            }

            return maxlen;
        }
    }

}
