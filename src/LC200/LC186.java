package LC200;

/**
 * 给你一个字符数组 s ，反转其中 单词 的顺序。
 *
 * 单词 的定义为：单词是一个由非空格字符组成的序列。s 中的单词将会由单个空格分隔。
 *
 * 必须设计并实现 原地 解法来解决此问题，即不分配额外的空间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出：["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 示例 2：
 *
 * 输入：s = ["a"]
 * 输出：["a"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LC186 {

    public void reverseWords(char[] s) {
        if (s.length <= 1)
            return;
        // 反转
        help(s, 0, s.length - 1);
        // 寻找单词
        int l = 0, r = 0;
        while (r <= s.length) {
            if (r == s.length || s[r] == ' ') {
                //
                help(s, l , r -1);
                r++;
                l = r;
            } else {
                r++;
            }
        }
    }

    private void help(char[] s, int l, int r) {
        while (l < r) {
            char t = s[l];
            s[l++] = s[r];
            s[r--] = t;
        }
    }

    public static void main(String[] args) {
    }
}
