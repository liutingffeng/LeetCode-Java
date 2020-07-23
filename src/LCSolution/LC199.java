package LCSolution;

import java.util.*;

public class LC199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null)
                return res;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int count = queue.size();
                res.add(queue.peekLast().val);
                TreeNode cur;
                while (count-->0){
                    cur = queue.pollFirst();
                    if (cur.left!=null)
                        queue.offer(cur.left);
                    if (cur.right!=null)
                        queue.offer(cur.right);
                }
            }
            return res;
        }
    }
}
