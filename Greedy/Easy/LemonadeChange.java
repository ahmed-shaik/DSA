package Greedy.Easy;

public class LemonadeChange {
    class Solution {
        public boolean lemonadeChange(int[] b) {
            int five = 0, ten = 0;

            for (int i = 0; i < b.length; i++) {
                if (b[i] == 5) {
                    five++;
                } else if (b[i] == 10) {
                    if (five == 0)
                        return false;
                    five--;
                    ten++;
                } else {
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }
    }

}
