package LC2026;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LC032 {

    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (queue.isEmpty()) {
                queue.offer(i);
            } else {
                if (s.charAt(i) == '(') {
                    queue.offer(i);
                } else {
                    if (!queue.isEmpty() && s.charAt(queue.getLast()) == '(') {
                        queue.pollLast();
                        int last = -1;
                        if (!queue.isEmpty()) {
                            last = queue.peekLast();
                        }
                        max = Math.max(max, i - last);
                    } else {
                        queue.addLast(i);
                    }
                }
            }
        }
        return max;
    }


}
