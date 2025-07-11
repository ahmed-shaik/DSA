package Greedy.Easy;

import java.util.*;

public class MinimumAbsoluteDifference {

    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                int diff = arr[i] - arr[i - 1];
                min = Math.min(min, diff);
            }
            for (int i = 1; i < arr.length; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff == min) {
                    list.add(Arrays.asList(arr[i - 1], arr[i]));
                }
            }
            return list;
        }
    }
}
