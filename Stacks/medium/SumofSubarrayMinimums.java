package Stacks.medium;

import java.util.Stack;

public class SumofSubarrayMinimums {

    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int pse[] = prevSmallerElement(arr);
            int nse[] = nextSmallerElement(arr);
            int total = 0;
            int MOD = 1_000_000_007;
            for (int i = 0; i < arr.length; i++) {
                int left = i - pse[i];
                int right = nse[i] - i;
                long contribution = ((long) arr[i] * left % MOD) * right % MOD;
                total = (int) ((total + contribution) % MOD);
            }
            return total;
        }

        private int[] prevSmallerElement(int[] arr) {
            int n = arr.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            return res;
        }

        private int[] nextSmallerElement(int[] arr) {
            int n = arr.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            return res;
        }
    }
}
