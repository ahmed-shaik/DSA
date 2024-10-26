package Recursion_Basics;

public class PowerOfTwo {
    class Solution {
        public boolean isPowerOfTw0(int n) {
            
            if(n<1) {
                
                return false;
                
            }
            if(n==1) {
                return true;
            }
            return (n%2==0) && isPowerOfTw0(n/2);
        }
    }
}
