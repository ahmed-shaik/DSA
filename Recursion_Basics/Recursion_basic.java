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
    public static void main(String[] args) {
        // PrintUpto10(10);
        // System.out.println(fact(3));
        System.out.println(sumOfFirstN(5));
    }
}
