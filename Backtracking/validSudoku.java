package Backtracking;

public class validSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
         for(int i=0;i<9;i++)
         {
             for(int j=0;j<9;j++)//traverse in bfs manner 
             {
                 char ch=board[i][j];
                 if(ch!='.')//if ch is apart from '.'we need to check whether the given number is verifiable
                 {
                     board[i][j]='.';//change it to . so that it cannot consider itself
                     if(!isSafe(ch,board,i,j))//if not verifiable
                         return false;//invalid sudoku
                     board[i][j]=ch;//after checking change it to its initial value
                 }
             }
         }
            return true;
        }
        public static boolean isSafe(char ch, char[][] board, int row, int col) {
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == ch) {
                    return false;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == ch) {
                    return false;
                }
            }
            int sr = (row / 3) * 3, sc = (col / 3) * 3;
            for (int i = sr; i < sr + 3; i++) {
                for (int j = sc; j < sc + 3; j++) {
                    if (board[i][j] == ch) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
