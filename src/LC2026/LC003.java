package LC2026;

import java.util.HashMap;
import java.util.Set;

public class LC003 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        HashMap<Character, Integer> record = new HashMap<>();
        int res = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char jc = s.charAt(j);
            boolean hasjc = record.getOrDefault(jc, 0) > 0;
            if (!hasjc) {
                record.put(jc, record.getOrDefault(jc, 0) + 1);
                res = Math.max(res, (j - i + 1));
                j++;
            } else {
                char lc = s.charAt(i);
                record.put(lc, record.get(lc)- 1);
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        new LC003().lengthOfLongestSubstring(s);
    }
}
