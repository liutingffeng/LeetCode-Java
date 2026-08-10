package LC2026.sixMonth;

import java.util.HashMap;
import java.util.Map;

public class LC076 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int need = map.size();
        int l = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    need--;
                }
            }
            while (need == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char lc = s.charAt(l++);
                if (map.containsKey(lc)) {
                    if (map.get(lc) == 0) {
                        need++;
                    }
                    map.put(lc, map.get(lc) + 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
