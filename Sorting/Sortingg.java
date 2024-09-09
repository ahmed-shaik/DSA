package Sorting;
// import java.util.Arrays;

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
    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int sm = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j]<arr[sm]) {
                    sm = j;
                }
            }
            int temp = arr[sm];
            arr[sm] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    public static void countingSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int count [] = new int[max+1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0; i<count.length; i++) {
            while (count[i]>0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    public static void printArray(int [] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,4,1,3,2,4,3,7};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // Arrays.sort(arr);
        countingSort(arr);
        printArray(arr);
    }
}
