package LC2026.sixMonth;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class LC155 {
    class MinStack {

        private Deque<Integer> stack = new ArrayDeque<>();
        private Deque<Integer> minStack = new ArrayDeque<>();

        public MinStack() {

        }

        public void push(int value) {
            stack.addLast(value);
            minStack.addLast(minStack.isEmpty() ? value : Math.min(value, minStack.peekLast()));
        }

        public void pop() {
            stack.pollLast();
            minStack.pollLast();
        }

        public int top() {
            return stack.peekLast();
        }

        public int getMin() {
            return minStack.peekLast();
        }
    }
}
