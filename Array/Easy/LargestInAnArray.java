package Array.Easy;

public class LargestInAnArray {
    public static int largest(int n, int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(largest(5, arr));
    }    
}
