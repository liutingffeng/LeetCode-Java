package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC394 {

    class Solution {
        public String decodeString(String s) {
            Deque<Integer> dequeInt = new ArrayDeque<>();
            Deque<String> dequeStr = new ArrayDeque<>();
            StringBuilder res = new StringBuilder();
            int multi = 0;
            for (char c:s.toCharArray()){
                if (c == '['){
                    dequeInt.addLast(multi);
                    dequeStr.addLast(res.toString());
                    res = new StringBuilder();
                    multi = 0;
                }
                else if (c == ']'){
                    int cur_multi = dequeInt.removeLast();
                    StringBuilder temp = new StringBuilder();
                    while (cur_multi-->0){
                        temp.append(res);
                    }
                    res = new StringBuilder(dequeStr.removeLast()+temp);
                }
                else if ('0'<=c && c<='9'){
                    multi = multi*10 + Integer.parseInt(c+"");
                }
                else
                    res.append(c);
            }
            return res.toString();
        }

        // "3[a2[c]]"
//        public String decodeString(String s) {
//
//            char[] charArray = s.toCharArray();
//            Deque<String> stack = new ArrayDeque<>();
//            Deque<String> helper = new ArrayDeque<>();
//
//            for (int i = 0; i < charArray.length; ) {
//                if (charArray[i] == ']'){
//                    // 开始处理
//                    StringBuilder temp = new StringBuilder();
//                    while (!stack.peekLast().equals("[")){
//                        helper.addLast(stack.pollLast());
//                    }
//                    while (!helper.isEmpty()){
//                        temp.append(helper.pollLast());
//                    }
//                    stack.pollLast();
//                    int num = Integer.parseInt(stack.pollLast());
//                    String cur  = temp.toString();
//                    StringBuilder newStr = new StringBuilder();
//                    while (num -- > 0){
//                        newStr.append(cur);
//                    }
//                    stack.addLast(newStr.toString());
//
//                    i++;
//                }
//                else if (charArray[i]>='0' && charArray[i]<='9'){
//                    int num = 0;
//                    while (charArray[i]>='0' && charArray[i]<='9'){
//                        num = num*10 + charArray[i]-'0';
//                        i++;
//                    }
//                    stack.addLast(String.valueOf(num));
//                }
//                else {
//                    stack.addLast(String.valueOf(charArray[i]));
//                    i++;
//                }
//            }
//            StringBuilder res = new StringBuilder();
//            while (!stack.isEmpty()){
//                res.append(stack.pollFirst());
//            }
//            return res.toString();
//        }
    }
}
