package LCSolution;

import java.util.*;

public class LC301 {

    class Solution {

        Set<String> res = new HashSet<>();

        public List<String> removeInvalidParentheses(String s) {

            // 表达式中需要删除的左括号和右括号数
            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    left ++;
                else if (s.charAt(i) == ')'){
                    right = left== 0 ? right+1:right;
                    left = left > 0 ? left-1:left;
                }
            }

            recursion(s, 0, 0, 0,left , right ,new StringBuilder());
            return new ArrayList<>(res);
        }

        private void recursion(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder expression){
            // 递归到底的情况
            if (index == s.length()){
                if (leftRem == 0 && rightRem == 0){
                    res.add(expression.toString());
                }
            }
            else {
                char curChar = s.charAt(index);
                int length = expression.length();

                if (curChar != '(' && curChar != ')'){
                    expression.append(curChar);
                    recursion(s, index+1, leftCount, rightCount, leftRem, rightRem, expression);
                    expression.deleteCharAt(length);
                }
                else {

                    if (curChar == '('){
                        if (leftRem > 0){
                            // 删除当前字符
                            recursion(s, index+1, leftCount, rightCount, leftRem-1, rightRem, expression);
                        }

                        expression.append(curChar);
                        recursion(s, index+1, leftCount+1, rightCount, leftRem, rightRem, expression);
                        expression.deleteCharAt(length);

                    }
                    // 右括号
                    else {
                        if (rightRem>0){
                            recursion(s, index+1, leftCount, rightCount, leftRem, rightRem-1, expression);
                        }
                        if (rightCount<leftCount){
                            expression.append(curChar);
                            recursion(s, index+1, leftCount, rightCount+1, leftRem, rightRem, expression);
                            expression.deleteCharAt(length);
                        }

                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Map<Integer,Integer> keyToVal;
        Map<Integer,Integer> keyToFreq;
        Map<Integer, LinkedHashSet<Integer>> freqTokey;
        int minFreq;
        int capacity;
     }
}
