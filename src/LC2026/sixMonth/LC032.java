package LC2026.sixMonth;

import LC2025.ListNode;
import org.testng.annotations.IFactoryAnnotation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC032 {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty() || s.charAt(i) == '(') {
                deque.addLast(i);
                continue;
            }
            if (s.charAt(deque.peekLast()) == '(') {
                deque.pollLast();
                int l = deque.isEmpty() ? -1 : deque.peekLast();
                res = Math.max(res, (i - l));
            } else {
                deque.addLast(i);
            }
        }
        return res;
    }
}
