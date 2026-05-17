package LC2026;

import java.util.HashMap;
import java.util.Map;

public class LC076 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> recordT = new HashMap<>();
        for (char c : t.toCharArray()) {
            recordT.put(c, recordT.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int needs = recordT.size();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (r < s.length()) {
            char cur = s.charAt(r);
            if (recordT.containsKey(cur)) {
                recordT.put(cur, recordT.get(cur) - 1);
                if (recordT.get(cur) == 0) {
                    needs--;
                }
            }
            while (needs == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char lc = s.charAt(l++);
                if (recordT.containsKey(lc)) {
                    if (recordT.get(lc) == 0) {
                        needs++;
                    }
                    recordT.put(lc, recordT.get(lc) + 1);
                }
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


}
