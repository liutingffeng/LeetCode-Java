package LC2026;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC084 {

    public int largestRectangleArea(int[] heights) {
        // 单调栈
        int n = heights.length;
        int[] h = new int[n + 2];
        System.arraycopy(heights, 0, h, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = i - (stack.isEmpty() ? 0 : stack.peek()) - 1;
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
        return ans;
    }


}
