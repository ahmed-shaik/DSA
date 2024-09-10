package Sorting;

public class countSortgrf {
        public static String countSort(String arr) {
        int[] count = new int[26];
        for (int i = 0; i < arr.length(); i++) {
            count[(int) (arr.charAt(i)) - 97]++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<count.length; i++) {
            while(count[i]!=0) {
                sb.append((char)(97+i));
                count[i]--;
            }
        }
        return sb.toString();
    }
}
        