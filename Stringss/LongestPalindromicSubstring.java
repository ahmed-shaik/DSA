package Stringss;

public class LongestPalindromicSubstring {
    
}
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int maxLength = 0;
        String longestPal = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        longestPal = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPal;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}