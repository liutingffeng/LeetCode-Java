package LC2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC057 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int[][] intervals2 = new int[intervals.length + 1][2];
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < newInterval[0]) {
                intervals2[i] = intervals[i];
            } else {
                if (!inserted) {
                    intervals2[i] = newInterval;
                    inserted = true;
                }
                intervals2[i + 1] = intervals[i];
            }
        }
        if (!inserted) {
            intervals2[intervals.length] = newInterval;
        }
        List<int[]> res = new ArrayList<>();
        int l = 0, r = 0;
        while (r < intervals2.length) {
            if (intervals2[l][1] >= intervals2[r][0]) {
                intervals2[l][1] = Math.max(intervals2[l][1], intervals2[r][1]);
                r++;
            } else {
                res.add(intervals2[l]);
                l = r;
            }
        }
        res.add(intervals2[l]);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] res = new LC057().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));
    }
}
