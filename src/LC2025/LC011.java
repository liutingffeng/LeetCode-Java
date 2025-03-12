package LC2025;

public class LC011 {

    public int maxArea(int[] height) {
        int length = height.length;
        int l = 0;
        int r = length - 1;
        int max = 0;
        while (l < r) {
            int lv = height[l];
            int rv = height[r];
            max = Math.max(max, Math.min(lv, rv) * (r - l));
            if (lv < rv) {
                l ++;
            } else {
                r --;
            }
        }
        return max;
    }
}
