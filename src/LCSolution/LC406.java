package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC406 {

    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (int[] a,int[] b)->{
                return a[0] == b[0] ? a[1]-b[1] : b[0]-a[0];
            });
            LinkedList<int[]> list = new LinkedList<>();
            for (int[] p:people){
                list.add(p[1],p);
            }

            return list.toArray(people);
        }
    }
}
