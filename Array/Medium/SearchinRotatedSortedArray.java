package Array.Medium;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;  // Edge case: empty array
        }

        int n = nums.length;
        
        // Step 1: Find the pivot
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;  // Pivot is in the right half
            } else {
                right = mid;  // Pivot is in the left half
            }
        }
        
        int pivot = left;  // Pivot found
        left = 0;
        right = n - 1;

        // Step 2: Binary search considering the pivot
        while (left <= right) {
            int mid = (left + right) / 2;
            int realMid = (mid + pivot) % n;  // Adjust mid by adding the pivot and using modulo
            if (nums[realMid] == target) {
                return realMid;  // Target found
            } else if (nums[realMid] < target) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1;  // Search in the left half
            }
        }

        return -1;  // Target not found
    }
}
