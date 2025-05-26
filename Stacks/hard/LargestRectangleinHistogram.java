package Stacks.hard;

import java.util.Stack;

public class LargestRectangleinHistogram {
    class Solution {
        public static int[] nextSmallerLeft(int[] heights) {
            Stack<Integer> s = new Stack<>();
            int[] nextSmallerLeft = new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    nextSmallerLeft[i] = -1;
                } else {
                    nextSmallerLeft[i] = s.peek();
                }
                s.push(i);
            }
            return nextSmallerLeft;
        }

        public static int[] nextSmallerRight(int[] heights) {
            Stack<Integer> s = new Stack<>();
            int[] nextSmallerRight = new int[heights.length];
            for (int i = heights.length - 1; i >= 0; i--) {
                while (!s.isEmpty() && heights[i] < heights[s.peek()]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    nextSmallerRight[i] = heights.length;
                } else {
                    nextSmallerRight[i] = s.peek();
                }
                s.push(i);
            }
            return nextSmallerRight;
        }

        public static int largestRectangleArea(int[] heights) {
            int nextSmallerLeft[] = new int[heights.length];
            int nextSmallerRight[] = new int[heights.length];
            nextSmallerLeft = nextSmallerLeft(heights);
            nextSmallerRight = nextSmallerRight(heights);
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                int area = (nextSmallerRight[i] - nextSmallerLeft[i] - 1) * heights[i];
                max = Math.max(max, area);
            }
            return max;
        }
    }
}
