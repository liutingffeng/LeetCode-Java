package LCSolution;

import java.util.*;

public class LC406 {

    class Solution {
//        public int[][] reconstructQueue(int[][] people) {
//            Arrays.sort(people, (int[] a,int[] b)->{
//                return a[0] == b[0] ? a[1]-b[1] : b[0]-a[0];
//            });
//            LinkedList<int[]> list = new LinkedList<>();
//            for (int[] p:people){
//                list.add(p[1],p);
//            }
//
//            return list.toArray(people);
//        }

        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1]-o2[1]:o2[0]-o1[0]);

            List<int[]> list = new LinkedList<>();
            for (int i =0; i < people.length; i++) {
                int[] peo = people[i];
                list.add(peo[1],peo);
            }
            return list.toArray(people);
        }
    }
}
