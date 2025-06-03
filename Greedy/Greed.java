package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Greed {
    public static int maxActivities(int start[], int end[]) {
        // Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        int n = start.length;
        int i = 0, j, count = 1;
        System.out.print("Selected activities are: " + i + " ");
        for (j = 1; j < n; j++) {
            if (start[j] >= end[i]) {
                System.out.print(j + " ");
                i = j;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Greedy algorithms is the problem solving technique where we make the
        // locally optimum choice at each stage & hope to achieve a global optimum.
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println("\nThere are total of " + maxActivities(start, end) + " activities selected.");
    }
}
