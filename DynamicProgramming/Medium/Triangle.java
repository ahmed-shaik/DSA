package DynamicProgramming.Medium;

import java.util.List;

public class Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> list) {
            int n = list.size();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return tri(0, 0, list, dp);
        }

        public static int tri(int i, int j, List<List<Integer>> list, int[][] dp) {
            if (i == list.size() - 1) {
                return list.get(i).get(j);
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            int down = list.get(i).get(j) + tri(i + 1, j, list, dp);
            int diag = list.get(i).get(j) + tri(i + 1, j + 1, list, dp);
            return dp[i][j] = Math.min(down, diag);
        }
    }

}

class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int n = list.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = list.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = list.get(i).get(j) + dp[i + 1][j];
                int diag = list.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}

class Solution1 {
    public int minimumTotal(List<List<Integer>> list) {
        int n = list.size();
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = list.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            int[] temp = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = list.get(i).get(j) + prev[j];
                int diag = list.get(i).get(j) + prev[j + 1];
                temp[j] = Math.min(down, diag);
            }
            prev = temp;
        }
        return prev[0];
    }
}
