package DynamicProgramming.Medium;

public class PartitionEqualSubsetSum {

    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                return false;
            }
            return subSeq(n - 1, sum / 2, nums);
        }

        public boolean subSeq(int i, int tar, int arr[]) {
            if (i == 0) {
                return tar == arr[0];
            }
            if (tar == 0) {
                return true;
            }
            boolean pick = subSeq(i - 1, tar - arr[i], arr);
            boolean notPick = subSeq(i - 1, tar, arr);
            return pick || notPick;
        }
    }
}

class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int k = sum / 2;
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean not = dp[i - 1][j];
                boolean take = false;
                if (j >= arr[i]) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || not;
            }
        }
        return dp[n - 1][k];
    }

    public int subSeq(int i, int tar, int arr[], int dp[][]) {
        if (i == 0) {
            return tar == arr[0] ? 1 : 0;
        }
        if (tar == 0) {
            return 1;
        }
        if (dp[i][tar] != -1) {
            return dp[i][tar];
        }
        int pick = 0;
        if (tar >= arr[i]) {
            pick = subSeq(i - 1, tar - arr[i], arr, dp);
        }
        int notPick = subSeq(i - 1, tar, arr, dp);
        return (pick == 1 || notPick == 1) ? 1 : 0;
    }
}

class Solution1 {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int k = sum / 2;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        if (arr[0] <= k) {
            dp[arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            boolean temp[] = new boolean[k + 1];
            temp[0] = true;
            for (int j = 1; j <= k; j++) {
                boolean not = dp[j];
                boolean take = false;
                if (j >= arr[i]) {
                    take = dp[j - arr[i]];
                }
                temp[j] = take || not;
            }
            dp = temp;
        }
        return dp[k];
    }
}