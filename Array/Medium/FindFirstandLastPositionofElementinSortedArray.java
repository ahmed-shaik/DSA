package Array.Medium;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0]=-1;
        arr[1]=-1;
        int start=0, end = nums.length-1;
        while(start<=end) {
            int mid=(start+end)/2;
            if(nums[mid]<target) {
                start=mid+1;
            } else if(nums[mid]>target) {
                end=mid-1;
            } else {
                arr[0]=mid;
                end=mid-1;
            }
        }
        start=0; end = nums.length-1;
        while(start<=end) {
            int mid=(start+end)/2;
            if(nums[mid]<target) {
                start=mid+1;
            } else if(nums[mid]>target) {
                end=mid-1;
            } else {
                arr[1]=mid;
                start=mid+1;
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        
    }
}
