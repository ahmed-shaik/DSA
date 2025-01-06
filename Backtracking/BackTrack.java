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
    public static void nQueens(char board[][], int row) {
        if(row==board.length) {
            printBoard(board);
            return;
        }
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'x';
            }
        }   
    }
    public static boolean isSafe(char board[][], int row, int col) {
        for(int i=row-1; i>=0; i--) {
            if(board[i][col]=='Q') {
                return false;
            }
        }
        for(int i=row-1,j=col-1; i>=0&& j>=0; i--,j--) {
            if(board[i][j]=='Q') {
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++) {
            if(board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]) {
        System.out.println("___________________________________________________");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // backTrackArray(0, arr);
        // printArray(arr);
        // findSubSets("abc", 0, "");
        // findPermutations("abc", "");
        int n=5;
        char board [][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
    }
}
