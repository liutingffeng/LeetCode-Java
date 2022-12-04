package LC2022;

import java.util.HashMap;
import java.util.Map;

/**
 * [1,8,6,2,5,4,8,3,7]
 */
public class LC011 {

    public static int maxArea(int[] height) {
        if (height.length <= 1 )
            return 0;
        int l = 0, r = height.length - 1;
        int lval = height[l], rval = height[r];
        int maxValue = Math.min(lval,rval) * (r - l);
        while (l < r) {
            if (height[l] > lval) {
                lval = height[l];
            }
            if (height[r] > rval) {
                rval = height[r];
            }
            maxValue = Math.max(Math.min(lval,rval) * (r - l), maxValue);
            // 左边小
            if (rval > lval) {
                l++;
            } else {
                r--;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
