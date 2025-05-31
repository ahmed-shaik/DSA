package Queues.Medium;

import java.util.ArrayList;

public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    list.add(nums[i]);
                } else {
                    while (!list.isEmpty() && list.get(list.size() - 1) > 0
                            && list.get(list.size() - 1) < Math.abs(nums[i])) {
                        list.remove(list.size() - 1);
                    }
                    if (!list.isEmpty() && list.get(list.size() - 1) == Math.abs(nums[i])) {
                        list.remove(list.size() - 1);
                    } else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                        list.add(nums[i]);
                    }
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

}
