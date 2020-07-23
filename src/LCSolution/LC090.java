package LCSolution;

import java.util.*;

public class LC090 {

    class Solution {
//        public List<List<Integer>> subsetsWithDup(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            Arrays.sort(nums);
//            func(nums, 0, res, new ArrayList<>());
//            return res;
//        }
//
//        private void func(int[] nums,int index,List<List<Integer>> res,List<Integer> temp){
//            res.add(new ArrayList<>(temp));
//
//            for (int i=index;i<nums.length;i++){
//                if (i>index && nums[i] == nums[i-1])
//                    continue;
//                temp.add(nums[i]);
//                func(nums, i+1, res, temp);
//                temp.remove(temp.size()-1);
//            }
//        }


        // {}
        // {} {1}   l=0,r=1,len=1
        // {} {1} {2} {1,2}  l=0,r=2,len=2
        //                  l=2,r=4, len=2;
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            res.add(new ArrayList<>());
            int left = 0, right = 1 ,len = 0;
            for (int i = 0; i < nums.length; i++) {
                left = 0;
                if (i!=0 && (nums[i] == nums[i-1]))
                    left = res.size()-len;

                right = res.size();
                len = right-left;
                for (int j = left; j < right; j++) {
                    List<Integer> temp = new ArrayList<>(res.get(j));
                    temp.add(nums[i]);
                    res.add(temp);
                }
            }

            return res;
        }
    }
}
