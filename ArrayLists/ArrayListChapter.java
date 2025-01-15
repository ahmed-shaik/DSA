package ArrayLists;
import java.util.*;
// import java.util.Collections;

/**
 * ArrayListChapter
 */

public class ArrayListChapter {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // // ArrayList<String> l2 = new ArrayList<>();
        // // ArrayList<Boolean> l3 = new ArrayList<>();
        // list.add(1); //O(1)
        // list.add(2);
        // list.add(3);
        // System.out.println(list);
        // int a = list.get(0); //O(1)
        // System.out.println(a);
        // list.remove(a); //O(n)
        // System.out.println(list);
        // list.set(1,15); //0(n)
        // System.out.println(list);
        // System.out.println(list.contains(15));
        // System.out.println(list.size());
        // for(int i=0; i<list.size(); i++) {
        //     System.out.println(list.get(i));
        // }

        //revere of an arraylist 
        // for(int i=list.size()-1; i>=0; i--) {
        //     System.out.println(list.get(i));
        // }

        //max in arraylist
        // int max = list.get(0);
        // for(int i=1; i<list.size(); i++) {
        //     max = Math.max(max,list.get(i));
        // }
        // System.out.println("Max: " + max);
        // Collections.sort(list);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> subList1 = new ArrayList<>();
        ArrayList<Integer> subList2 = new ArrayList<>();
        ArrayList<Integer> subList3 = new ArrayList<>();
        for(int i=1; i<=5; i++) {
            subList1.add(1*i);
            subList2.add(2*i);
            subList3.add(3*i);
        }
        mainList.add(subList1);
        mainList.add(subList2);
        mainList.add(subList3);
        // System.out.println(mainList);
        for(int i=0; i<mainList.size(); i++) {
            System.out.println(mainList.get(i));
        }
    }
}
