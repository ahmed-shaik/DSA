package Array.Hard;

import java.util.Arrays;

public class Medianoftwosortedarrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        int arr[] = new int[n+m];
        for(int i=0; i<n; i++) {
            arr[i] = nums1[i];
        }
        for(int i=n,j=0; j<m; i++,j++) {
            arr[i] = nums2[j];
        }
        Arrays.sort(arr);
        int mid = arr.length/2;
        if(arr.length%2!=0) {
            return (double)arr[mid];
        } else {
            return ((double)arr[mid-1]+(double)arr[mid])/2;
        }
    }
    public static void main(String[] args) {
        
    }
}
