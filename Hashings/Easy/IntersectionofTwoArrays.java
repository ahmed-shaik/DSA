package Hashings.Easy;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionofTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> h1 = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                h1.add(nums1[i]);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums2.length; j++) {
                if (h1.contains(nums2[j])) {
                    list.add(nums2[j]);
                    h1.remove(nums2[j]);
                }
            }
            int i = 0;
            int[] arr = new int[list.size()];
            while (!list.isEmpty()) {
                arr[i++] = list.remove(list.size() - 1);
            }
            return arr;
        }
    }
}
