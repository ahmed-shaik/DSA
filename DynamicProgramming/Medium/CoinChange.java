package DynamicProgramming.Medium;

public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int a) {
            int n = coins.length;
            int dp[][] = new int[n][a + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= a; j++) {
                    dp[i][j] = -1;
                }
            }
            int ans = doYourThing(coins.length - 1, a, coins, dp);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        public static int doYourThing(int i, int a, int[] arr, int dp[][]) {
            if (a == 0) {
                return 0;
            }
            if (i == 0) {
                if (a % arr[i] == 0) {
                    return a / arr[i];
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            if (dp[i][a] != -1) {
                return dp[i][a];
            }
            int notPick = doYourThing(i - 1, a, arr, dp);
            int pick = Integer.MAX_VALUE;
            if (arr[i] <= a) {
                int subProblem = doYourThing(i, a - arr[i], arr, dp);
                if (subProblem != Integer.MAX_VALUE) {
                    pick = 1 + subProblem;
                }
            }
            return Math.min(pick, notPick);
        }
    }

    class Solutio1n {
        public int coinChange(int[] coins, int a) {
            int n = coins.length;
            int dp[][] = new int[n][a + 1];
            for (int i = 0; i <= a; i++) {
                if (i % coins[0] == 0) {
                    dp[0][i] = i / coins[0];
                } else {
                    dp[0][i] = Integer.MAX_VALUE;
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= a; j++) {
                    int notPick = dp[i - 1][j];
                    int pick = Integer.MAX_VALUE;
                    if (coins[i] <= j) {
                        int subProblem = dp[i][j - coins[i]];
                        if (subProblem != Integer.MAX_VALUE) {
                            pick = 1 + subProblem;
                        }
                    }
                    dp[i][j] = Math.min(pick, notPick);
                }
            }
            int ans = dp[n - 1][a];
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}

class Solution {
    public int coinChange(int[] coins, int a) {
        int n = coins.length;
        int dp[] = new int[a + 1];
        for (int i = 0; i <= a; i++) {
            if (i % coins[0] == 0) {
                dp[i] = i / coins[0];
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] temp = new int[a + 1];
            for (int j = 0; j <= a; j++) {
                int notPick = dp[j];
                int pick = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    int subProblem = temp[j - coins[i]];
                    if (subProblem != Integer.MAX_VALUE) {
                        pick = 1 + subProblem;
                    }
                }
                temp[j] = Math.min(pick, notPick);
            }
            dp = temp;
        }
        int ans = dp[a];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}