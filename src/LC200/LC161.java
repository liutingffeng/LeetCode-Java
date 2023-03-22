package LC200;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。
 *
 * 字符串 s 和字符串 t 之间满足编辑距离等于 1 有三种可能的情形：
 *
 * 往 s 中插入 恰好一个 字符得到 t
 * 从 s 中删除 恰好一个 字符得到 t
 * 在 s 中用 一个不同的字符 替换 恰好一个 字符得到 t
 */
public class LC161 {

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }

        if (s.length() - t.length() > 1)
            return false;

        if (s.length() == t.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diff ++;
                }
                if (diff > 1)
                    return false;
            }
            return diff == 1;
        }

        boolean hasRemove = false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (hasRemove)
                    return false;
                hasRemove = true;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
