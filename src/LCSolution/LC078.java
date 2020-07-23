package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC078 {

    class Solution {
//        public List<List<Integer>> subsets(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            List<Integer> temp = new ArrayList<>();
//            int depth = 0;
//            boolean[] record = new boolean[nums.length];
//            fun(res, temp, nums, 0, record);
//            return res;
//        }
//
//        private void fun(List<List<Integer>> res,List<Integer> temp,int[] nums,int depth,boolean[] record){
//            if (depth == nums.length){
//                res.add(new ArrayList<>(temp));
//                return;
//            }
//
//
//            fun(res, temp, nums,depth+1,record);
//            if (!record[depth]){
//                    temp.add(nums[depth]);
//                    record[depth] = true;
//                    fun(res, temp, nums, depth+1, record);
//                    record[depth] = false;
//                    temp.remove(temp.size()-1);
//                }
//
//        }

//        public List<List<Integer>> subsets(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            res.add(new ArrayList<>());
//            for (int i = 0;i<nums.length;i++){
//                int sub = res.size();
//                for (int j=0;j<sub;j++){
//                    List<Integer> temp = new ArrayList<>(res.get(j));
//                    temp.add(nums[i]);
//                    res.add(temp);
//                }
//            }
//            return res;
//        }

//        public List<List<Integer>> subsets(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            if (nums == null || nums.length ==0)
//                return res;
//            recursion(nums, new ArrayList<>(), res, 0);
//            return res;
//        }
//
//        private void recursion(int[] nums,List<Integer> temp,List<List<Integer>> res,int depth){
//            if (depth == nums.length){
//                res.add(new ArrayList<>(temp));
//                return;
//            }
//
//            temp.add(nums[depth]);
//            recursion(nums, temp, res, depth+1);
//            temp.remove(temp.size()-1);
//            recursion(nums, temp, res, depth+1);
//        }


        // 比如说有 nums {1,2,3}
        //  总共有 8种可能的集合
        //  001 010 100 分别代表 index 为 0 ，1，2 位置上的数据
        //  i 从 0 - 7 , 分别与3个位置做&运算 ，如果结果为1 ，则把该位置的值加入集合
        public List<List<Integer>> subsets(int[] nums) {
            //位运算
            int all = 1<<(nums.length);
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < all; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j=0;j<nums.length;j++){
                    if ((i & (1<<j)) > 0 ){
                        temp.add(nums[j]);
                    }
                }
                res.add(temp);
            }
            return res;
        }
    }
}
