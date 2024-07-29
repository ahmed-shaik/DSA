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
    public static int binarySearch(int arr[], int key) {
        /*  
            Binary Search
            prerequisite - sorted arrays
        */
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
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        return;
    }
    public static void reverseArr(int arr[]) {
        //Reverse an Array
        int n = arr.length;
        for(int i=0; i<n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        /*
            int first = 0, last = numbers.length—1;
            while(first < last) {
                int temp = numbers[last];
                numbers[last] = numbers [first[];
                numbers [first] = temp;
                first++;
                last--; 
            }
        */
    }
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
        // int arr[] = {1, 2, 6, 3, 5};
        // System.out.println("largest number is "+largestNum(arr));

        //binary search
        // int arr[] = {2, 4, 6, 8, 10, 12, 14};
        // int key = 0;
        // System.out.println("found at index "+binarySearch(arr, key));

        //Reverse an Array
        int arr[] = {1, 2, 6, 3, 5};
        reverseArr(arr);
        printArray(arr);
    }
}