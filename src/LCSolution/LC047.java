package LCSolution;

import java.util.*;

public class LC047 {

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            boolean[] isVisited = new boolean[nums.length];
            dfs(nums, isVisited, res, new ArrayList<>());
            return res;
        }

        private void dfs(int[] nums,boolean[] visited,List<List<Integer>> res,List<Integer> temp){
            if (temp.size() == nums.length){
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i=0;i<nums.length;i++){
                if (!visited[i]){
                    if (i<nums.length-1 && nums[i]==nums[i+1] && visited[i+1])
                        return;
                    temp.add(nums[i]);
                    visited[i] = true;
                    dfs(nums, visited, res, temp);
                    visited[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().permuteUnique(new int[]{1,1,2});
    }
}
