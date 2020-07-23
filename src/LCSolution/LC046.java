package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC046 {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] isVisited = new boolean[nums.length];
            func(nums, isVisited, res, new ArrayList<>());
            return res;
        }

        private void func(int[] nums,boolean[] isVisited,List<List<Integer>> res,List<Integer> temp){
            if (temp.size() == nums.length){
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i=0;i<nums.length;i++){
                if (!isVisited[i]){
                    temp.add(nums[i]);
                    isVisited[i] = true;
                    func(nums, isVisited, res, temp);
                    isVisited[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
