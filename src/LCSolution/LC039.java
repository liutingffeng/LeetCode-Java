package LCSolution;

import java.util.*;

public class LC039 {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            //排序，有一位超出范围，后面的都不用算了，提前终止
            Arrays.sort(candidates);
            //引入start是为了去重
            func(candidates, target, res, temp, 0,0);
            return res;

        }

        private void func(int[] candidates, int target,List<List<Integer>> res,List<Integer> temp,int curCount,int i){
            if (curCount > target){
                return;
            }
            if (curCount == target){
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int start = i;start<candidates.length;start++){
                int curValue = candidates[start];
                temp.add(curValue);
                curCount += curValue;
                func(candidates, target, res, temp, curCount,start);
                curCount -= curValue;
                temp.remove(temp.size()-1);
            }
        }
    }
}
