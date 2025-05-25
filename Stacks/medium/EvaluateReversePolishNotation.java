package Stacks.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i];
                if (!(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
                    s.push(Integer.parseInt(token));
                } else {
                    int b = s.pop();
                    int a = s.pop();
                    int result = 0;
                    switch (token) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "/":
                            result = a / b;
                            break;
                    }
                    s.push(result);
                }
            }
            return s.pop();
        }
    }

}
