package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC155 {

    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty())
                minStack.push(x);
            else {
                int min = minStack.peek();
                if (x<min)
                    minStack.push(x);
                else
                    minStack.push(min);
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
