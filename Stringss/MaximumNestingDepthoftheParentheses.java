package Stringss;

public class MaximumNestingDepthoftheParentheses {
    
}
class Solution {
    public int maxDepth(String s) {
        int count=0, maxcount=0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='(') {
                count++;
                maxcount=Math.max(maxcount, count);
            } else if(ch==')') {
                count--;
            }
        }
        return maxcount;
    }
}
