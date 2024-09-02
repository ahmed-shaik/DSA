package Array.Medium;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;  
        }
        
        StringBuilder sb = new StringBuilder();
        int max = 0;
        
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // If current character is in the StringBuilder, move the start position
            int index = sb.indexOf(String.valueOf(currentChar));
            if (index != -1) {
                sb.delete(0, index + 1);  // Remove all characters up to the duplicate
            }
            
            sb.append(currentChar);  // Add the current character
            max = Math.max(max, sb.length());  // Update max length if needed
        }
        
        return max;  // Return the maximum length found
    }
}
