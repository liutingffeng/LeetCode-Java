package LC2026;

import java.util.Arrays;

/**
 * @Author liutingfeng
 * @Date 2026/7/31 10:18
 */
public class LCzijie001 {

    /**
     * 给定一个数n，如23121，给定一组数字a,如｛2，4，9｝，求a中元素组成的小于n的最大数，如小于23121的最大数为22999
     * <p>
     * 思路：贪心 + 回溯
     * 1. 从高位到低位逐位构造，每位尽量取「不超过 n 对应位」的最大可用数字；
     * 2. 一旦某位取的数字比 n 的对应位小，后面所有位直接填可用数字中的最大值（结果一定小于 n 且最大）；
     * 3. 如果某位没有「不超过 n 对应位」的可用数字，或者最终构造出的数恰好等于 n（不满足严格小于），
     *    就需要回溯：从右往左找到第一个可以「换成更小可用数字」的位置，换掉后后面的位全部填最大值；
     * 4. 如果回溯到最高位都找不到更小的可用数字，说明同位数无解，答案就是「位数少一位、全部由最大数字组成」的数。
     */

    public static int findMax(int n, int[] digits) {
        // 第一步：预处理，把可用数字排序，并记录最大数字（用于后面"补位"）
        int[] sorted = digits.clone();
        Arrays.sort(sorted);
        int maxDigit = sorted[sorted.length - 1];

        // 把 n 拆成字符数组，方便逐位比较
        char[] s = String.valueOf(n).toCharArray();
        int len = s.length;
        char[] res = new char[len];

        // 第二步：从高位到低位贪心构造
        for (int i = 0; i < len; i++) {
            int cur = s[i] - '0';
            // 在可用数字中找「不超过 cur 的最大数字」
            int chosen = -1;
            for (int d : sorted) {
                if (d <= cur) {
                    chosen = d; // sorted 升序，遍历完 chosen 就是 <= cur 的最大值
                }
            }

            // 情况1：当前位找不到任何 <= cur 的可用数字，只能回溯到前面某位"降级"
            if (chosen == -1) {
                return backtrack(res, i, sorted, maxDigit, len);
            }

            res[i] = (char) ('0' + chosen);

            // 情况2：当前位选的数字比 n 对应位小，后面的位全部填最大数字即可直接返回
            if (chosen < cur) {
                for (int j = i + 1; j < len; j++) {
                    res[j] = (char) ('0' + maxDigit);
                }
                return Integer.parseInt(new String(res));
            }
            // 情况3：chosen == cur，与 n 保持一致，继续处理下一位
        }

        // 第三步：能走到这里说明每一位都和 n 完全相同，构造出的数 == n，
        // 但题目要求"严格小于 n"，所以从最后一位开始回溯"降级"
        return backtrack(res, len, sorted, maxDigit, len);
    }

    /**
     * 回溯：从 rightBound-1 位开始往左找，找到第一个能换成「更小可用数字」的位置，
     * 换掉后该位置之后的所有位全部填最大数字。
     *
     * @param res       当前已构造的前缀（res[0..rightBound-1] 有效）
     * @param rightBound 回溯的起始边界（从 rightBound-1 往左找）
     * @param sorted    升序的可用数字
     * @param maxDigit  最大可用数字，用于补位
     * @param len       n 的位数
     * @return 回溯成功返回结果；同位数无解时返回「少一位、全部由最大数字组成」的数
     */
    private static int backtrack(char[] res, int rightBound, int[] sorted, int maxDigit, int len) {
        // 从右往左找可以"降级"的位置
        for (int j = rightBound - 1; j >= 0; j--) {
            int curDigit = res[j] - '0';
            // 在可用数字中找「严格小于 curDigit 的最大数字」
            int smaller = -1;
            for (int d : sorted) {
                if (d < curDigit) {
                    smaller = d;
                }
            }
            // 最高位不能换成 0（否则位数会变少，等同于少一位的情况，交给最后的兜底逻辑处理）
            if (j == 0 && smaller == 0) {
                continue;
            }
            if (smaller != -1) {
                // 找到可降级的位置：换掉这一位
                res[j] = (char) ('0' + smaller);
                // 后面的位全部填最大数字，保证结果最大
                for (int k = j + 1; k < len; k++) {
                    res[k] = (char) ('0' + maxDigit);
                }
                return Integer.parseInt(new String(res));
            }
        }
        // 同位数无解：答案为「位数少一位、全部由最大数字组成」的数
        // 例如 n=1000, digits={2,4,9} -> 999
        if (len == 1) {
            return -1; // 个位数且无解，不存在更小的正整数
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            sb.append(maxDigit);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        int[] digits = {2, 4, 9};

        // 过程演示：2==2 保持 -> 3 无匹配，选比 3 小的最大数字 2 -> 后面全填 9
        System.out.println(findMax(23387, digits)); // 22999
        System.out.println(findMax(23121, digits)); // 22999

        // 其他边界用例
        System.out.println(findMax(999, digits));   // 994（构造出 999 == n，回溯降级末位 9 -> 4）
        System.out.println(findMax(1000, digits));  // 999（同位数无解，少一位全填最大数字）
        System.out.println(findMax(2222, digits));  // 999（2222 == n，每一位都无法再降级）
        System.out.println(findMax(4, digits));     // 2（个位数，唯一小于 4 的可用数字）
    }
}
