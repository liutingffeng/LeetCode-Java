package LCSolution;

import java.util.*;

public class LC102 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            List<List<Integer>> res= new ArrayList<>();
            if (root == null)
                return res;
            queue.add(root);
            while (!queue.isEmpty()){
                int count = queue.size();
                List<Integer> temp = new ArrayList<>();
                TreeNode cur ;
                while (count-- > 0){
                    cur = queue.poll();
                    temp.add(cur.val);
                    if (cur.left!=null)
                        queue.add(cur.left);
                    if (cur.right!=null)
                        queue.add(cur.right);
                }
                res.add(temp);
            }
            return res;
        }
    }
}
