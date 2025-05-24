package Stacks.medium;

import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {
    class StockSpanner {
        Stack<Integer> s;
        ArrayList<Integer> span;

        public StockSpanner() {
            s = new Stack<>();
            span = new ArrayList<>();
        }

        public int next(int price) {
            span.add(price);
            if (span.size() == 1) {
                s.push(0);
                return 1;
            }
            while (!s.isEmpty() && span.get(s.peek()) <= price) {
                s.pop();
            }
            int r;
            if (s.isEmpty()) {
                r = (span.size() - 1) + 1;
            } else {
                r = (span.size() - 1) - s.peek();
            }
            s.push(span.size() - 1);
            return r;
        }
    }

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
}
