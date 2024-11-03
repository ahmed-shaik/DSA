package Stringss;

public class RotateString {
    class Solution {
        public boolean rotateString(String str, String goal) {
            if (str.length() != goal.length()) {
                return false;
            }
            String concatenated = str + str;
            return concatenated.contains(goal);
        }
    }
    
}
