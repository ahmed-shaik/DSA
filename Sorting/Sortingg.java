package Sorting;

public class Sortingg {
    public static void bubbleSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            boolean swap = false;
            for(int j=0; j<arr.length-i-1; j++) {
                // swap
                if(arr[j]> arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(swap==false) {
                break;
            }
        }
    }
    public static void printArray(int [] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        bubbleSort(arr);
        printArray(arr);
    }
}
