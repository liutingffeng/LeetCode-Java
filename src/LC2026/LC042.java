package LC2026;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

public class LC042 {

    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            if (deque.isEmpty()) {
                deque.push(i);
                continue;
            }
            int cur = height[i];
            while (!deque.isEmpty()) {
                int lastIndex = deque.getLast();
                int last = height[lastIndex];
                if (last < cur) {
                    deque.pollLast();
                    if (!deque.isEmpty()) {
                        int preIndex = deque.getLast();
                        res += (Math.min(height[preIndex], cur) - last) * (i - preIndex - 1);
                    }
                } else {
                    break;
                }
            }
            deque.addLast(i);
        }
        return res;
    }


}
