package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC986 {

    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> res = new ArrayList<>();
            int i=0;
            int j=0;
            while (i<A.length && j<B.length){
                int[] a = A[i];
                int[] b = B[j];
                // 有交集
                if (a[1]>=b[0] && b[1]>=a[0]){
                    int[] r = new int[2];
                    r[0] = Math.max(a[0],b[0]);
                    r[1] = Math.min(a[1],b[1]);
                    res.add(r);
                }
                //
                if (a[1]>b[1])
                    j++;
                else
                    i++;
            }
            return res.toArray(new int[0][0]);
        }
    }
}
