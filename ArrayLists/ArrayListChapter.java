package ArrayLists;
import java.util.*;
// import java.util.Collections;

/**
 * ArrayListChapter
 */

public class ArrayListChapter {
    public static int storedWaterBrute(ArrayList<Integer> height)  {
        int cur=0, max=Integer.MIN_VALUE;
        for(int i=0; i<height.size(); i++) { 
            for(int j=i+1; j<height.size(); j++) {
                cur = (j-i)*Math.min(height.get(i), height.get(j));
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    public static int storedWaterLinear(ArrayList<Integer> height) {
        // two pointer apporach
        int max=Integer.MIN_VALUE, cur=0, lp=0, rp=height.size()-1;
        while(lp<rp) {
            cur = (rp-lp)*Math.min(height.get(lp), height.get(rp));
            max = Math.max(max, cur);
            if(height.get(lp)<height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return max;
    }       
    public static boolean pairSum1(ArrayList<Integer> list, int tar) {
        int lp=0, rp=list.size()-1, curr=0;
        while(lp<rp) {
            curr = list.get(lp)+list.get(rp);
            if(curr==tar) { 
                return true;
            }
            else if(curr<tar) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
    public static boolean pairSum2(ArrayList<Integer> list, int tar) {
        int rp=0,lp=0;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i)>list.get(i+1)) {
                rp=i;
                lp=i+1;
                break;
            }
        }
        while(lp!=rp) {
            int sum = list.get(lp)+list.get(rp);
            if(sum==tar) {
                return true;
            } else if(sum<tar) {
                lp = (lp+1)%list.size();
            } else {
                rp = (list.size()+rp-1)%list.size();
            }
        }
        return false;
    }
    public static boolean monotonicArrayList(ArrayList<Integer> list) {
        boolean flag = false;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i)<=list.get(i+1)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if(flag) {
            return true;
        }
        flag = false;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i)>=list.get(i+1)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
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

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> subList1 = new ArrayList<>();
        // ArrayList<Integer> subList2 = new ArrayList<>();
        // ArrayList<Integer> subList3 = new ArrayList<>();
        // for(int i=1; i<=5; i++) {
        //     subList1.add(1*i);
        //     subList2.add(2*i);
        //     subList3.add(3*i);
        // }
        // mainList.add(subList1);
        // mainList.add(subList2);
        // mainList.add(subList3);
        // // System.out.println(mainList);
        // for(int i=0; i<mainList.size(); i++) {
        //     System.out.println(mainList.get(i));
        // }
        ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);
        // Collections.sort(height);
        // // System.out.println(storedWaterLinear(height));
        // System.out.println(pairSum1(height, 16));
        height.add(1);
        height.add(3);
        height.add(2);
        System.out.println(monotonicArrayList(height));
    }   
}



