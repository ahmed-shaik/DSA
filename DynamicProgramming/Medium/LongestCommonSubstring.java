package DynamicProgramming.Medium;

public class LongestCommonSubstring {

    public static int longestCommonSubstring(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 0;
        }
        int maxLength = 0;
        for (int i1 = 1; i1 <= m; i1++) {
            int temp[] = new int[n + 1];
            for (int i2 = 1; i2 <= n; i2++) {
                if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
                    temp[i2] = 1 + dp[i2 - 1];
                    maxLength = Math.max(maxLength, temp[i2]);
                } else {
                    temp[i2] = 0;
                }
            }
            dp = temp;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("eat", "sea"));
    }
}