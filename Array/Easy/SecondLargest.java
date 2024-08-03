package Array.Easy;
/**
 * SecondLargest
 */
public class SecondLargest {
    public void print2largest(int arr[]) {
        int small, ssmall, large, slarge;
        small = Integer.MAX_VALUE;
        ssmall = Integer.MAX_VALUE;
        large = Integer.MIN_VALUE;
        slarge = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<ssmall && arr[i]!=small) {
                ssmall = arr[i];
            }
            if(arr[i]>slarge && arr[i]!=large) {
                slarge = arr[i];
            }
        }

    }
    public static void main(String[] args) {
        
    }    
    
}