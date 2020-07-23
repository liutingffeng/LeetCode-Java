package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC071 {

    class Solution {
        public String simplifyPath(String path) {
            String[] pathArray = path.split("/");
            Deque<String> deque = new ArrayDeque<>();
            for (String s : pathArray){
                if (s.equals(".") || s.equals(""))
                    continue;
                else if (s.equals("..")){
                    if (!deque.isEmpty())
                        deque.pollLast();
                }
                else
                    deque.addLast(s);
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()){
                sb.append('/');
                sb.append(deque.pollFirst());
            }

            return sb.length() == 0 ? "/":sb.toString();
        }
    }

    public static void main(String[] args) {
        String path = "//";
        String[] split = path.split("/");
        System.out.println(split.length);
        for (String s:split) {
            if (s.equals(""))
                System.out.print("@ ");
            System.out.print(s+" ");
        }
    }
}
