package Array.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascalestriangle
 */
public class Pascalestriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else if (i - 1 > -1 && j - 1 > -1) {
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(val);
                }
            }

            result.add(row);
        }

        return result;
    }
    public static void main(String[] args) {
        
    }
}