package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            Map<Character,Integer> needs = new HashMap<>();
            Map<Character,Integer> window = new HashMap<>();

            for (char c:p.toCharArray()){
                needs.put(c, needs.getOrDefault(c, 0)+1);
            }

            int valid = 0;
            int left = 0,right = 0;  // [left,right)
            while (right<s.length()){
                //要放入窗口的字符
                char c = s.charAt(right);
                right++;
                if (needs.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(needs.get(c)))
                        valid++;
                }

                //左移
                while (valid == needs.size()){
                    if (right-left == p.length()){
                        res.add(left);
                    }
                    char temp = s.charAt(left++);
                    if (needs.containsKey(temp)) {
                        window.put(temp, window.get(temp) - 1);
                        if (window.get(temp).compareTo(needs.get(temp))<0)
                            valid--;
                    }
                }
            }
            return res;
        }
    }
}
