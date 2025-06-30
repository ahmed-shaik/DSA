package DynamicProgramming;

public class DP {
    public static int fibNrml(int n) {
        if (n <= 1) {
            return n;
        }
        return fibNrml(n - 1) + fibNrml(n - 2);
    }

    public static int fibMem(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibMem(n - 1, dp) + fibMem(n - 2, dp);
    }

    // Tabulation
    public static int fibTab(int n) {
        if (n <= 1) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fibTabOpt(int n) {
        if (n <= 1) {
            return n;
        }
        int prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            int fib = prev2 + prev;
            prev2 = prev;
            prev = fib;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(fibNrml(6));
        int dp[] = new int[10];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println(fibMem(6, dp));
        System.out.println(fibMem(7, dp));
        System.out.println(fibTab(6));
        System.out.println(fibTab(7));
        System.out.println(fibTabOpt(6));
    }
}