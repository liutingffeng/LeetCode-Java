package LC200;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 *
 * 示例：
 *
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 */
public class LC163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            int x = lower;
            int y = upper;
            if (x == y) {
                res.add(x + "");
            } else {
                res.add(x + "->" + y);
            }
            return res;
        }

        int l = find1(nums, lower);
        int r = find2(nums, upper);

        int z = l;
        while (z <= r) {
            if (z == l) {
                if (lower < nums[z]) {
                    int x = lower;
                    int y = nums[z] - 1;
                    if (x == y) {
                        res.add(x + "");
                    } else {
                        res.add(x + "->" + y);
                    }
                }
            }
            if ((z + 1) <= r) {
                help(res, nums[z], nums[z + 1]);
            }
            if (z == r) {
                if (nums[z] < upper) {
                    int x = nums[z] + 1;
                    int y = upper;
                    if (x == y) {
                        res.add(x + "");
                    } else {
                        res.add(x + "->" + y);
                    }
                }
            }
            z++;
        }
        return res;
    }

    private void help (List<String> res, int lval, int rval) {
        if (rval - lval > 1) {
            int x = lval + 1;
            int y = rval - 1;
            if (x == y) {
                res.add(x + "");
            } else {
                res.add(x + "->" + y);
            }
        }
    }

    private int find1(int[] nums, int v) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid == v) {
                return v;
            }
            if (mid > v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int find2(int[] nums, int v) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (mid == v) {
                return v;
            }
            if (mid > v) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new LC163().findMissingRanges(new int[]{-1}, -2, -1);
    }
}
