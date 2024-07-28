package Functions;
import java.util.*;
public class Function {
    public static void printHello() {
        System.out.println("Hello");
        return;
    }
    public static void sum(int a, int b) {
        System.out.println("Sum of " + a + "+" + b + "=" + (a+b));
    }
    public static void swap(int a, int b) {
        int temp = a;
        a=b;
        b=temp;
    }
    public static int fact(int n) {
        int f=1;
        for (int i=1; i<=n; i++) {
            f*=i;
        }
        return f;
    }
    public static int bincoeff(int n, int r) {
        int nf=fact(n);
        int rf=fact(r);
        int nrf=fact(n-r);

        return nf/(rf*nrf);
    }
    public static void main(String[] args) {
        /*
            Syntax
            returnType name ( ) {
            //body
            return statement;

            Syntax with Parameters 
            returnType name (paraml , param2) {
            //body
            return statement;
            }
            
         */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // sum(a,b);
        // printHello();
        sc.close();
        //call by value
        // swap(a,b);
        //Java doesent support call by reference
        /*
            Function Overloading Multiple functions with the same name but different parameters
        */
        
        System.out.println(bincoeff(a,b));
    }    
}