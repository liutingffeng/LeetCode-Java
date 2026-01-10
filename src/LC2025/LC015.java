package LC2025;

import java.util.*;

public class LC015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> cf = new HashSet<>();
        Set<Integer> cf2 = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if (cf.contains(first)) {
                continue;
            }
            cf.add(first);
            int j = i + 1;
            int k = nums.length - 1;
            cf2.clear();
            while (j < k) {
                int second = nums[j];
                int third =nums[k];
                int sum = second + third;
                if (sum + first == 0) {
                    if (cf2.contains(second)) {
                        k --;
                        continue;
                    }
                    cf2.add(second);
                    res.add( Arrays.asList(first, second, third));
                    k --;
                } else if (sum + first < 0) {
                    j ++;
                } else {
                    k --;
                }
            }
        }
        return res;
    }
}
