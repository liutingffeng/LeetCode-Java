package LCSolution;

import java.util.*;

public class LC347 {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int num:nums){
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            List<int[]> temp = new ArrayList<>();
            for (int key:map.keySet()){
                temp.add(new int[]{key,map.get(key)});
            }
            Queue<int[]> queue = new PriorityQueue<>((int[] a,int[] b)->a[1]-b[1]);
            for (int[] pairs:temp) {
                if (queue.size()<k)
                    queue.add(pairs);
                else {
                    if (queue.peek()[1]<pairs[1]){
                        queue.poll();
                        queue.add(pairs);
                    }
                }
            }
            int[] res = new int[k];
            int index = 0;
            while (!queue.isEmpty())
                res[index++] =  queue.poll()[1];

            return res;
        }
    }
}
