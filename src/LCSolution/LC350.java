package LCSolution;

import java.util.*;

public class LC350 {

    class Solution {

        ///检查数组的大小并对较小的数组进行哈希映射是一个小细节，当其中一个数组较大时，会减少内存的使用。
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer,Integer> map1 = new HashMap<>();
            Map<Integer,Integer> map2 = new HashMap<>();
            for (int num:nums1)
                map1.put(num, map1.getOrDefault(num, 0)+1);
            for (int num:nums2)
                map2.put(num, map2.getOrDefault(num, 0)+1);

            List<Integer> list = new ArrayList<>();
            for (Integer key : map2.keySet()){
                if (map1.containsKey(key)){
                    int count = Math.min(map1.get(key), map2.get(key));
                    while (count-->0)
                        list.add(key);
                }
            }
            Integer[] array = list.toArray(new Integer[0]);
            int[] resArr = new int[array.length];
            for (int i=0;i<array.length;i++)
                resArr[i] = array[i];
            return resArr;
        }
    }
}
