package Backtracking;

public class BackTrack {
    public static void backTrackArray(int i, int [] arr) {
        if(i==arr.length) {
            return;
        }
        arr[i] = i+1;
        backTrackArray(i+1, arr);
        arr[i] = arr[i]-2;
    }
    public static void findSubSets(String str, int i, String sb) {
        if(i==str.length()) {
            System.out.println(sb);
            return;
        }
        findSubSets(str, i+1, sb+str.charAt(i));
        findSubSets(str, i+1, sb);
    }
    public static void findPermutations(String str, String ans) {
        if(str.length()==0) {
            System.out.println(ans);
            return ;
        }
        for(int i=0; i<str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutations(newStr, ans+str.charAt(i));
        }
    }
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    } 
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // backTrackArray(0, arr);
        // printArray(arr);
        // findSubSets("abc", 0, "");
        findPermutations("abc", "");
    }
}
