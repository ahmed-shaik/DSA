package Stacks.medium;

import java.util.Stack;

public class MinStack {
    class MinStacks {
        Stack<Integer> s;
        Stack<Integer> min;

        public MinStacks() {
            s = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            s.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            }
        }

        public void pop() {
            int popped = s.pop();
            if (popped == min.peek()) {
                min.pop();
            }
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

}
