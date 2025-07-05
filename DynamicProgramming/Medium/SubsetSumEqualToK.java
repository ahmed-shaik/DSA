// package DynamicProgramming.Medium;

// public class SubsetSumEqualToK {
// public class Solution {
// public static boolean subset11SumToK(int n, int k, int arr[]) {
// return tell(n - 1, k, arr);
// }

// public static boolean tell(int idx, int tar, int arr[]) {
// if (tar == 0) {
// return true;
// }
// if (idx == 0) {
// return tar == arr[idx];
// }
// boolean not = tell(idx - 1, tar, arr);
// boolean take = false;
// if (tar >= arr[idx]) {
// take = tell(idx - 1, tar - arr[idx], arr);
// }
// return take || not;
// }
// }

// public class Solution1 {
// public static boolean subs1etSumT1oK(int n, int k, int arr[]) {
// int[][] dp = new int[n][k + 1];
// for (int i = 0; i < n; i++) {
// for (int j = 0; j <= k; j++) {
// dp[i][j] = -1;
// }
// }
// return tell(n - 1, k, arr, dp) == 1;
// }

// public static int tell(int idx, int tar, int arr[], int dp[][]) {
// if (tar == 0) {
// return 1;
// }
// if (idx == 0) {
// return tar == arr[idx] ? 1 : 0;
// }
// if (dp[idx][tar] != -1) {
// return dp[idx][tar];
// }
// int not = tell(idx - 1, tar, arr, dp);
// int take = 0;
// if (tar >= arr[idx]) {
// take = tell(idx - 1, tar - arr[idx], arr, dp);
// }
// return dp[idx][tar] = (take == 1 || not == 1) ? 1 : 0;
// }
// }

// public static boolean subsetSumTo1K(int n, int k, int arr[]) {
// boolean[][] dp = new boolean[n][k + 1];
// for (int i = 0; i < n; i++) {
// dp[i][0] = true;
// }
// if (arr[0] <= k) {
// dp[0][arr[0]] = true;
// }
// for (int i = 1; i < n; i++) {
// for (int j = 1; j <= k; j++) {
// boolean not = dp[i - 1][j];
// boolean take = false;
// if (j >= arr[i]) {
// take = dp[i - 1][j - arr[i]];
// }
// dp[i][j] = take || not;
// }
// }
// return dp[n - 1][k];
// }

// }

// public static boolean su1bsetSumToK1(int n, int k, int arr[]) {
// boolean[] dp = new boolean[k + 1];
// dp[0] = true;
// if (arr[0] <= k) {
// dp[arr[0]] = true;
// }
// for (int i = 1; i < n; i++) {
// boolean temp[] = new boolean[k + 1];
// temp[0] = true;
// for (int j = 1; j <= k; j++) {
// boolean not = dp[j];
// boolean take = false;
// if (j >= arr[i]) {
// take = dp[j - arr[i]];
// }
// temp[j] = take || not;
// }
// dp = temp;
// }
// return dp[k];
// }

// public static boolean subsetSumTfsfsfsoK(int n, int k, int arr[]) {
// boolean[] dp = new boolean[k + 1];
// dp[0] = true;
// if (arr[0] <= k) {
// dp[arr[0]] = true;
// }
// for (int i = 1; i < n; i++) {
// boolean temp[] = new boolean[k + 1];
// temp[0] = true;
// for (int j = 1; j <= k; j++) {
// boolean not = dp[j];
// boolean take = false;
// if (j >= arr[i]) {
// take = dp[j - arr[i]];
// }
// temp[j] = take || not;
// }
// dp = temp;
// }
// return dp[k];
// }
// }