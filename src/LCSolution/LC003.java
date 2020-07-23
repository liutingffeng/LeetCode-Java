package LCSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC003 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0)
                return 0;
            Set<Character> set = new HashSet<>();
            int left = 0;
            int right = 0;
            int res = 0;
            while (right<s.length()){
                if (!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    int curL = right-left+1;
                    res = Math.max(res, curL);
                    right ++ ;
                } else {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            return res;
        }
    }
}
