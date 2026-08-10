package LC2026.sixMonth;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC094 {
    public int largestRectangleArea(int[] heights) {
        // 维护单调递增栈
        int n = heights.length;
        int[] h = new int[n + 2];
        System.arraycopy(heights, 0, h, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peekLast()]) {
                int height = h[stack.pollLast()];
                int width = i - (stack.isEmpty() ? 0 : stack.peekLast()) - 1;
                ans = Math.max(ans, height * width);
            }
            stack.addLast(i);
        }
        return ans;
    }
}
