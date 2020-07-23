package LCSolution;

import java.util.ArrayList;
import java.util.List;

public class LC257 {

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            dfs(root, res, temp);
            return res;
        }

        private void dfs(TreeNode root,List<String> res,List<Integer> temp){
            if (root == null)
                return;
            if (root.left == null && root.right==null){
                StringBuilder sb = new StringBuilder();
                for (int i:temp){
                    sb.append(String.valueOf(i)).append("->");
                }
                sb.append(String.valueOf(root.val));
                res.add(sb.toString());
                return;
            }

            temp.add(root.val);
            dfs(root.left, res, temp);
            dfs(root.right, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}
