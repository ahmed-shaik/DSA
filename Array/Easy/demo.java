package Array.Easy;

import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        int arr [][] = new int[2][2];
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
