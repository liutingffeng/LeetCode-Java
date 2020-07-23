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
    }
}
