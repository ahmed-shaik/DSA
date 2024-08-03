package Array.Easy;
/*
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

 */
public class BinarySearchlc {
    public static int binarySearch(int arr[], int key) {
        int l=arr[0], r=arr.length;
        while (l<=r) {
            int mid = (l+r)/2;
            if(arr[mid]>key) {
                r=mid-1;
            } else if(arr[mid]<key) {
                l=mid+1;
            } else {
                return mid;
            }
        }  
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {-1,0,3,5,9,12};
        int key = 9;
        int result = binarySearch(arr, key);
        System.out.println("Index of " + key + " is: " + result);
        key = 2;
        result = binarySearch(arr, key);
        System.out.println("Index of " + key + " is: " + result);
    }
}
