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
class Solution {
    public boolean rotateString(String s, String goal) {
    if(s.length()!=goal.length())
    return false;     
    StringBuilder sb = new StringBuilder(s);    
    for(int i=0; i<s.length(); i++)
    {
      if(sb.toString().equals(goal))
          return true; 
      char ch = sb.charAt(0);  
      sb.deleteCharAt(0);
      sb.append(ch);  
    }
        return false;
    }
}
