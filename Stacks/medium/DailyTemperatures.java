package Stacks.medium;

import java.util.Stack;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temp) {
            int arr[] = new int[temp.length];
            Stack<Integer> s = new Stack<>();
            for (int i = temp.length - 1; i >= 0; i--) {
                while (!s.isEmpty() && temp[i] >= temp[s.peek()]) {
                    s.pop();
                }
                if (!s.isEmpty()) {
                    arr[i] = s.peek() - i;
                } else {
                    arr[i] = 0;
                }
                s.push(i);
            }
            return arr;
        }
    }
}
