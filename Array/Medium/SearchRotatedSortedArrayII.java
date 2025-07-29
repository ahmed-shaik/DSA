package Array.Medium;

public class SearchRotatedSortedArrayII {
    class Solution {
        public boolean search(int[] arr, int tar) {
            int n = arr.length;
            int lo = 0, hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] == tar) {
                    return true;
                } else if (arr[mid] == arr[lo] && arr[mid] == arr[hi]) {
                    lo++;
                    hi--;
                } else if (arr[mid] <= arr[hi]) {
                    if (tar > arr[mid] && tar <= arr[hi]) {
                        lo = mid + 1;
                    } else
                        hi = mid - 1;
                } else {
                    if (tar >= arr[lo] && tar < arr[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
            }
            return false;
        }
    }
}
