package Recursion_Basics;

public class Recursion_basic {
    public static void PrintUpto10(int n) {
        if (n == 0) {
            return; // Base case
        }
        PrintUpto10(n - 1); 
        System.out.println(n); 
    }
    public static int fact(int n) {
        if(n==1) {
            return 1;
        }
        return n*fact(n-1);
    }
    public static int sumOfFirstN(int n) {
        if(n==1) {
            return 1;
        }
        return n + sumOfFirstN(n-1);        
    }
    public static int fib(int n) { 
        if(n==0 || n==1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    public static boolean isSorted(int arr[], int i) {
        if(i==arr.length-1) {
            return true;
        }
        if(arr[i]<arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int firstOcc(int arr[], int i, int tar) {
        if(i==arr.length) {
            return -1;
        }
        if(arr[i]== tar) {
            return i;
        }
        return firstOcc(arr, i+1, tar);
    }
    public static int lastOcc1(int arr[], int i, int tar, int val) {
        if(i==arr.length) {
            return val;
        }
        if(arr[i]== tar) {
            val = i;
        }
        return lastOcc1(arr, i+1, tar, val);
    }
    public static int lastOcc2(int arr[], int i, int tar) {
        if(i==arr.length) {
            return -1;
        }
        int isFound = lastOcc2(arr, i+1, tar);
        if(isFound != -1) {
            return isFound;
        }
        if(arr[i]== tar) {
            return i;
        }
        return isFound;
    }
    public static int printxPn(int x, int n) {
        if(n==1) {
            return x;
        }
        // return x*printxPn(x, n-1);

        int halfpower = printxPn(x, n/2);
        int halfPowerSq = halfpower*halfpower;
        if(n%2==0) {
            return halfPowerSq; 
        } else {
            return halfPowerSq*x;
        }
        // return n%2==0? halfpower*halfpower : halfpower*halfpower * x;
    }
    public static int tilingProblem(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        return tilingProblem(n-1) + tilingProblem(n-2);
    }
    public static void rDuplicaes(String s, int i, StringBuilder sb, boolean map[]) {
        if(i==s.length())  {
            System.out.println(sb);
            return;
        }
        if(map[s.charAt(i)-'a'] == false) {
            map[s.charAt(i)-'a']=true;
            rDuplicaes(s, i+1, sb.append(s.charAt(i)), map);
        } else {
            rDuplicaes(s, i+1, sb, map);
        }
    }
    public static int friendsPairing(int n) {
        if(n==1 || n==2) {
            return n;
        }
        return friendsPairing(n-1) + (n-1)*friendsPairing(n-2);
    }
    public static void printBin(int n, int lp, String sb) {
        if(n==0) {
            System.out.println(sb);
            return;
        }
        printBin(n-1, 0, sb+"0");
        if(lp==0) {
            printBin(n-1, 1, sb+"1");
        }
    }
    public static void main(String[] args) {
        // PrintUpto10(10);
        // System.out.println(fact(3));
        // System.out.println(sumOfFirstN(5));
        // System.out.println(fib(7));
        // System.out.println(isSorted(new int[]{1,2,9,4,9,5}, 0));
        // System.out.println(firstOcc(new int[]{1,2,9,4,9,5}, 0, 8));
        // System.out.println(lastOcc1(new int[]{1,2,9,4,9,5}, 0, 8, -1));
        // System.out.println(lastOcc2(new int[]{1,2,9,4,9,5}, 0, 9));
        // System.out.println(printxPn(2, 10));
        // System.out.println(tilingProblem(3));
        // boolean map[] = new boolean[26];
        // rDuplicaes("appnnacollege", 0, new StringBuilder(""), map);
        // System.out.println(friendsPairing(3));
        printBin(4, 0, "");
    }
}

