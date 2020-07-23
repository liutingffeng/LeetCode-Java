package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC020 {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = s.toCharArray();
            for (int i=0;i<s.length();i++){
                if (stack.isEmpty()){
                    stack.push(charArray[i]);
                }
                else if ((')'==charArray[i] && stack.peek() == '(' )||
                        (']'==charArray[i] && stack.peek() == '[' ) ||
                         ('}'==charArray[i] && stack.peek() == '{' )){
                    stack.pop();
                }
                else {
                    stack.push(charArray[i]);
                }
            }
            return stack.empty();
        }
    }
}
