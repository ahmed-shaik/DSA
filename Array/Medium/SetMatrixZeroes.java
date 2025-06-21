package Array.Medium;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int rowsArray[] = new int[m];
        int colsArray[] = new int[n];

        Arrays.fill(rowsArray, 1);
        Arrays.fill(colsArray, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowsArray[i] = 0;
                    colsArray[j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowsArray[i] == 0 || colsArray[j] == 0)
                    matrix[i][j] = 0;
            }
        }
    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            int row[] = new int[matrix.length];
            int col[] = new int[matrix[0].length];
            for (int i = 0; i < row.length; i++) {
                row[i] = 1;
            }
            for (int i = 0; i < col.length; i++) {
                col[i] = 1;
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = 0;
                        col[j] = 0;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (row[i] == 0 || col[j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {

    }
}
