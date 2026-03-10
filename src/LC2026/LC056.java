package LC2026;

import java.util.*;

public class LC056 {

    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int l = 0, r = 0;
        while (r < intervals.length) {
            if (intervals[l][1] >= intervals[r][0]) {
                intervals[l][1] = Math.max(intervals[l][1], intervals[r][1]);
                r++;
            } else {
                res.add(intervals[l]);
                l = r;
            }
        }
        res.add(intervals[l]);
        return res.toArray(new int[0][]);
    }
}
