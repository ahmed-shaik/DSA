package Greedy.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
            int last = pairs[0][1], count = 1;
            for (int i = 1; i < pairs.length; i++) {
                if (pairs[i][0] > last) {
                    last = pairs[i][1];
                    count++;
                }
            }
            return count;
        }
    }
}
