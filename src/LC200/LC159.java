package LC200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
 *
 *
 * 输入：s = "eceba"
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 *
 * 输入：s = "ccaabbb"
 * 输出：5
 * 解释：满足题目要求的子串是 "aabbb" ，长度为 5 。
 */
public class LC159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2)
            return s.length();

        //
        int l = 0, r = l;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (r < s.length()) {
            if (!map.containsKey(s.charAt(r))) {
                if (map.keySet().size() >= 2) {
                    int v = map.get(s.charAt(l));
                    if (v == 1) {
                        map.remove(s.charAt(l));
                    } else {
                        map.put(s.charAt(l), v - 1);
                    }
                    l ++;
                    continue;
                }
            }
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            r ++;
            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
