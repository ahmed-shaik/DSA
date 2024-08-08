package Array.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * SpiralMatrix
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int sr=0, sc=0, er=matrix.length-1, ec= matrix[0].length-1;
        while(sc<=ec && sr<=er) {
            for(int j=sc; j<=ec; j++) {
                list.add(matrix[sr][j]);
            }
            for(int i=sr+1; i<=er; i++) {
                list.add(matrix[i][ec]);
            }
            if(sr!=er) {
                for(int j=ec-1; j>=sc; j--) {
                    list.add(matrix[er][j]);
                }
            }
            if(sc!=ec) {
                for(int i=er-1; i>=sr+1; i--){
                    list.add(matrix[i][sc]);
                }
            }
            sc++;
            sr++;
            ec--;
            er--;
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}