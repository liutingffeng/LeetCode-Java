package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC150 {

    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (String s:tokens){
                if (s.equals("+") || s.equals("-")|| s.equals("*")||s.equals("/")){
                    int num2 = deque.pollLast();
                    int num1 = deque.pollLast();
                    int res = 0;
                    if (s.equals("+")){
                        res = num1+num2;
                    }
                    else if (s.equals("-")){
                        res = num1-num2;
                    }
                    else if (s.equals("*")){
                        res = num1*num2;
                    }
                    else {
                        res = num1/num2;
                    }
                    deque.addLast(res);
                }
                else {
                    deque.addLast(Integer.valueOf(s));
                }
            }
            return deque.pollLast();
        }
    }
}
