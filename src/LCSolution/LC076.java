package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC076 {

    class Solution {
        public String minWindow(String s, String t) {
            if (t.length()>s.length())
                return "";

            //t的
            Map<Character,Integer> needs = new HashMap<>();
            //窗口里的
            Map<Character,Integer> window = new HashMap<>();
            //初始化t
            for (int i=0;i<t.length();i++){
                //needs.getOrDefault(t.charAt(i),0)+1 含义是：needs如果包含t.charAt(i)，
                //则取出值+1;不包含取0+1
                needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0)+1);
            }

            //解的开始和结束
            int start = 0,end = 0;
            int minLen = Integer.MAX_VALUE;
            int left = 0,right = 0;
            int valid = 0;
            //滑动窗口 [left,right)
            while (right<s.length()){
                //将right处的字符加入窗口
                char temp = s.charAt(right);

                window.put(temp, window.getOrDefault(temp, 0)+1);
                if (needs.containsKey(temp)){
                    if (needs.get(temp).compareTo(window.get(temp))==0)
                        valid++;
                }

                right++;
                while (valid == needs.size()){

                    if (right-left < minLen){
                        start = left;
                        end = right;
                        minLen = end-start;
                    }
                    //移除left处字符
                    char c = s.charAt(left);
                    window.put(c, window.get(c)-1);
                    left++;
                    if (needs.containsKey(c)){
                        if (window.get(c)<needs.get(c))
                            valid--;
                    }
                }
            }

            return minLen == Integer.MAX_VALUE? "":s.substring(start, end);
        }
    }
}
