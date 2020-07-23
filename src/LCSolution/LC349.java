package LCSolution;

import sync.Interrupted;

import javax.jnlp.IntegrationService;
import java.util.*;

public class LC349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> res = new HashSet<>();
            Set<Integer> set = new HashSet<>();
            for (int num:nums1)
                set.add(num);

            for (int num:nums2)
                if (set.contains(num))
                    res.add(num);

            int[] resArr = new int[res.size()];
            int index= 0;
            for (Object num: res.toArray())
                resArr[index++] = (int) num;
            return resArr;
        }
    }
}
