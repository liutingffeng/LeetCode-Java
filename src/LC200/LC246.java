package LC200;

import java.util.HashMap;
import java.util.Map;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 *
 *输入: num = "69"
 * 输出: true
 * 示例 2:
 *
 * 输入: num = "88"
 * 输出: true
 * 示例 3:
 *
 * 输入: num = "962"
 * 输出: false
 * 示例 4：
 *
 * 输入：num = "1"
 * 输出：true
 */
public class LC246 {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (l == r) {
                if (num.charAt(l) == '0' || num.charAt(l) == '1' || num.charAt(l) == '8')
                    return true;
                return false;
            }
            if (!map.containsKey(num.charAt(l)))
                return false;
            if (map.get(num.charAt(l)) != num.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
