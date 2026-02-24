package LC2026;

public class LC11 {
    // 滑动窗口
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxRes = 0;
        int iv = 0, jv = 0;
        while (i < j) {
            iv = height[i];
            jv = height[j];
            maxRes = Math.max(maxRes, Math.min(iv, jv) * (j - i));
            if (iv <= jv)
                i++;
            else
                j--;
        }
        return maxRes;
    }
}
