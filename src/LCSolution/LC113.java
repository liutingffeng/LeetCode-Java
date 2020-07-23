package LCSolution;

import java.util.ArrayList;
import java.util.List;

public class LC113 {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            dfs(root, res, temp, sum);
            return res;
        }

        private void dfs(TreeNode root,List<List<Integer>> res,List<Integer> temp,int sum){
            if (root == null)
                return;
            if (root.left == null && root.right==null && root.val==sum){
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
                return;
            }

            temp.add(root.val);
            dfs(root.left, res, temp, sum-root.val);
            dfs(root.right, res, temp, sum-root.val);
            temp.remove(temp.size()-1);
        }
    }
}
