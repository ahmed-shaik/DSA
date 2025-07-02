package DynamicProgramming.Medium;

public class NinjasTraining {
    static int f(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return dp[day][last] = max;
        }
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int merit = points[day][i] + f(day - 1, i, points, dp);
                max = Math.max(max, merit);
            }
        }
        return dp[day][last] = max;
    }

    static int fTab(int[][] arr) {
        int dp[][] = new int[arr.length][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        for (int day = 1; day < arr.length; day++) {
            for (int last = 0; last < 3; last++) {
                int max = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int merit = arr[day][i] + dp[day - 1][i];
                        max = Math.max(max, merit);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[arr.length - 1][2];
    }

    static int ninjaTraining(int n, int[][] points) {
        // Initialize an array 'prev' to store the maximum points for the previous day
        int prev[] = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day starting from the second day
        for (int day = 1; day < n; day++) {
            // Initialize an array 'temp' to store the maximum points for the current day
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum
                        // points from the previous day
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            // Update 'prev' to store the maximum points for the current day
            prev = temp;
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return prev[3];
    }
}
