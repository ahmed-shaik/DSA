package Array.Easy;

public class Collectingchocolates {
    class Solution {
        public long minCost(int[] n, int x) {
            long ans = 0L, tmp;
            int[] m = new int[n.length];
            for(int i=0; i<n.length; i++){m[i]=n[i]; ans+=n[i];}
            for(int j=1; j<n.length; j++){
                tmp= (long)j * x;;
                for(int i=0; i<n.length; i++){
                    m[i] = Math.min(m[i], n[(i+j)%n.length]);
                    tmp+=m[i];
                }
                if(ans>tmp)ans=tmp;
            }
            return ans;
        }
        //
    }
    public static void main(String[] args) {
        
    }
}
