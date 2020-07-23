package LCSolution;

import java.util.*;

public class LC104 {

    class Solution {

        //递归
//        public int maxDepth(LCSolution.TreeNode root) {
//            if (root == null)
//                return 0;
//            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//        }

        //BFS
        public int maxDepth(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            int res = 0;
            if (root == null)
                return res;
            queue.add(root);
            while (!queue.isEmpty()){
                int count = queue.size();
                TreeNode cur ;
                while (count-- > 0){
                    cur = queue.poll();
                    if (cur.left!=null)
                        queue.add(cur.left);
                    if (cur.right!=null)
                        queue.add(cur.right);
                }
                res++;
            }
            return res;
        }
    }
}
