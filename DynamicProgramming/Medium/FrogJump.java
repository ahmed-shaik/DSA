package DynamicProgramming.Medium;

public class FrogJump {

    // User function Template for Java
    class Solution {
        int minCost(int[] h) {
            // code here
            return helper(h, h.length - 1);
        }

        public static int helper(int[] h, int i) {
            if (i == 0) {
                return 0;
            }
            int o = helper(h, i - 1) + Math.abs(h[i] - h[i - 1]);
            int t = Integer.MAX_VALUE;
            if (i > 1)
                t = helper(h, i - 2) + Math.abs(h[i] - h[i - 2]);

            return Math.min(o, t);
        }
    }

    // optimization
    // User function Template for Java
    class Solution1 {
        int minCost(int[] h) {
            // code here
            int prev1 = 0;
            int prev2 = 0;
            for (int i = 1; i < h.length; i++) {
                int o = prev1 + Math.abs(h[i] - h[i - 1]);
                int t = Integer.MAX_VALUE;
                if (i > 1)
                    t = prev2 + Math.abs(h[i] - h[i - 2]);
                int curr = Math.min(o, t);
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
    }
}