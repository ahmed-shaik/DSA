package Array.Medium;

import java.util.ArrayList;

public class RangeProductQueriesofPowers {
    class Solution {
        public int[] productQueries(int n, int[][] q) {
            ArrayList<Integer> arr = new ArrayList<>();
            int i = 1;
            while (i != 0) {
                int k = n & i;
                if (k != 0) {
                    arr.add(k);
                }
                i <<= 1;
            }
            int res[] = new int[q.length];
            for (int j = 0; j < res.length; j++) {
                res[j] = find(arr, q[j]);
            }
            return res;
        }

        public static int find(ArrayList<Integer> arr, int[] f) {
            int st = f[0];
            int l = f[1];
            long ans = 1;
            int mod = 1000000007;
            for (int i = st; i <= l; i++) {
                ans = (ans * arr.get(i)) % mod;
            }
            return (int) ans;
        }
    }
}
