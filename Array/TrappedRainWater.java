package Array;

public class TrappedRainWater {
    public static int rainWater(int height[]) {
        int trapped=0, water;
        int []lmax = new int[height.length];
        lmax[0] = height[0];
        for(int i=1; i<height.length; i++) {
            lmax[i] = Math.max(height[i], lmax[i-1]);
        }
        int []rmax = new int[height.length];
        rmax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            rmax[i] = Math.max(height[i], rmax[i+1]);
        }
        for(int i=0; i<height.length; i++) {
            water = Math.min(lmax[i], rmax[i]);
            trapped+=water-height[i];
        }
        return trapped;
    }
    public static void main(String[] args) {
        
    }
}
