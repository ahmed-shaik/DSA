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
    public static int gridWays(int i, int j, int n, int m) {
        if(i==n-1 && j==m-1) {
            return 1;
        } else if(i==n || j==n) {
            return 0;
        }
        return gridWays(i+1, j, n, m) + gridWays(i, j+1, n, m); 
    }
    public static boolean sudukoSolver(int[][] arr, int row, int col) {
        if(row==9) {
            return true;
        }
        int nextRow=row, nextCol=col+1;
        if(col+1==9) {
            nextRow=row+1;
            nextCol=0;
        }
        if(arr[row][col] !=0) {
            return sudukoSolver(arr, nextRow, nextCol);
        }
        for(int i=1; i<=9; i++) {
            if(isSafeSudoku(arr, row, col, i)) {
                arr[row][col] = i;
                if(sudukoSolver(arr, nextRow, nextCol)) {
                    return true;
                }
                arr[row][col]=0;
            }
        }
        return false;
    }
    public static boolean isSafeSudoku(int arr[][], int row, int col, int d ) {
        for(int i=0; i<9; i++) {
            if(arr[row][i]==d) {
                return false;
            }
        }
        for(int i=0; i<9; i++) {
            if(arr[i][col]==d) {
                return false;
            }
        }
        int sr=(row/3)*3,sc=(col/3)*3;
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(arr[i][j]==d) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // backTrackArray(0, arr);
        // printArray(arr);
        // findSubSets("abc", 0, "");
        // findPermutations("abc", "");
        // int n=5;
        // char board [][] = new char[n][n];
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         board[i][j] = 'x';
        //     }
        // }
        // nQueens(board, 0);
        // System.out.println(gridWays(0, 0, 3, 3));
        int sudoku[][] = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
        System.out.println(sudukoSolver(sudoku, 0, 0));
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }
}




