package DivideConquer;

public class DivideConquer_Chapter {
    public static void mergeSort(int arr[], int si, int ei) {
        if(si>=ei) {
            return;
        }
        int mid=si+(ei-si)/2; 
        mergeSort(arr, si,mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp [] = new int[ei-si+1];
        int i=si, j=mid+1, k=0;
        while(i<=mid && j<=ei) {
            if(arr[i]<arr[j]) { 
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        while(j<=ei) {
            temp[k++] = arr[j++];
        }
        for(k=si, i=0; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    //Quick sort
    public static void quickSort(int [] arr, int si, int ei) {
        if(si<=ei) {
            return;
        }
        int pi=partition(arr, si, ei);
        quickSort(arr, si, pi-1);
        quickSort(arr, pi+1, ei);
    }
    public static int partition(int [] arr, int si, int ei) {
        int p=arr[ei],i=si-1;
        for(int j=si; j<ei; j++) {
            if(arr[j]<=p) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static int searchInRotatedSortedArray(int[] arr, int tar, int si, int ei) {
        int mid = si + (ei-si)/2;
        while(si<=ei) {
            if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]) {
                return mid;
            }
            if(arr[mid]>tar) {
                ei = mid-1;
            } else if(arr[mid]<tar) {
                si = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        System.out.println(searchInRotatedSortedArray(arr, 0, 0, arr.length-1));
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


























