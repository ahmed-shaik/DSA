package Recursion_Basics;

public class PowerOfThree {
    
    class Solution {
        public boolean isPowerOfThree(int n) {
            if(n<1) {
                return false;
            }
            
            if(n==1) {
                return true;
            }
            
            return (n%3==0) && isPowerOfThree(n/3);
            
        }
    }
}