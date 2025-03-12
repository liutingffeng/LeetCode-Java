package LC2025;

import java.util.HashSet;
import java.util.Set;

public class LC003 {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 1)
            return s.length();
        int l = 0;
        int r = 0;
        int length = s.length();
        int res = 0;
        // hash
        Set<Character> cSet = new HashSet<>();
        while (r < length) {
            char c = s.charAt(r);
            // 不包含
            if (!cSet.contains(c)){
                cSet.add(c);
                res = Math.max(res, cSet.size());
                r ++;
                continue;
            }
            // 包含了，左边界往右滑动
            char lc = s.charAt(l);
            cSet.remove(lc);
            l ++;
        }
        return res;
    }
}
