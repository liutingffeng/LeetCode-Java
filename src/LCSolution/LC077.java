package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC077 {

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(n, k, 1, res, new ArrayList<>());
            return res;
        }

        private void dfs(int n,int k,int index,List<List<Integer>> res,List<Integer> temp){
            if (temp.size() == k){
                res.add(new ArrayList<>(temp));
                return;
            }

            //剪枝
            for (int i=index;i<=n-(k-temp.size())+1;i++){
                temp.add(i);
                dfs(n, k, i+1, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
