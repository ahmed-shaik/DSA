package Greedy.Medium;

import java.util.*;

public class InsertInterval {

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<int[]> result = new ArrayList<>();
            int i = 0;
            int n = intervals.length;
            int start = newInterval[0];
            int end = newInterval[1];

            // Add all intervals ending before newInterval starts
            while (i < n && intervals[i][1] < start) {
                result.add(intervals[i++]);
            }

            // Merge overlapping intervals
            while (i < n && intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
                i++;
            }

            // Add the merged interval
            result.add(new int[] { start, end });

            // Add remaining intervals
            while (i < n) {
                result.add(intervals[i++]);
            }

            // Convert result list to array
            return result.toArray(new int[result.size()][]);
        }
    }

}
