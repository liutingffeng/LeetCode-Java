package LC200;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 整数可以被看作是其因子的乘积。
 *
 * 例如：
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 *
 * 注意：
 *
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 *
 * 输入: 1
 * 输出: []
 * 示例 2：
 *
 * 输入: 37
 * 输出: []
 * 示例 3：
 *
 * 输入: 12
 * 输出:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * 示例 4:
 *
 * 输入: 32
 * 输出:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 *
 */
public class LC254 {

    private static Map<Integer, Set<List<Integer>>> dp = new HashMap<>();
    // dp
    public List<List<Integer>> getFactors(int n) {
        if (n <= 2) {
            return new ArrayList<>();
        }
        if (dp.containsKey(n))
            return dp.get(n).stream().collect(Collectors.toList());

        Set<List<Integer>> res = new HashSet<>();
        for (int i = 2; i < n; i++) {
            if (i * i > n)
                break;

            if (n % i != 0)
                continue;
            //
            res.add(Arrays.asList(i, n / i));
            List<List<Integer>> last = getFactors(n / i);
            if (last != null && last.size() > 0) {
                for (List<Integer> cur : last) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(i);
                    cur.forEach(v -> newList.add(v));
                    newList.sort(Comparator.naturalOrder());
                    res.add(newList);
                }
            }
        }
        dp.put(n, res);
        return res.stream().collect(Collectors.toList());
    }


    public static void main(String[] args) {
        int n = 37;
        System.out.println(n % 2);
    }
}
