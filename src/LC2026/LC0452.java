package LC2026;

import java.util.Arrays;

public class LC0452 {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // 按结束坐标排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1]; // 第一支箭射在第一个区间结束位置

        for (int i = 1; i < points.length; i++) {
            // 如果当前气球的起始位置 > 箭的位置，需要新射一支箭
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}
