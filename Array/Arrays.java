package Array;

public class Arrays {
    public static int linearSearch(int arr[], int key) {
        /*
            Linear Search:
            find the index of element in a given array key : 10 
        */
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==key) {
                System.out.println("Found at index: " + i);
                return i;
            }
        }
        return -1;
    }
    public static int largestNum(int arr[]) {
        /*
        Largest Number:
        find the largest number in a given array
        */
        int lar = arr[0]; // lar = Integer.MIN_VALUE
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>lar) {
                lar = arr[i];
            }
        }

        return lar;
    }
    /*
        Largest Number:
        find the largest number in a given array
    */
    public static void main(String[] args) {
        /*
            Creating an Array
            dataType arrayName[] = new dataType[size];
            int marks []= new int[50];
            int numbers [] = {1, 2, 3};
            int moreNumbers [] = {4 , 5, 6};
            String fruits [] = {"apple", "mango", "orange"}; 
        */
        
        // linear search
        // int arr[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int key = 10;
        // linearSearch(arr, key);

        //lagest number
        int arr[] = {1, 2, 6, 3, 5};
        System.out.println("largest number is "+largestNum(arr));
    }
}