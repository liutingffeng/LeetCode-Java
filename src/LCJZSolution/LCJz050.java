package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz050 {

    class Solution {
        public char firstUniqChar(String s) {
            if (s == null || s.length() == 0)
                return ' ';
            int[] map = new int[26];
            for (int i=0;i<s.length();i++)
                map[s.charAt(i)-'a']++;

            for (int i=0;i<s.length();i++)
                if (map[s.charAt(i)-'a']==1)
                    return s.charAt(i);
            return ' ';
        }
    }
}
