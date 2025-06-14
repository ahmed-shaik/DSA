package Greedy.Medium;

public class ValidParenthesisString {

    class Solution {
        public boolean checkValidString(String s) {
            int min = 0, max = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(') {
                    min++;
                    max++;
                } else if (ch == ')') {
                    min--;
                    max--;
                } else {
                    min--;
                    max++;
                }

                if (min < 0) {
                    min = 0; // Prevent min from becoming negative (invalid state)
                }

                if (max < 0) {
                    return false; // If max becomes negative, it's invalid
                }
            }

            return min == 0; // At the end, min should be 0 for a valid string
        }
    }

}