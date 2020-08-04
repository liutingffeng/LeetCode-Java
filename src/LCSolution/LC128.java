package LCSolution;

import com.sun.org.apache.xerces.internal.impl.msg.XMLMessageFormatter_ja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC128 {

    class Solution {

        //HashSet 去重
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length==0)
                return 0;
            Set<Integer> set = new HashSet<>();
            for (int i:nums)
                set.add(i);

            int longSec = 1;
            int longCur = 1;

            for (int num:nums){

                //以num为起点
                if (!set.contains(num-1)){
                    longCur = 1;
                    while (set.contains(num+1)){
                        longCur++;
                        num++;
                    }
                    longSec = Math.max(longSec, longCur);
                }
            }
            return longSec;

        }

//        public int longestConsecutive(int[] nums) {
//            if (nums == null || nums.length == 0)
//                return 0;
//            Set<Integer> set = new HashSet<>();
//            for (int num:nums)
//                set.add(num);
//
//            int longest = 1;
//            int curlong = 1;
//            for (int num : nums){
//                curlong = 1;
//                if (!set.contains(num-1)) {
//                    while (set.contains(num+1)) {
//                        num += 1;
//                        curlong++;
//                    }
//                }
//
//                longest = Math.max(curlong, longest);
//            }
//            return longest;
//        }
    }
}
