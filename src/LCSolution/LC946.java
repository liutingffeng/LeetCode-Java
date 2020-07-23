package LCSolution;

import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC946 {

    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {

            Deque<Integer> stack = new ArrayDeque<>();

            int j = 0;
            for (int i = 0; i < pushed.length; i++) {
                stack.addLast(pushed[i]);
                System.out.println(stack.peekLast());
                while (!stack.isEmpty() && stack.peekLast() == popped[j]){
                    stack.pollLast();
                    j++;
                }
            }

            return stack.isEmpty();
        }

        public static void main(String[] args) {
            int[] a = {1,2,3,4,5};
            int[] b = {4,5,3,2,1};
            new Solution().validateStackSequences(a, b);
        }
    }
}
