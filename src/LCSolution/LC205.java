package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC205 {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length()!=t.length())
                return false;
            Map<Character,Character> map = new HashMap<>();
            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();
            for (int i = 0;i<schar.length;i++){
                if (map.containsKey(schar[i])){
                    if (map.get(schar[i])!=tchar[i])
                        return false;
                }
                else {
                    if (map.containsValue(tchar[i]))
                        return false;
                    map.put(schar[i],tchar[i]);
                }
            }
            return true;
        }
    }
}
