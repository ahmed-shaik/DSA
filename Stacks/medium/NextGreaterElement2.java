package Stacks.medium;

import java.util.Stack;

public class NextGreaterElement2 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] arr = new int[n];
            Stack<Integer> s = new Stack<>();

            for (int i = 2 * n - 1; i >= 0; i--) {
                int index = i % n;
                while (!s.isEmpty() && nums[s.peek()] <= nums[index]) {
                    s.pop();
                }
                arr[index] = s.isEmpty() ? -1 : nums[s.peek()];
                s.push(index);
            }

            return arr;
        }
    }

}
