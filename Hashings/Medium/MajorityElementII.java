package Hashings.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MajorityElementII {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            if (nums.length == 0) {
                return list;
            } else if (nums.length == 1) {
                list.add(nums[0]);
                return list;
            }
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hm.containsKey(nums[i])) {
                    hm.put(nums[i], hm.get(nums[i]) + 1);
                } else {
                    hm.put(nums[i], 1);
                }
            }
            Set<Integer> s = hm.keySet();
            for (int i : s) {
                if ((hm.get(i)) > (nums.length / 3)) {
                    list.add(i);
                }
            }
            return list;
        }
    }

    class Solution2 {
        public List<Integer> majorityElement(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int num : nums) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (entry.getValue() > nums.length / 3) {
                    list.add(entry.getKey());
                }
            }
            return list;
        }
    }
}
