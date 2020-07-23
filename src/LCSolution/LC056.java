package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC056 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            //左端点从小到大排序
            Arrays.sort(intervals, (v1,v2)->v1[0]-v2[0]);
            int[][] res = new int[intervals.length][2];
            int index = -1;
            for (int[] element : intervals){
                //如果res中为空，或者当前区间的大于结果集中最大的下标，直接加入，不用合并
                if (index == -1 || (element[0] > res[index][1])){
                    res[++index] = element;
                }
                //合并区间
                else {
                    res[index][1] = Math.max(res[index][1],element[1]);
                }
            }
            return Arrays.copyOf(res, index+1);
        }
    }
}
