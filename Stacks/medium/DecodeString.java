package Stacks.medium;

import java.util.Stack;

public class DecodeString {
    class Solution {
        public String decodeString(String str) {
            Stack<String> s = new Stack<>();
            Stack<Integer> n = new Stack<>();
            StringBuilder num = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (Character.isDigit(ch)) {
                    num.append(ch); // collect multi-digit numbers
                } else if (ch == '[') {
                    n.push(Integer.parseInt(num.toString()));
                    num.setLength(0); // reset number builder
                    s.push("[");
                } else if (ch == ']') {
                    StringBuilder sb = new StringBuilder();
                    while (!s.peek().equals("[")) {
                        sb.insert(0, s.pop());
                    }
                    s.pop(); // remove the '['
                    int repeatCount = n.pop();
                    String repeated = sb.toString().repeat(repeatCount);
                    s.push(repeated);
                } else {
                    s.push(String.valueOf(ch));
                }
            }

            // Final result assembly
            StringBuilder result = new StringBuilder();
            for (String part : s) {
                result.append(part);
            }

            return result.toString();
        }
    }

}
