package Array.Medium;

public class MinimumNumberofDaystoMakemBouquets {
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            if((long) m*k > bloomDay.length) {
                return -1;
            }
            int low =1, high = (int) 1e9;
            while(low<high) {
                int mid = low+(high-low)/2;
                if(isPossible(bloomDay, m, k,mid)) {
                    high=mid;
                } else {
                    low=mid+1;
                }
            }
            return low;
        }
        public boolean isPossible(int[] bloomDay, int m, int k, int day) {
            int st = 0, n = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= day) { // If flower has bloomed by 'day'
                    st++; // Increase the streak of consecutive bloomed flowers
                    if (st == k) { // If we have enough consecutive flowers for a bouquet
                        n++; // Increment number of bouquets
                        st = 0; // Reset the streak
                    }
                    
                } else {
                    
                    st = 0; // Reset the streak if flower hasn't bloomed by 'day'
                }
            }
            return n >= m; // Return true if we can make at least 'm' bouquets
        }
    }
}
