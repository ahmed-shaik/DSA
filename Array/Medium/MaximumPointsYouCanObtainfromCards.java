package Array.Medium;

public class MaximumPointsYouCanObtainfromCards {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int lsum = 0, maxsum = 0, rsum = 0;
            for (int i = 0; i < k; i++) {
                lsum += cardPoints[i];
            }
            maxsum = lsum;
            int j = 1;
            while (j <= k) {
                rsum += cardPoints[cardPoints.length - j];
                lsum -= cardPoints[k - j];
                maxsum = Math.max(maxsum, rsum + lsum);
                j++;
            }
            return maxsum;
        }
    }
}
