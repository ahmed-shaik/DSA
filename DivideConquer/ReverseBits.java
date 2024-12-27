package DivideConquer;

public class ReverseBits {
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed <<= 1;
            int bit = n & 1;
            reversed |= bit;
            n >>= 1;
        }
        return reversed;
    }
}
