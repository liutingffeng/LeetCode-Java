package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC447 {

    class Solution {


//        public int numberOfBoomerangs(int[][] points) {
//            Map<Double,Map<int[],Integer>> map = new HashMap<>();
//
//            for (int i = 0; i < points.length; i++) {
//                for (int j = i+1; j < points.length; j++) {
//                    double distance = computeDistance(points[i], points[j]);
//                    if (!map.containsKey(distance)){
//                        map.put(distance, new HashMap<>());
//                    }
//                    Map<int[], Integer> mapval = map.get(distance);
//                    mapval.put(points[i],mapval.getOrDefault(points[i],0)+1);
//                    mapval.put(points[j],mapval.getOrDefault(points[j],0)+1);
//                }
//            }
//
//            int res = 0;
//            for (Map<int[],Integer> valmap : map.values()){
//                for (int[] e : valmap.keySet()){
//                    if (valmap.get(e)>1){
//                        int num = valmap.get(e);
//                        res += num*(num-1);
//                    }
//                }
//            }
//            return res;
//        }

        private int computeDistance(int[] a, int[] b){
            return (int) (Math.pow(a[0]-b[0],2)+Math.pow(a[1]-b[1],2));
        }

        public int numberOfBoomerangs(int[][] points) {
            Map<Integer,Integer> map = new HashMap<>();

            int res = 0;
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points.length; j++) {
                    if (i!=j){
                        int distance = computeDistance(points[i], points[j]);
                        int n = map.getOrDefault(distance, 0);
                        if (n>0)
                            res += 2*n;
                        map.put(distance, n+1);
                    }
                }
                map.clear();
            }

            return res;
        }
    }

}
