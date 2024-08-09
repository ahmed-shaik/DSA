package Array.Medium;

/**
 * Powx_n
 */
public class Powx_n {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }
    }
    public static void main(String[] args) {
        
    }
}