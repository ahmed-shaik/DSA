package DynamicProgramming.Medium;

public class EditDistance {

    class Solution {
        public int minDistance(String s, String t) {
            int sl = s.length();
            int tl = t.length();
            int dp[][] = new int[sl + 1][tl + 1];
            for (int j = 0; j <= sl; j++) {
                dp[0][j] = j + 1;
            }
            for (int i = 0; i <= tl; i++) {
                dp[i][0] = i + 1;
            }

            return edit(sl - 1, tl - 1, s, t);
        }

        public static int edit(int i, int j, String s, String t) {
            if (i < 0) {
                return j + 1;
            }
            if (j < 0) {
                return i + 1;
            }
            if (s.charAt(i) == t.charAt(j))
                return edit(i - 1, j - 1, s, t);
            else {
                int insert = 1 + edit(i, j - 1, s, t);
                int delete = 1 + edit(i - 1, j, s, t);
                int replace = 1 + edit(i - 1, j - 1, s, t);
                return Math.min(insert, Math.min(delete, replace));
            }
        }
    }
}

class Solution {
    public int minDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int dp[][] = new int[sl + 1][tl + 1];
        for (int j = 0; j <= tl; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= sl; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= tl; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[sl][tl];
    }
}

class Solution1 {
    public int minDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int dp[] = new int[tl + 1];
        for (int j = 0; j <= tl; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= sl; i++) {
            int temp[] = new int[tl + 1];
            temp[0] = i;
            for (int j = 1; j <= tl; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    temp[j] = dp[j - 1];
                else {
                    int insert = 1 + temp[j - 1];
                    int delete = 1 + dp[j];
                    int replace = 1 + dp[j - 1];
                    temp[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            dp = temp;
        }
        return dp[tl];
    }
}