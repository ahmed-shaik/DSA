package Stacks.medium;

public class DesignaStackWithIncrementOperation {
    class CustomStack {
        int[] s;
        int i;

        public CustomStack(int maxSize) {
            s = new int[maxSize];
            i = 0;
        }

        public void push(int x) {
            if (i == s.length) {
                return;
            }
            s[i++] = x;
        }

        public int pop() {
            if (i == 0) {
                return -1;
            }
            return s[--i];
        }

        public void increment(int k, int val) {
            int limit = Math.min(k, i);
            for (int j = 0; j < limit; j++) {
                s[j] += val;
            }
        }

    }

    /**
     * Your CustomStack object will be instantiated and called as such:
     * CustomStack obj = new CustomStack(maxSize);
     * obj.push(x);
     * int param_2 = obj.pop();
     * obj.increment(k,val);
     */
}
