package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC032 {

    class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() < 2){
                return 0;
            }
            char[] charArray = s.toCharArray();
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            for (int i=0;i<charArray.length;i++){
                if (stack.isEmpty()){
                    stack.push(i);
                }
                else {
                    if (charArray[i] == ')' && charArray[stack.peek()] == '('){
                        stack.pop();
                        int l = stack.isEmpty()? -1:stack.peek();
                        int temp = i-l;
                        res = Math.max(res, temp);
                    }
                    else {
                        stack.push(i);
                    }
                }
            }
            return res;
        }
    }
}
