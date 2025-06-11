package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Comparator;
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

    public static double fractionalKnapsack(int val[], int wt[], int W) {
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][1] = (double) val[i] / wt[i];
            ratio[i][0] = i;
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> -o[1]));
        int capacity = W;
        int finalvalue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= wt[idx]) {
                finalvalue += val[idx];
                capacity -= wt[idx];
            } else {
                finalvalue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }

        }
        return finalvalue;
    }

    public static int MinimumAbsoluteDifferencePairs(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min += Math.abs(a[i] - b[i]);
        }
        return min;
    }

    public static int MaximumLengthofPairChain(int[][] pairs) {
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

    public static int indianCoinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        ArrayList<Integer> usedCoins = new ArrayList<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
                usedCoins.add(coins[i]);
            }
        }
        for (int i = 0; i < usedCoins.size(); i++) {
            System.out.print(usedCoins.get(i) + " ");
        }
        return count;
    }

    public static void main(String[] args) {
        // Greedy algorithms is the problem solving technique where we make the
        // locally optimum choice at each stage & hope to achieve a global optimum.

        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };
        // System.out.println("\nThere are total of " + maxActivities(start, end) + "
        // activities selected.");

        // int val[] = { 60, 100, 120 };
        // int wt[] = { 10, 20, 30 };
        // int W = 50;
        // System.out.println("\nMaximum value in Knapsack = " + fractionalKnapsack(val,
        // wt, W));

        // int a[] = { 4, 1, 8, 7 };
        // int b[] = { 2, 3, 6, 5 };
        // System.out.println("\nMinimum Absolute Difference Pairs = " +
        // MinimumAbsoluteDifferencePairs(a, b));

        // int pairs[][] = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        // System.out.println("\nMaximum Length of Pair Chain = " +
        // MaximumLengthofPairChain(pairs));

        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 590;
        System.out.println("\nMinimum number of coins required = " + indianCoinChange(coins, amount));
    }
}
