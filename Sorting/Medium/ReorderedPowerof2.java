package Sorting.Medium;

import java.util.Arrays;

public class ReorderedPowerof2 {

    class Solution {
        public boolean reorderedPowerOf2(int n) {
            String nStr = Integer.toString(n);
            char[] nChars = nStr.toCharArray();
            Arrays.sort(nChars);
            String sortedN = new String(nChars);
            for (int i = 0; i <= 30; i++) {
                int powerOf2 = (int) Math.pow(2, i);
                String powerStr = Integer.toString(powerOf2);
                char[] powerChars = powerStr.toCharArray();
                Arrays.sort(powerChars);
                String sortedPower = new String(powerChars);
                if (sortedN.equals(sortedPower)) {
                    return true;
                }
            }
            return false;
        }
    }
}
