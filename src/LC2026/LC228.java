package LC2026;

import java.util.ArrayList;
import java.util.List;

public class LC228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        int l = 0;
        int lv = 0;
        int s = 0;
        while (s < nums.length) {
            if (l == s) {
                lv = nums[s];
                s++;
                continue;
            }
            if (nums[s] == (lv + 1)) {
                s++;
                lv++;
            } else {
                help(res, nums, l, s - 1);
                l = s;
            }
        }
        help(res, nums, l, s - 1);
        return res;
    }

    private void help(List<String> res, int[] nums, int l, int r) {
        if (l == r) {
            res.add(String.valueOf(nums[l]));
        } else {
            res.add(nums[l] + "->" + nums[r]);
        }
    }
}
