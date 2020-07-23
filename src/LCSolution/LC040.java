package LCSolution;

import java.util.*;

public class LC040 {

    class Solution {
//        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//            List<List<Integer>> res = new ArrayList<>();
//            //排序，有一位超出范围，后面的都不用算了，提前终止
//            Arrays.sort(candidates);
//            func(candidates, target, 0, res, new ArrayList<>());
//            return res;
//        }
//
//        private void func(int[] candidates,int target,int index,List<List<Integer>> res,List<Integer> temp){
//            if (target<0)
//                return;
//            if (target == 0){
//                res.add(new ArrayList<>(temp));
//                return;
//            }
//
//            for (int i=index;i<candidates.length;i++){
//                if (i>index && candidates[i]==candidates[i-1])
//                    continue;
//                temp.add(candidates[i]);
//                func(candidates, target-candidates[i],i+1, res, temp);
//                temp.remove(temp.size()-1);
//            }
//        }


        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            //排序，有一位超出范围，后面的都不用算了，提前终止
            Arrays.sort(candidates);
            recusion(candidates, target, res, new ArrayList<>(), 0);
            return res;
        }

        private void recusion(int[] candidates, int target,List<List<Integer>> res,List<Integer> temp,int start){
            if (target<0)
                return;

            if (target == 0) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i>start && (candidates[i]==candidates[i-1]))
                    continue;

                temp.add(candidates[i]);
                recusion(candidates, target-candidates[i],res,temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
