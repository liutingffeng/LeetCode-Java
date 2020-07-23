package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC216 {

    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            fun(k, n, 1, res, new ArrayList<>());
            return res;
        }

        private void fun(int k,int n,int index,List<List<Integer>> res,List<Integer> temp){
            if (temp.size() == k && n==0){
                res.add(new ArrayList<>(temp));
                return;
            }
            if (temp.size()>k)
                return;

            for (int i=index;i<=9 && n-i>=0;i++){
                temp.add(i);
                fun(k, n-i, i+1, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
